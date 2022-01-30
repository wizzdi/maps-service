package com.wizzdi.maps.service.service;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.model.SecuredBasic_;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.flexicore.security.service.BaseclassService;
import com.wizzdi.flexicore.security.service.BasicService;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.model.StatusHistory;
import com.wizzdi.maps.service.data.StatusHistoryRepository;
import com.wizzdi.maps.service.request.StatusHistoryCreate;
import com.wizzdi.maps.service.request.StatusHistoryFilter;
import com.wizzdi.maps.service.request.StatusHistoryUpdate;
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
public class StatusHistoryService implements Plugin {

  @Autowired private StatusHistoryRepository repository;

  @Autowired private BasicService basicService;

  /**
   * @param statusHistoryCreate Object Used to Create StatusHistory
   * @param securityContext
   * @return created StatusHistory
   */
  public StatusHistory createStatusHistory(
      StatusHistoryCreate statusHistoryCreate, SecurityContextBase securityContext) {
    StatusHistory statusHistory = createStatusHistoryNoMerge(statusHistoryCreate, securityContext);
    this.repository.merge(statusHistory);
    return statusHistory;
  }

  /**
   * @param statusHistoryCreate Object Used to Create StatusHistory
   * @param securityContext
   * @return created StatusHistory unmerged
   */
  public StatusHistory createStatusHistoryNoMerge(
      StatusHistoryCreate statusHistoryCreate, SecurityContextBase securityContext) {
    StatusHistory statusHistory = new StatusHistory();
    statusHistory.setId(UUID.randomUUID().toString());
    updateStatusHistoryNoMerge(statusHistory, statusHistoryCreate);

    BaseclassService.createSecurityObjectNoMerge(statusHistory, securityContext);

    return statusHistory;
  }

  /**
   * @param statusHistoryCreate Object Used to Create StatusHistory
   * @param statusHistory
   * @return if statusHistory was updated
   */
  public boolean updateStatusHistoryNoMerge(
      StatusHistory statusHistory, StatusHistoryCreate statusHistoryCreate) {
    boolean update = basicService.updateBasicNoMerge(statusHistoryCreate, statusHistory);

    if (statusHistoryCreate.getMappedPOI() != null
        && (statusHistory.getMappedPOI() == null
            || !statusHistoryCreate
                .getMappedPOI()
                .getId()
                .equals(statusHistory.getMappedPOI().getId()))) {
      statusHistory.setMappedPOI(statusHistoryCreate.getMappedPOI());
      update = true;
    }

    if (statusHistoryCreate.getMapIcon() != null
        && (statusHistory.getMapIcon() == null
            || !statusHistoryCreate
                .getMapIcon()
                .getId()
                .equals(statusHistory.getMapIcon().getId()))) {
      statusHistory.setMapIcon(statusHistoryCreate.getMapIcon());
      update = true;
    }

    if (statusHistoryCreate.getDateAtStatus() != null
        && (!statusHistoryCreate.getDateAtStatus().equals(statusHistory.getDateAtStatus()))) {
      statusHistory.setDateAtStatus(statusHistoryCreate.getDateAtStatus());
      update = true;
    }

    return update;
  }
  /**
   * @param statusHistoryUpdate
   * @param securityContext
   * @return statusHistory
   */
  public StatusHistory updateStatusHistory(
      StatusHistoryUpdate statusHistoryUpdate, SecurityContextBase securityContext) {
    StatusHistory statusHistory = statusHistoryUpdate.getStatusHistory();
    if (updateStatusHistoryNoMerge(statusHistory, statusHistoryUpdate)) {
      this.repository.merge(statusHistory);
    }
    return statusHistory;
  }

  /**
   * @param statusHistoryFilter Object Used to List StatusHistory
   * @param securityContext
   * @return PaginationResponse containing paging information for StatusHistory
   */
  public PaginationResponse<StatusHistory> getAllStatusHistories(
      StatusHistoryFilter statusHistoryFilter, SecurityContextBase securityContext) {
    List<StatusHistory> list = listAllStatusHistories(statusHistoryFilter, securityContext);
    long count = this.repository.countAllStatusHistories(statusHistoryFilter, securityContext);
    return new PaginationResponse<>(list, statusHistoryFilter, count);
  }

  /**
   * @param statusHistoryFilter Object Used to List StatusHistory
   * @param securityContext
   * @return List of StatusHistory
   */
  public List<StatusHistory> listAllStatusHistories(
      StatusHistoryFilter statusHistoryFilter, SecurityContextBase securityContext) {
    return this.repository.listAllStatusHistories(statusHistoryFilter, securityContext);
  }

