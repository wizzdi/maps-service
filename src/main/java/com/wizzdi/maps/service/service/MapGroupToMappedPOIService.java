package com.wizzdi.maps.service.service;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.flexicore.security.service.BaseclassService;
import com.wizzdi.flexicore.security.service.BasicService;
import com.wizzdi.maps.model.MapGroupToMappedPOI;
import com.wizzdi.maps.service.data.MapGroupToMappedPOIRepository;
import com.wizzdi.maps.service.request.MapGroupToMappedPOICreate;
import com.wizzdi.maps.service.request.MapGroupToMappedPOIFilter;
import com.wizzdi.maps.service.request.MapGroupToMappedPOIUpdate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.persistence.metamodel.SingularAttribute;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@Extension
public class MapGroupToMappedPOIService implements Plugin, IMapGroupToMappedPOIService {

  @Autowired private MapGroupToMappedPOIRepository repository;

  @Autowired private BasicService basicService;

  /**
   * @param mapGroupToMappedPOICreate Object Used to Create MapGroupToMappedPOI
   * @param securityContext
   * @return created MapGroupToMappedPOI
   */
  @Override
  public MapGroupToMappedPOI createMapGroupToMappedPOI(
      MapGroupToMappedPOICreate mapGroupToMappedPOICreate, SecurityContextBase securityContext) {
    MapGroupToMappedPOI mapGroupToMappedPOI =
        createMapGroupToMappedPOINoMerge(mapGroupToMappedPOICreate, securityContext);
    this.repository.merge(mapGroupToMappedPOI);
    return mapGroupToMappedPOI;
  }

  /**
   * @param mapGroupToMappedPOICreate Object Used to Create MapGroupToMappedPOI
   * @param securityContext
   * @return created MapGroupToMappedPOI unmerged
   */
  @Override
  public MapGroupToMappedPOI createMapGroupToMappedPOINoMerge(
      MapGroupToMappedPOICreate mapGroupToMappedPOICreate, SecurityContextBase securityContext) {
    MapGroupToMappedPOI mapGroupToMappedPOI = new MapGroupToMappedPOI();
    mapGroupToMappedPOI.setId(UUID.randomUUID().toString());
    updateMapGroupToMappedPOINoMerge(mapGroupToMappedPOI, mapGroupToMappedPOICreate);

    BaseclassService.createSecurityObjectNoMerge(mapGroupToMappedPOI, securityContext);

    return mapGroupToMappedPOI;
  }

  /**
   * @param mapGroupToMappedPOICreate Object Used to Create MapGroupToMappedPOI
   * @param mapGroupToMappedPOI
   * @return if mapGroupToMappedPOI was updated
   */
  @Override
  public boolean updateMapGroupToMappedPOINoMerge(
      MapGroupToMappedPOI mapGroupToMappedPOI,
      MapGroupToMappedPOICreate mapGroupToMappedPOICreate) {
    boolean update =
        basicService.updateBasicNoMerge(mapGroupToMappedPOICreate, mapGroupToMappedPOI);

    if (mapGroupToMappedPOICreate.getMapGroup() != null
        && (mapGroupToMappedPOI.getMapGroup() == null
            || !mapGroupToMappedPOICreate
                .getMapGroup()
                .getId()
                .equals(mapGroupToMappedPOI.getMapGroup().getId()))) {
      mapGroupToMappedPOI.setMapGroup(mapGroupToMappedPOICreate.getMapGroup());
      update = true;
    }

    if (mapGroupToMappedPOICreate.getMappedPOI() != null
        && (mapGroupToMappedPOI.getMappedPOI() == null
            || !mapGroupToMappedPOICreate
                .getMappedPOI()
                .getId()
                .equals(mapGroupToMappedPOI.getMappedPOI().getId()))) {
      mapGroupToMappedPOI.setMappedPOI(mapGroupToMappedPOICreate.getMappedPOI());
      update = true;
    }

    return update;
  }
  /**
   * @param mapGroupToMappedPOIUpdate
   * @param securityContext
   * @return mapGroupToMappedPOI
   */
  @Override
  public MapGroupToMappedPOI updateMapGroupToMappedPOI(
      MapGroupToMappedPOIUpdate mapGroupToMappedPOIUpdate, SecurityContextBase securityContext) {
    MapGroupToMappedPOI mapGroupToMappedPOI = mapGroupToMappedPOIUpdate.getMapGroupToMappedPOI();
    if (updateMapGroupToMappedPOINoMerge(mapGroupToMappedPOI, mapGroupToMappedPOIUpdate)) {
      this.repository.merge(mapGroupToMappedPOI);
    }
    return mapGroupToMappedPOI;
  }

