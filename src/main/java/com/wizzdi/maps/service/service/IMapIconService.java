package com.wizzdi.maps.service.service;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.service.request.MapIconCreate;
import com.wizzdi.maps.service.request.MapIconFilter;
import com.wizzdi.maps.service.request.MapIconUpdate;
import java.util.List;
import java.util.Set;
import javax.persistence.metamodel.SingularAttribute;

public interface IMapIconService {

  /**
   * @param mapIconCreate Object Used to Create MapIcon
   * @param securityContext
   * @return created MapIcon
   */
  MapIcon createMapIcon(MapIconCreate mapIconCreate, SecurityContextBase securityContext);

  /**
   * @param mapIconCreate Object Used to Create MapIcon
   * @param securityContext
   * @return created MapIcon unmerged
   */
  MapIcon createMapIconNoMerge(MapIconCreate mapIconCreate, SecurityContextBase securityContext);

  /**
   * @param mapIconCreate Object Used to Create MapIcon
   * @param mapIcon
   * @return if mapIcon was updated
   */
  boolean updateMapIconNoMerge(MapIcon mapIcon, MapIconCreate mapIconCreate);

  /**
   * @param mapIconUpdate
   * @param securityContext
   * @return mapIcon
   */
  MapIcon updateMapIcon(MapIconUpdate mapIconUpdate, SecurityContextBase securityContext);

  /**
   * @param mapIconFilter Object Used to List MapIcon
   * @param securityContext
   * @return PaginationResponse containing paging information for MapIcon
   */
  PaginationResponse<MapIcon> getAllMapIcons(
      MapIconFilter mapIconFilter, SecurityContextBase securityContext);

  /**
   * @param mapIconFilter Object Used to List MapIcon
   * @param securityContext
   * @return List of MapIcon
   */
  List<MapIcon> listAllMapIcons(MapIconFilter mapIconFilter, SecurityContextBase securityContext);

  /**
   * @param mapIconFilter Object Used to List MapIcon
   * @param securityContext
   * @throws ResponseStatusException if mapIconFilter is not valid
   */
  void validate(MapIconFilter mapIconFilter, SecurityContextBase securityContext);

  /**
   * @param mapIconCreate Object Used to Create MapIcon
   * @param securityContext
   * @throws ResponseStatusException if mapIconCreate is not valid
   */
  void validate(MapIconCreate mapIconCreate, SecurityContextBase securityContext);

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
