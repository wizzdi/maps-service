package com.wizzdi.maps.service.service;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.maps.model.LocationHistory;
import com.wizzdi.maps.service.request.LocationHistoryCreate;
import com.wizzdi.maps.service.request.LocationHistoryFilter;
import com.wizzdi.maps.service.request.LocationHistoryUpdate;
import java.util.List;
import java.util.Set;
import javax.persistence.metamodel.SingularAttribute;

public interface ILocationHistoryService {

  /**
   * @param locationHistoryCreate Object Used to Create LocationHistory
   * @param securityContext
   * @return created LocationHistory
   */
  LocationHistory createLocationHistory(
      LocationHistoryCreate locationHistoryCreate, SecurityContextBase securityContext);

  /**
   * @param locationHistoryCreate Object Used to Create LocationHistory
   * @param securityContext
   * @return created LocationHistory unmerged
   */
  LocationHistory createLocationHistoryNoMerge(
      LocationHistoryCreate locationHistoryCreate, SecurityContextBase securityContext);

  /**
   * @param locationHistoryCreate Object Used to Create LocationHistory
   * @param locationHistory
   * @return if locationHistory was updated
   */
  boolean updateLocationHistoryNoMerge(
      LocationHistory locationHistory, LocationHistoryCreate locationHistoryCreate);

  /**
   * @param locationHistoryUpdate
   * @param securityContext
   * @return locationHistory
   */
  LocationHistory updateLocationHistory(
      LocationHistoryUpdate locationHistoryUpdate, SecurityContextBase securityContext);

  /**
   * @param locationHistoryFilter Object Used to List LocationHistory
   * @param securityContext
   * @return PaginationResponse containing paging information for LocationHistory
   */
  PaginationResponse<LocationHistory> getAllLocationHistories(
      LocationHistoryFilter locationHistoryFilter, SecurityContextBase securityContext);

  /**
   * @param locationHistoryFilter Object Used to List LocationHistory
   * @param securityContext
   * @return List of LocationHistory
   */
  List<LocationHistory> listAllLocationHistories(
      LocationHistoryFilter locationHistoryFilter, SecurityContextBase securityContext);

  /**
   * @param locationHistoryFilter Object Used to List LocationHistory
   * @param securityContext
   * @throws ResponseStatusException if locationHistoryFilter is not valid
   */
  void validate(LocationHistoryFilter locationHistoryFilter, SecurityContextBase securityContext);

  /**
   * @param locationHistoryCreate Object Used to Create LocationHistory
   * @param securityContext
   * @throws ResponseStatusException if locationHistoryCreate is not valid
   */
  void validate(LocationHistoryCreate locationHistoryCreate, SecurityContextBase securityContext);

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
