package com.wizzdi.maps.service.service;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.model.SecuredBasic_;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.flexicore.security.service.BaseclassService;
import com.wizzdi.flexicore.security.service.BasicService;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.service.data.MapIconRepository;
import com.wizzdi.maps.service.request.MapIconCreate;
import com.wizzdi.maps.service.request.MapIconFilter;
import com.wizzdi.maps.service.request.MapIconUpdate;
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
public class MapIconService implements Plugin, IMapIconService {

  @Autowired private MapIconRepository repository;

  @Autowired private BasicService basicService;

  /**
   * @param mapIconCreate Object Used to Create MapIcon
   * @param securityContext
   * @return created MapIcon
   */
  @Override
  public MapIcon createMapIcon(MapIconCreate mapIconCreate, SecurityContextBase securityContext) {
    MapIcon mapIcon = createMapIconNoMerge(mapIconCreate, securityContext);
    this.repository.merge(mapIcon);
    return mapIcon;
  }

  /**
   * @param mapIconCreate Object Used to Create MapIcon
   * @param securityContext
   * @return created MapIcon unmerged
   */
  @Override
  public MapIcon createMapIconNoMerge(
      MapIconCreate mapIconCreate, SecurityContextBase securityContext) {
    MapIcon mapIcon = new MapIcon();
    mapIcon.setId(UUID.randomUUID().toString());
    updateMapIconNoMerge(mapIcon, mapIconCreate);

    BaseclassService.createSecurityObjectNoMerge(mapIcon, securityContext);

    return mapIcon;
  }

  /**
   * @param mapIconCreate Object Used to Create MapIcon
   * @param mapIcon
   * @return if mapIcon was updated
   */
  @Override
  public boolean updateMapIconNoMerge(MapIcon mapIcon, MapIconCreate mapIconCreate) {
    boolean update = basicService.updateBasicNoMerge(mapIconCreate, mapIcon);

    if (mapIconCreate.getFileResource() != null
        && (mapIcon.getFileResource() == null
            || !mapIconCreate
                .getFileResource()
                .getId()
                .equals(mapIcon.getFileResource().getId()))) {
      mapIcon.setFileResource(mapIconCreate.getFileResource());
      update = true;
    }

    if (mapIconCreate.getExternalId() != null
        && (!mapIconCreate.getExternalId().equals(mapIcon.getExternalId()))) {
      mapIcon.setExternalId(mapIconCreate.getExternalId());
      update = true;
    }

    return update;
  }
  /**
   * @param mapIconUpdate
   * @param securityContext
   * @return mapIcon
   */
  @Override
  public MapIcon updateMapIcon(MapIconUpdate mapIconUpdate, SecurityContextBase securityContext) {
    MapIcon mapIcon = mapIconUpdate.getMapIcon();
    if (updateMapIconNoMerge(mapIcon, mapIconUpdate)) {
      this.repository.merge(mapIcon);
    }
    return mapIcon;
  }

  /**
   * @param mapIconFilter Object Used to List MapIcon
   * @param securityContext
   * @return PaginationResponse containing paging information for MapIcon
   */
  @Override
  public PaginationResponse<MapIcon> getAllMapIcons(
      MapIconFilter mapIconFilter, SecurityContextBase securityContext) {
    List<MapIcon> list = listAllMapIcons(mapIconFilter, securityContext);
    long count = this.repository.countAllMapIcons(mapIconFilter, securityContext);
    return new PaginationResponse<>(list, mapIconFilter, count);
  }

  /**
   * @param mapIconFilter Object Used to List MapIcon
   * @param securityContext
   * @return List of MapIcon
   */
  @Override
  public List<MapIcon> listAllMapIcons(
      MapIconFilter mapIconFilter, SecurityContextBase securityContext) {
    return this.repository.listAllMapIcons(mapIconFilter, securityContext);
  }

  /**
   * @param mapIconFilter Object Used to List MapIcon
   * @param securityContext
   * @throws ResponseStatusException if mapIconFilter is not valid
   */
  @Override
  public void validate(MapIconFilter mapIconFilter, SecurityContextBase securityContext) {
    basicService.validate(mapIconFilter, securityContext);

    Set<String> fileResourceIds =
        mapIconFilter.getFileResourceIds() == null
            ? new HashSet<>()
            : mapIconFilter.getFileResourceIds();
    Map<String, FileResource> fileResource =
        fileResourceIds.isEmpty()
            ? new HashMap<>()
            : this.repository
                .listByIds(
                    FileResource.class, fileResourceIds, SecuredBasic_.security, securityContext)
                .parallelStream()
                .collect(Collectors.toMap(f -> f.getId(), f -> f));
    fileResourceIds.removeAll(fileResource.keySet());
    if (!fileResourceIds.isEmpty()) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "No FileResource with ids " + fileResourceIds);
    }
    mapIconFilter.setFileResource(new ArrayList<>(fileResource.values()));
  }

  /**
   * @param mapIconCreate Object Used to Create MapIcon
   * @param securityContext
   * @throws ResponseStatusException if mapIconCreate is not valid
   */
  @Override
  public void validate(MapIconCreate mapIconCreate, SecurityContextBase securityContext) {
    basicService.validate(mapIconCreate, securityContext);

    String fileResourceId = mapIconCreate.getFileResourceId();
    FileResource fileResource =
        fileResourceId == null
            ? null
            : this.repository.getByIdOrNull(
                fileResourceId, FileResource.class, SecuredBasic_.security, securityContext);
    if (fileResourceId != null && fileResource == null) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "No FileResource with id " + fileResourceId);
    }
    mapIconCreate.setFileResource(fileResource);
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
