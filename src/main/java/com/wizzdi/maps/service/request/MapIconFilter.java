package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import java.util.List;
import java.util.Set;

public class MapIconFilter extends PaginationFilter {

  private Set<String> fileResourceIds;

  @JsonIgnore private List<FileResource> fileResource;

  private Set<String> externalId;

  private BasicPropertiesFilter basicPropertiesFilter;

  public Set<String> getFileResourceIds() {
    return this.fileResourceIds;
  }

  public <T extends MapIconFilter> T setFileResourceIds(Set<String> fileResourceIds) {
    this.fileResourceIds = fileResourceIds;
    return (T) this;
  }

  @JsonIgnore
  public List<FileResource> getFileResource() {
    return this.fileResource;
  }

  public <T extends MapIconFilter> T setFileResource(List<FileResource> fileResource) {
    this.fileResource = fileResource;
    return (T) this;
  }

  public Set<String> getExternalId() {
    return this.externalId;
  }

  public <T extends MapIconFilter> T setExternalId(Set<String> externalId) {
    this.externalId = externalId;
    return (T) this;
  }

  public BasicPropertiesFilter getBasicPropertiesFilter() {
    return this.basicPropertiesFilter;
  }

  public <T extends MapIconFilter> T setBasicPropertiesFilter(
      BasicPropertiesFilter basicPropertiesFilter) {
    this.basicPropertiesFilter = basicPropertiesFilter;
    return (T) this;
  }
}
