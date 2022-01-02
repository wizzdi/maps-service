package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.maps.model.MappedPOI;

public class MappedPOIUpdate extends MappedPOICreate {

  private String id;
  @JsonIgnore private MappedPOI mappedPOI;

  public String getId() {
    return id;
  }

  public <T extends MappedPOIUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  @JsonIgnore
  public MappedPOI getMappedPOI() {
    return mappedPOI;
  }

  public <T extends MappedPOIUpdate> T setMappedPOI(MappedPOI mappedPOI) {
    this.mappedPOI = mappedPOI;
    return (T) this;
  }
}
