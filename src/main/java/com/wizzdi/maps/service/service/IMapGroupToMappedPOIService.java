package com.wizzdi.maps.service.service;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.maps.model.MapGroupToMappedPOI;
import com.wizzdi.maps.service.request.MapGroupToMappedPOICreate;
import com.wizzdi.maps.service.request.MapGroupToMappedPOIFilter;
import com.wizzdi.maps.service.request.MapGroupToMappedPOIUpdate;
import java.util.List;
import java.util.Set;
import javax.persistence.metamodel.SingularAttribute;

public interface IMapGroupToMappedPOIService {

  /**
   * @param mapGroupToMappedPOICreate Object Used to Create MapGroupToMappedPOI
   * @param securityContext
   * @return created MapGroupToMappedPOI
   */
  MapGroupToMappedPOI createMapGroupToMappedPOI(
      MapGroupToMappedPOICreate mapGroupToMappedPOICreate, SecurityContextBase securityContext);

  /**
   * @param mapGroupToMappedPOICreate Object Used to Create MapGroupToMappedPOI
   * @param securityContext
   * @return created MapGroupToMappedPOI unmerged
   */
  MapGroupToMappedPOI createMapGroupToMappedPOINoMerge(
      MapGroupToMappedPOICreate mapGroupToMappedPOICreate, SecurityContextBase securityContext);

  /**
   * @param mapGroupToMappedPOICreate Object Used to Create MapGroupToMappedPOI
   * @param mapGroupToMappedPOI
   * @return if mapGroupToMappedPOI was updated
   */
  boolean updateMapGroupToMappedPOINoMerge(
      MapGroupToMappedPOI mapGroupToMappedPOI, MapGroupToMappedPOICreate mapGroupToMappedPOICreate);

  /**
   * @param mapGroupToMappedPOIUpdate
   * @param securityContext
   * @return mapGroupToMappedPOI
   */
  MapGroupToMappedPOI updateMapGroupToMappedPOI(
      MapGroupToMappedPOIUpdate mapGroupToMappedPOIUpdate, SecurityContextBase securityContext);

  /**
   * @param mapGroupToMappedPOIFilter Object Used to List MapGroupToMappedPOI
   * @param securityContext
   * @return PaginationResponse containing paging information for MapGroupToMappedPOI
   */
  PaginationResponse<MapGroupToMappedPOI> getAllMapGroupToMappedPOIs(
      MapGroupToMappedPOIFilter mapGroupToMappedPOIFilter, SecurityContextBase securityContext);

  /**
   * @param mapGroupToMappedPOIFilter Object Used to List MapGroupToMappedPOI
   * @param securityContext
   * @return List of MapGroupToMappedPOI
   */
  List<MapGroupToMappedPOI> listAllMapGroupToMappedPOIs(
      MapGroupToMappedPOIFilter mapGroupToMappedPOIFilter, SecurityContextBase securityContext);

  /**
   * @param mapGroupToMappedPOIFilter Object Used to List MapGroupToMappedPOI
   * @param securityContext
   * @throws ResponseStatusException if mapGroupToMappedPOIFilter is not valid
   */
  void validate(
      MapGroupToMappedPOIFilter mapGroupToMappedPOIFilter, SecurityContextBase securityContext);

  /**
   * @param mapGroupToMappedPOICreate Object Used to Create MapGroupToMappedPOI
   * @param securityContext
   * @throws ResponseStatusException if mapGroupToMappedPOICreate is not valid
   */
  void validate(
      MapGroupToMappedPOICreate mapGroupToMappedPOICreate, SecurityContextBase securityContext);

  <T extends Baseclass> List<T> listByIds(
      Class<T> c, Set<String> ids, SecurityContextBase securityContext);

  <T extends Baseclass> T getByIdOrNull(String id, Class<T> c, SecurityContextBase securityContext);

  <D extends Basic, E extends Baseclass, T extends D> T getByIdOrNull(
      String id,
      Class<T> c,
      SingularAttribute<D, E> baseclassAttribute,
      SecurityContextBase securityContext);

  <D extends Basic, E extends Baseclass, T extends D> List<T> listByIds(
      Class<T> c,
      Set<String> ids,
      SingularAttribute<D, E> baseclassAttribute,
      SecurityContextBase securityContext);

  <D extends Basic, T extends D> List<T> findByIds(
      Class<T> c, Set<String> ids, SingularAttribute<D, String> idAttribute);

  <T extends Basic> List<T> findByIds(Class<T> c, Set<String> requested);

  <T> T findByIdOrNull(Class<T> type, String id);

  void merge(java.lang.Object base);

  void massMerge(List<?> toMerge);
}