  /**
   * @param statusHistoryFilter Object Used to List StatusHistory
   * @param securityContext
   * @throws ResponseStatusException if statusHistoryFilter is not valid
   */
  public void validate(
      StatusHistoryFilter statusHistoryFilter, SecurityContextBase securityContext) {
    basicService.validate(statusHistoryFilter, securityContext);

    Set<String> mappedPOIIds =
        statusHistoryFilter.getMappedPOIIds() == null
            ? new HashSet<>()
            : statusHistoryFilter.getMappedPOIIds();
    Map<String, MappedPOI> mappedPOI =
        mappedPOIIds.isEmpty()
            ? new HashMap<>()
            : this.repository
                .listByIds(MappedPOI.class, mappedPOIIds, SecuredBasic_.security, securityContext)
                .parallelStream()
                .collect(Collectors.toMap(f -> f.getId(), f -> f));
    mappedPOIIds.removeAll(mappedPOI.keySet());
    if (!mappedPOIIds.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Set with ids " + mappedPOIIds);
    }
    statusHistoryFilter.setMappedPOI(new ArrayList<>(mappedPOI.values()));
    Set<String> mapIconIds =
        statusHistoryFilter.getMapIconIds() == null
            ? new HashSet<>()
            : statusHistoryFilter.getMapIconIds();
    Map<String, MapIcon> mapIcon =
        mapIconIds.isEmpty()
            ? new HashMap<>()
            : this.repository
                .listByIds(MapIcon.class, mapIconIds, SecuredBasic_.security, securityContext)
                .parallelStream()
                .collect(Collectors.toMap(f -> f.getId(), f -> f));
    mapIconIds.removeAll(mapIcon.keySet());
    if (!mapIconIds.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Set with ids " + mapIconIds);
    }
    statusHistoryFilter.setMapIcon(new ArrayList<>(mapIcon.values()));
  }

  /**
   * @param statusHistoryCreate Object Used to Create StatusHistory
   * @param securityContext
   * @throws ResponseStatusException if statusHistoryCreate is not valid
   */
  public void validate(
      StatusHistoryCreate statusHistoryCreate, SecurityContextBase securityContext) {
    basicService.validate(statusHistoryCreate, securityContext);

    String mappedPOIId = statusHistoryCreate.getMappedPOIId();
    MappedPOI mappedPOI =
        mappedPOIId == null
            ? null
            : this.repository.getByIdOrNull(
                mappedPOIId, MappedPOI.class, SecuredBasic_.security, securityContext);
    if (mappedPOIId != null && mappedPOI == null) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "No MappedPOI with id " + mappedPOIId);
    }
    statusHistoryCreate.setMappedPOI(mappedPOI);

    String mapIconId = statusHistoryCreate.getMapIconId();
    MapIcon mapIcon =
        mapIconId == null
            ? null
            : this.repository.getByIdOrNull(
                mapIconId, MapIcon.class, SecuredBasic_.security, securityContext);
    if (mapIconId != null && mapIcon == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No MapIcon with id " + mapIconId);
    }
    statusHistoryCreate.setMapIcon(mapIcon);
  }

  public <T extends Baseclass> List<T> listByIds(
      Class<T> c, Set<String> ids, SecurityContextBase securityContext) {
    return this.repository.listByIds(c, ids, securityContext);
  }

  public <T extends Baseclass> T getByIdOrNull(
      String id, Class<T> c, SecurityContextBase securityContext) {
    return this.repository.getByIdOrNull(id, c, securityContext);
  }

  public <D extends Basic, E extends Baseclass, T extends D> T getByIdOrNull(
      String id,
      Class<T> c,
      SingularAttribute<D, E> baseclassAttribute,
      SecurityContextBase securityContext) {
    return this.repository.getByIdOrNull(id, c, baseclassAttribute, securityContext);
  }

  public <D extends Basic, E extends Baseclass, T extends D> List<T> listByIds(
      Class<T> c,
      Set<String> ids,
      SingularAttribute<D, E> baseclassAttribute,
      SecurityContextBase securityContext) {
    return this.repository.listByIds(c, ids, baseclassAttribute, securityContext);
  }

  public <D extends Basic, T extends D> List<T> findByIds(
      Class<T> c, Set<String> ids, SingularAttribute<D, String> idAttribute) {
    return this.repository.findByIds(c, ids, idAttribute);
  }

  public <T extends Basic> List<T> findByIds(Class<T> c, Set<String> requested) {
    return this.repository.findByIds(c, requested);
  }

  public <T> T findByIdOrNull(Class<T> type, String id) {
    return this.repository.findByIdOrNull(type, id);
  }

  public void merge(java.lang.Object base) {
    this.repository.merge(base);
  }

  public void massMerge(List<?> toMerge) {
    this.repository.massMerge(toMerge);
  }
}
