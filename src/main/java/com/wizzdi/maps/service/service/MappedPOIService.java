package com.wizzdi.maps.service.service;

import ch.hsr.geohash.GeoHash;
import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.model.SecuredBasic_;
import com.flexicore.model.territories.Address;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.flexicore.security.service.BaseclassService;
import com.wizzdi.flexicore.security.service.BasicService;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.service.data.MappedPOIRepository;
import com.wizzdi.maps.service.request.GeoHashRequest;
import com.wizzdi.maps.service.request.MappedPOICreate;
import com.wizzdi.maps.service.request.MappedPOIFilter;
import com.wizzdi.maps.service.request.MappedPOIUpdate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import javax.persistence.metamodel.SingularAttribute;

import com.wizzdi.maps.service.response.GeoHashResponse;
import org.pf4j.Extension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@Extension
public class MappedPOIService implements Plugin, IMappedPOIService {

    private static final Logger logger= LoggerFactory.getLogger(MappedPOIService.class);
    @Autowired
    private MappedPOIRepository repository;

    @Autowired
    private BasicService basicService;
    private static final Map<String, Method> setterCache = new ConcurrentHashMap<>();


  /**
   * @param mappedPOICreate
   * @param securityContext
   * @return created MappedPOI
   */
  @Override
  public MappedPOI createMappedPOI(
      MappedPOICreate mappedPOICreate, SecurityContextBase securityContext) {
    MappedPOI mappedPOI = createMappedPOINoMerge(mappedPOICreate, securityContext);
    this.repository.merge(mappedPOI);
    return mappedPOI;
  }

    /**
     * @param mappedPOICreate
     * @param securityContext
     * @return created MappedPOI unmerged
     */
    @Override
    public MappedPOI createMappedPOINoMerge(
            MappedPOICreate mappedPOICreate, SecurityContextBase securityContext) {
        MappedPOI mappedPOI = new MappedPOI();
        mappedPOI.setId(UUID.randomUUID().toString());
        updateMappedPOINoMerge(mappedPOICreate, mappedPOI);

        BaseclassService.createSecurityObjectNoMerge(mappedPOI, securityContext);

        return mappedPOI;
    }

    /**
     * @param mappedPOICreate
     * @param mappedPOI
     * @return if mappedPOI was updated
     */
    @Override
    public boolean updateMappedPOINoMerge(MappedPOICreate mappedPOICreate, MappedPOI mappedPOI) {
        boolean update = basicService.updateBasicNoMerge(mappedPOICreate, mappedPOI);
        boolean updateLocation = false;
        if (mappedPOICreate.getAddress() != null
                && (mappedPOI.getAddress() == null
                || !mappedPOICreate.getAddress().getId().equals(mappedPOI.getAddress().getId()))) {
            mappedPOI.setAddress(mappedPOICreate.getAddress());
            update = true;
        }



        if (mappedPOICreate.getLat() != null
                && (!mappedPOICreate.getLat().equals(mappedPOI.getLat()))) {
            mappedPOI.setLat(mappedPOICreate.getLat());
            update = true;
            updateLocation = true;
        }


        if (mappedPOICreate.getX() != null && (!mappedPOICreate.getX().equals(mappedPOI.getX()))) {
            mappedPOI.setX(mappedPOICreate.getX());
            update = true;
        }

        if (mappedPOICreate.getY() != null && (!mappedPOICreate.getY().equals(mappedPOI.getY()))) {
            mappedPOI.setY(mappedPOICreate.getY());
            update = true;
        }

        if (mappedPOICreate.getZ() != null && (!mappedPOICreate.getZ().equals(mappedPOI.getZ()))) {
            mappedPOI.setZ(mappedPOICreate.getZ());
            update = true;
        }

        if (mappedPOICreate.getLon() != null
                && (!mappedPOICreate.getLon().equals(mappedPOI.getLon()))) {
            mappedPOI.setLon(mappedPOICreate.getLon());
            update = true;
            updateLocation = true;

        }
        if (mappedPOICreate.getMapIcon() != null
                && (mappedPOI.getMapIcon() == null
                || !mappedPOICreate.getMapIcon().getId().equals(mappedPOI.getMapIcon().getId()))) {
            mappedPOI.setMapIcon(mappedPOICreate.getMapIcon());
            update = true;
        }
        if (updateLocation) {
            generateGeoHash(mappedPOI);
        }

        return update;
    }

    public void generateGeoHash(MappedPOI mappedPOI) {
        try {
            for (int i = 1; i < 13; i++) {
                String setterName = "setGeoHash" + i;
                try {
                    String geoHash = GeoHash
                            .geoHashStringWithCharacterPrecision(
                                    mappedPOI.getLat(), mappedPOI.getLon(), i);
                    Method method = setterCache.computeIfAbsent(setterName,
                            f -> getSetterOrNull(f));
                    if (method != null) {
                        method.invoke(mappedPOI, geoHash);

                    }
                } catch (InvocationTargetException | IllegalAccessException e) {
                    logger.error("could not set property "
                            + setterName + " via setter");
                }

            }
        } catch (Exception e) {
            logger.error("unable to generate geo hash for mappedPOI " + mappedPOI.getId() + " (" + mappedPOI.getId() + ")");
        }
    }
    private Method getSetterOrNull(String name) {
        try {
            return MappedPOI.class.getMethod(name, String.class);
        } catch (NoSuchMethodException e) {
            logger.error("unable to get setter", e);
        }
        return null;
    }

