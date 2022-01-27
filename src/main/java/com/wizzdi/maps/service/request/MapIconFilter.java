package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import java.util.List;
import java.util.Set;

/** Object Used to List MapIcon */
public class MapIconFilter extends PaginationFilter {

  private Set<String> externalId;

  @JsonIgnore private List<FileResource> fileResource;

  private Set<String> fileResourceIds;

  private BasicPropertiesFilter basicPropertiesFilter;

  /** @return externalId */
  public Set<String> getExternalId() {
    return this.externalId;
  }

  /**
   * @param externalId externalId to set
   * @return MapIconFilter
   */
  public <T extends MapIconFilter> T setExternalId(Set<String> externalId) {
    this.externalId = externalId;
    return (T) this;
  }

  /** @return fileResource */
  @JsonIgnore
  public List<FileResource> getFileResource() {
    return this.fileResource;
  }

  /**
   * @param fileResource fileResource to set
   * @return MapIconFilter
   */
  public <T extends MapIconFilter> T setFileResource(List<FileResource> fileResource) {
    this.fileResource = fileResource;
    return (T) this;
  }

  /** @return fileResourceIds */
  public Set<String> getFileResourceIds() {
    return this.fileResourceIds;
  }

  /**
   * @param fileResourceIds fileResourceIds to set
   * @return MapIconFilter
   */
  public <T extends MapIconFilter> T setFileResourceIds(Set<String> fileResourceIds) {
    this.fileResourceIds = fileResourceIds;
    return (T) this;
  }

  /** @return basicPropertiesFilter */
  public BasicPropertiesFilter getBasicPropertiesFilter() {
    return this.basicPropertiesFilter;
  }

  /**
   * @param basicPropertiesFilter basicPropertiesFilter to set
   * @return MapIconFilter
   */
  public <T extends MapIconFilter> T setBasicPropertiesFilter(
      BasicPropertiesFilter basicPropertiesFilter) {
    this.basicPropertiesFilter = basicPropertiesFilter;
    return (T) this;
  }
}