  /**
   * @param mapGroupToMappedPOIFilter Object Used to List MapGroupToMappedPOI
   * @param securityContext
   * @return PaginationResponse containing paging information for MapGroupToMappedPOI
   */
  @Override
  public PaginationResponse<MapGroupToMappedPOI> getAllMapGroupToMappedPOIs(
      MapGroupToMappedPOIFilter mapGroupToMappedPOIFilter, SecurityContextBase securityContext) {
    List<MapGroupToMappedPOI> list =
        listAllMapGroupToMappedPOIs(mapGroupToMappedPOIFilter, securityContext);
    long count =
        this.repository.countAllMapGroupToMappedPOIs(mapGroupToMappedPOIFilter, securityContext);
    return new PaginationResponse<>(list, mapGroupToMappedPOIFilter, count);
  }

  /**
   * @param mapGroupToMappedPOIFilter Object Used to List MapGroupToMappedPOI
   * @param securityContext
   * @return List of MapGroupToMappedPOI
   */
  @Override
  public List<MapGroupToMappedPOI> listAllMapGroupToMappedPOIs(
      MapGroupToMappedPOIFilter mapGroupToMappedPOIFilter, SecurityContextBase securityContext) {
    return this.repository.listAllMapGroupToMappedPOIs(mapGroupToMappedPOIFilter, securityContext);
  }

  /**
   * @param mapGroupToMappedPOIFilter Object Used to List MapGroupToMappedPOI
   * @param securityContext
   * @throws ResponseStatusException if mapGroupToMappedPOIFilter is not valid
   */
  @Override
  public void validate(
      MapGroupToMappedPOIFilter mapGroupToMappedPOIFilter, SecurityContextBase securityContext) {
    basicService.validate(mapGroupToMappedPOIFilter, securityContext);
  }

  /**
   * @param mapGroupToMappedPOICreate Object Used to Create MapGroupToMappedPOI
   * @param securityContext
   * @throws ResponseStatusException if mapGroupToMappedPOICreate is not valid
   */
  @Override
  public void validate(
      MapGroupToMappedPOICreate mapGroupToMappedPOICreate, SecurityContextBase securityContext) {
    basicService.validate(mapGroupToMappedPOICreate, securityContext);
  }

  @Override
  public <T extends Baseclass> List<T> listByIds(
      Class<T> c, Set<String> ids, SecurityContextBase securityContext) {
    return this.repository.listByIds(c, ids, securityContext);
  }

  @Override
  public <T extends Baseclass> T getByIdOrNull(
      String id, Class<T> c, SecurityContextBase securityContext) {
    return this.repository.getByIdOrNull(id, c, securityContext);
  }

  @Override
  public <D extends Basic, E extends Baseclass, T extends D> T getByIdOrNull(
      String id,
      Class<T> c,
      SingularAttribute<D, E> baseclassAttribute,
      SecurityContextBase securityContext) {
    return this.repository.getByIdOrNull(id, c, baseclassAttribute, securityContext);
  }

  @Override
  public <D extends Basic, E extends Baseclass, T extends D> List<T> listByIds(
      Class<T> c,
      Set<String> ids,
      SingularAttribute<D, E> baseclassAttribute,
      SecurityContextBase securityContext) {
    return this.repository.listByIds(c, ids, baseclassAttribute, securityContext);
  }

  @Override
  public <D extends Basic, T extends D> List<T> findByIds(
      Class<T> c, Set<String> ids, SingularAttribute<D, String> idAttribute) {
    return this.repository.findByIds(c, ids, idAttribute);
  }

  @Override
  public <T extends Basic> List<T> findByIds(Class<T> c, Set<String> requested) {
    return this.repository.findByIds(c, requested);
  }

  @Override
  public <T> T findByIdOrNull(Class<T> type, String id) {
    return this.repository.findByIdOrNull(type, id);
  }

  @Override
  public void merge(java.lang.Object base) {
    this.repository.merge(base);
  }

  @Override
  public void massMerge(List<?> toMerge) {
    this.repository.massMerge(toMerge);
  }
}
