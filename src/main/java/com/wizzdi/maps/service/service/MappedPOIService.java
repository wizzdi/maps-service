package com.wizzdi.maps.service.service;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.model.SecuredBasic_;
import com.flexicore.model.territories.Address;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.flexicore.security.service.BaseclassService;
import com.wizzdi.flexicore.security.service.BasicService;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.service.data.MappedPOIRepository;
import com.wizzdi.maps.service.request.MappedPOICreate;
import com.wizzdi.maps.service.request.MappedPOIFilter;
import com.wizzdi.maps.service.request.MappedPOIUpdate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.persistence.metamodel.SingularAttribute;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@Extension
public class MappedPOIService implements Plugin, IMappedPOIService {

  @Autowired private MappedPOIRepository repository;

  @Autowired private BasicService basicService;

  /**
   * @param mappedPOICreate
   * @param securityContext
   * @return created MappedPOI
   */
  @Override
  public MappedPOI createMappedPOI(
      MappedPOICreate mappedPOICreate, SecurityContextBase securityContext) {
    MappedPOI mappedPOI = createMappedPOINoMerge(mappedPOICreate, securityContext);
    repository.merge(mappedPOI);
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

    if (mappedPOICreate.getAddress() != null
        && (mappedPOI.getAddress() == null
            || !mappedPOICreate.getAddress().getId().equals(mappedPOI.getAddress().getId()))) {
      mappedPOI.setAddress(mappedPOICreate.getAddress());
      update = true;
    }

    if (mappedPOICreate.getIcon() != null
        && (mappedPOI.getIcon() == null
            || !mappedPOICreate.getIcon().getId().equals(mappedPOI.getIcon().getId()))) {
      mappedPOI.setIcon(mappedPOICreate.getIcon());
      update = true;
    }

    if (mappedPOICreate.getLat() != null
        && (!mappedPOICreate.getLat().equals(mappedPOI.getLat()))) {
      mappedPOI.setLat(mappedPOICreate.getLat());
      update = true;
    }

    if (mappedPOICreate.getGeoHash1() != null
        && (!mappedPOICreate.getGeoHash1().equals(mappedPOI.getGeoHash1()))) {
      mappedPOI.setGeoHash1(mappedPOICreate.getGeoHash1());
      update = true;
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
    }

    if (mappedPOICreate.getGeoHash2() != null
        && (!mappedPOICreate.getGeoHash2().equals(mappedPOI.getGeoHash2()))) {
      mappedPOI.setGeoHash2(mappedPOICreate.getGeoHash2());
      update = true;
    }

    if (mappedPOICreate.getGeoHash3() != null
        && (!mappedPOICreate.getGeoHash3().equals(mappedPOI.getGeoHash3()))) {
      mappedPOI.setGeoHash3(mappedPOICreate.getGeoHash3());
      update = true;
    }

    if (mappedPOICreate.getGeoHash4() != null
        && (!mappedPOICreate.getGeoHash4().equals(mappedPOI.getGeoHash4()))) {
      mappedPOI.setGeoHash4(mappedPOICreate.getGeoHash4());
      update = true;
    }

    if (mappedPOICreate.getGeoHash5() != null
        && (!mappedPOICreate.getGeoHash5().equals(mappedPOI.getGeoHash5()))) {
      mappedPOI.setGeoHash5(mappedPOICreate.getGeoHash5());
      update = true;
    }

    if (mappedPOICreate.getGeoHash6() != null
        && (!mappedPOICreate.getGeoHash6().equals(mappedPOI.getGeoHash6()))) {
      mappedPOI.setGeoHash6(mappedPOICreate.getGeoHash6());
      update = true;
    }

    if (mappedPOICreate.getGeoHash7() != null
        && (!mappedPOICreate.getGeoHash7().equals(mappedPOI.getGeoHash7()))) {
      mappedPOI.setGeoHash7(mappedPOICreate.getGeoHash7());
      update = true;
    }

    if (mappedPOICreate.getGeoHash9() != null
        && (!mappedPOICreate.getGeoHash9().equals(mappedPOI.getGeoHash9()))) {
      mappedPOI.setGeoHash9(mappedPOICreate.getGeoHash9());
      update = true;
    }

    if (mappedPOICreate.getGeoHash11() != null
        && (!mappedPOICreate.getGeoHash11().equals(mappedPOI.getGeoHash11()))) {
      mappedPOI.setGeoHash11(mappedPOICreate.getGeoHash11());
      update = true;
    }

    if (mappedPOICreate.getGeoHash12() != null
        && (!mappedPOICreate.getGeoHash12().equals(mappedPOI.getGeoHash12()))) {
      mappedPOI.setGeoHash12(mappedPOICreate.getGeoHash12());
      update = true;
    }

    if (mappedPOICreate.getGeoHash8() != null
        && (!mappedPOICreate.getGeoHash8().equals(mappedPOI.getGeoHash8()))) {
      mappedPOI.setGeoHash8(mappedPOICreate.getGeoHash8());
      update = true;
    }

    if (mappedPOICreate.getGeoHash10() != null
        && (!mappedPOICreate.getGeoHash10().equals(mappedPOI.getGeoHash10()))) {
      mappedPOI.setGeoHash10(mappedPOICreate.getGeoHash10());
      update = true;
    }

    return update;
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
    long count = repository.countAllMappedPOIs(mappedPOIFilter, securityContext);
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

    Set<String> iconIds =
        mappedPOIFilter.getIconIds() == null ? new HashSet<>() : mappedPOIFilter.getIconIds();
    Map<String, FileResource> icon =
        iconIds.isEmpty()
            ? new HashMap<>()
            : repository
                .listByIds(FileResource.class, iconIds, SecuredBasic_.security, securityContext)
                .parallelStream()
                .collect(Collectors.toMap(f -> f.getId(), f -> f));
    iconIds.removeAll(icon.keySet());
    if (!iconIds.isEmpty()) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "No FileResource with ids " + iconIds);
    }
    mappedPOIFilter.setIcon(new ArrayList<>(icon.values()));
    Set<String> addressIds =
        mappedPOIFilter.getAddressIds() == null ? new HashSet<>() : mappedPOIFilter.getAddressIds();
    Map<String, Address> address =
        addressIds.isEmpty()
            ? new HashMap<>()
            : repository
                .listByIds(Address.class, addressIds, SecuredBasic_.security, securityContext)
                .parallelStream()
                .collect(Collectors.toMap(f -> f.getId(), f -> f));
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

    String iconId = mappedPOICreate.getIconId();
    FileResource icon =
        iconId == null
            ? null
            : repository.getByIdOrNull(
                iconId, FileResource.class, SecuredBasic_.security, securityContext);
    if (iconId != null && icon == null) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "No FileResource with id " + iconId);
    }
    mappedPOICreate.setIcon(icon);

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