    /**
     * @param mappedPOIUpdate
     * @param securityContext
     * @return mappedPOI
     */
    @Override
    public MappedPOI updateMappedPOI(
            MappedPOIUpdate mappedPOIUpdate, SecurityContextBase securityContext) {
        MappedPOI mappedPOI = mappedPOIUpdate.getMappedPOI();
        if (updateMappedPOINoMerge(mappedPOIUpdate, mappedPOI)) {
            repository.merge(mappedPOI);
        }
        return mappedPOI;
    }

  /**
   * @param mappedPOIFilter
   * @param securityContext
   * @return PaginationResponse containing paging information for MappedPOI
   */
  @Override
  public PaginationResponse<MappedPOI> getAllMappedPOIs(
      MappedPOIFilter mappedPOIFilter, SecurityContextBase securityContext) {
    List<MappedPOI> list = listAllMappedPOIs(mappedPOIFilter, securityContext);
    long count = this.repository.countAllMappedPOIs(mappedPOIFilter, securityContext);
    return new PaginationResponse<>(list, mappedPOIFilter, count);
  }

  /**
   * @param mappedPOIFilter
   * @param securityContext
   * @return List of MappedPOI
   */
  @Override
  public List<MappedPOI> listAllMappedPOIs(
      MappedPOIFilter mappedPOIFilter, SecurityContextBase securityContext) {
    return repository.listAllMappedPOIs(mappedPOIFilter, securityContext);
  }

    /**
     * @param mappedPOIFilter
     * @param securityContext
     * @throws ResponseStatusException if mappedPOIFilter is not valid
     */
    @Override
    public void validate(MappedPOIFilter mappedPOIFilter, SecurityContextBase securityContext) {
        basicService.validate(mappedPOIFilter, securityContext);

        Set<String> addressIds = mappedPOIFilter.getAddressIds() == null ? new HashSet<>() : mappedPOIFilter.getAddressIds();
        Map<String, Address> address = addressIds.isEmpty() ? new HashMap<>() : repository.listByIds(Address.class, addressIds, SecuredBasic_.security, securityContext).parallelStream().collect(Collectors.toMap(f -> f.getId(), f -> f));
        addressIds.removeAll(address.keySet());
        if (!addressIds.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No Address with ids " + addressIds);
        }
        mappedPOIFilter.setAddress(new ArrayList<>(address.values()));
    }

    /**
     * @param mappedPOICreate
     * @param securityContext
     * @throws ResponseStatusException if mappedPOICreate is not valid
     */
    @Override
    public void validate(MappedPOICreate mappedPOICreate, SecurityContextBase securityContext) {
        basicService.validate(mappedPOICreate, securityContext);

        String mapIconId = mappedPOICreate.getMapIconId();
        MapIcon mapIcon =
                mapIconId == null
                        ? null
                        : this.repository.getByIdOrNull(
                        mapIconId, MapIcon.class, SecuredBasic_.security, securityContext);
        if (mapIconId != null && mapIcon == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No MapIcon with id " + mapIconId);
        }
        mappedPOICreate.setMapIcon(mapIcon);

        String addressId = mappedPOICreate.getAddressId();
        Address address =
                addressId == null
                        ? null
                        : repository.getByIdOrNull(
                        addressId, Address.class, SecuredBasic_.security, securityContext);
        if (addressId != null && address == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Address with id " + addressId);
        }
        mappedPOICreate.setAddress(address);
    }

    @Override
    public <T extends Baseclass> List<T> listByIds(
            Class<T> c, Set<String> ids, SecurityContextBase securityContext) {
        return repository.listByIds(c, ids, securityContext);
    }

    @Override
    public <T extends Baseclass> T getByIdOrNull(
            String id, Class<T> c, SecurityContextBase securityContext) {
        return repository.getByIdOrNull(id, c, securityContext);
    }

    @Override
    public <D extends Basic, E extends Baseclass, T extends D> T getByIdOrNull(
            String id,
            Class<T> c,
            SingularAttribute<D, E> baseclassAttribute,
            SecurityContextBase securityContext) {
        return repository.getByIdOrNull(id, c, baseclassAttribute, securityContext);
    }

    @Override
    public <D extends Basic, E extends Baseclass, T extends D> List<T> listByIds(
            Class<T> c,
            Set<String> ids,
            SingularAttribute<D, E> baseclassAttribute,
            SecurityContextBase securityContext) {
        return repository.listByIds(c, ids, baseclassAttribute, securityContext);
    }

    @Override
    public <D extends Basic, T extends D> List<T> findByIds(
            Class<T> c, Set<String> ids, SingularAttribute<D, String> idAttribute) {
        return repository.findByIds(c, ids, idAttribute);
    }

    @Override
    public <T extends Basic> List<T> findByIds(Class<T> c, Set<String> requested) {
        return repository.findByIds(c, requested);
    }

    @Override
    public <T> T findByIdOrNull(Class<T> type, String id) {
        return repository.findByIdOrNull(type, id);
    }

    @Override
    public void merge(java.lang.Object base) {
        repository.merge(base);
    }

    @Override
    public void massMerge(List<?> toMerge) {
        repository.massMerge(toMerge);
    }


}
