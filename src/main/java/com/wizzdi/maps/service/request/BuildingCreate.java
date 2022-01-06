package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.security.request.BasicCreate;
import com.wizzdi.maps.model.MappedPOI;

public class BuildingCreate extends BasicCreate {

  @JsonIgnore private MappedPOI mappedPOI;

  private String mappedPOIId;

  private String externalId;

  @JsonIgnore
  public MappedPOI getMappedPOI() {
    return this.mappedPOI;
  }

  public <T extends BuildingCreate> T setMappedPOI(MappedPOI mappedPOI) {
    this.mappedPOI = mappedPOI;
    return (T) this;
  }

  public String getMappedPOIId() {
    return this.mappedPOIId;
  }

  public <T extends BuildingCreate> T setMappedPOIId(String mappedPOIId) {
    this.mappedPOIId = mappedPOIId;
    return (T) this;
  }

  public String getExternalId() {
    return this.externalId;
  }

  public <T extends BuildingCreate> T setExternalId(String externalId) {
    this.externalId = externalId;
    return (T) this;
  }
}
