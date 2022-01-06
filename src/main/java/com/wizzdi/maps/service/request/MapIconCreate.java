package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.security.request.BasicCreate;

public class MapIconCreate extends BasicCreate {

  private String fileResourceId;

  @JsonIgnore private FileResource fileResource;

  private String externalId;

  public String getFileResourceId() {
    return this.fileResourceId;
  }

  public <T extends MapIconCreate> T setFileResourceId(String fileResourceId) {
    this.fileResourceId = fileResourceId;
    return (T) this;
  }

  @JsonIgnore
  public FileResource getFileResource() {
    return this.fileResource;
  }

  public <T extends MapIconCreate> T setFileResource(FileResource fileResource) {
    this.fileResource = fileResource;
    return (T) this;
  }

  public String getExternalId() {
    return this.externalId;
  }

  public <T extends MapIconCreate> T setExternalId(String externalId) {
    this.externalId = externalId;
    return (T) this;
  }
}
