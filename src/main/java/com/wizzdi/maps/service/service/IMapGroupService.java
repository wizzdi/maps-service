package com.wizzdi.maps.service.service;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.maps.model.MapGroup;
import com.wizzdi.maps.service.request.MapGroupCreate;
import com.wizzdi.maps.service.request.MapGroupFilter;
import com.wizzdi.maps.service.request.MapGroupUpdate;
import java.util.List;
import java.util.Set;
import javax.persistence.metamodel.SingularAttribute;

public interface IMapGroupService {

  /**
   * @param mapGroupCreate Object Used to Create MapGroup
   * @param securityContext
   * @return created MapGroup
   */
  MapGroup createMapGroup(MapGroupCreate mapGroupCreate, SecurityContextBase securityContext);

  /**
   * @param mapGroupCreate Object Used to Create MapGroup
   * @param securityContext
   * @return created MapGroup unmerged
   */
  MapGroup createMapGroupNoMerge(
      MapGroupCreate mapGroupCreate, SecurityContextBase securityContext);

  /**
   * @param mapGroupCreate Object Used to Create MapGroup
   * @param mapGroup
   * @return if mapGroup was updated
   */
  boolean updateMapGroupNoMerge(MapGroup mapGroup, MapGroupCreate mapGroupCreate);

  /**
   * @param mapGroupUpdate
   * @param securityContext
   * @return mapGroup
   */
  MapGroup updateMapGroup(MapGroupUpdate mapGroupUpdate, SecurityContextBase securityContext);

  /**
   * @param mapGroupFilter Object Used to List MapGroup
   * @param securityContext
   * @return PaginationResponse containing paging information for MapGroup
   */
  PaginationResponse<MapGroup> getAllMapGroups(
      MapGroupFilter mapGroupFilter, SecurityContextBase securityContext);

  /**
   * @param mapGroupFilter Object Used to List MapGroup
   * @param securityContext
   * @return List of MapGroup
   */
  List<MapGroup> listAllMapGroups(
      MapGroupFilter mapGroupFilter, SecurityContextBase securityContext);

  /**
   * @param mapGroupFilter Object Used to List MapGroup
   * @param securityContext
   * @throws ResponseStatusException if mapGroupFilter is not valid
   */
  void validate(MapGroupFilter mapGroupFilter, SecurityContextBase securityContext);

  /**
   * @param mapGroupCreate Object Used to Create MapGroup
   * @param securityContext
   * @throws ResponseStatusException if mapGroupCreate is not valid
   */
  void validate(MapGroupCreate mapGroupCreate, SecurityContextBase securityContext);

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
