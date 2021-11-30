package com.wizzdi.maps.model.service.service;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.model.service.request.MappedPOICreate;
import com.wizzdi.maps.model.service.request.MappedPOIFilter;
import com.wizzdi.maps.model.service.request.MappedPOIUpdate;
import java.util.List;
import java.util.Set;
import javax.persistence.metamodel.SingularAttribute;

public interface IMappedPOIService {

  /**
   * @param mappedPOICreate
   * @param securityContext
   * @return created MappedPOI
   */
  MappedPOI createMappedPOI(MappedPOICreate mappedPOICreate, SecurityContextBase securityContext);

  /**
   * @param mappedPOICreate
   * @param securityContext
   * @return created MappedPOI unmerged
   */
  MappedPOI createMappedPOINoMerge(
      MappedPOICreate mappedPOICreate, SecurityContextBase securityContext);

  /**
   * @param mappedPOICreate
   * @param mappedPOI
   * @return if mappedPOI was updated
   */
  boolean updateMappedPOINoMerge(MappedPOICreate mappedPOICreate, MappedPOI mappedPOI);

  /**
   * @param mappedPOIUpdate
   * @param securityContext
   * @return mappedPOI
   */
  MappedPOI updateMappedPOI(MappedPOIUpdate mappedPOIUpdate, SecurityContextBase securityContext);

  /**
   * @param mappedPOIFilter
   * @param securityContext
   * @return PaginationResponse containing paging information for MappedPOI
   */
  PaginationResponse<MappedPOI> getAllMappedPOIs(
      MappedPOIFilter mappedPOIFilter, SecurityContextBase securityContext);

  /**
   * @param mappedPOIFilter
   * @param securityContext
   * @return List of MappedPOI
   */
  List<MappedPOI> listAllMappedPOIs(
      MappedPOIFilter mappedPOIFilter, SecurityContextBase securityContext);

  /**
   * @param mappedPOIFilter
   * @param securityContext
   * @throws ResponseStatusException if mappedPOIFilter is not valid
   */
  void validate(MappedPOIFilter mappedPOIFilter, SecurityContextBase securityContext);

  /**
   * @param mappedPOICreate
   * @param securityContext
   * @throws ResponseStatusException if mappedPOICreate is not valid
   */
  void validate(MappedPOICreate mappedPOICreate, SecurityContextBase securityContext);

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

  void merge(Object base);

  void massMerge(List<?> toMerge);
}
