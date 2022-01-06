package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.maps.model.MapGroupToMappedPOI;

public class MapGroupToMappedPOIUpdate extends MapGroupToMappedPOICreate {

  private String id;
  @JsonIgnore private MapGroupToMappedPOI mapGroupToMappedPOI;

  public String getId() {
    return id;
  }

  public <T extends MapGroupToMappedPOIUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  @JsonIgnore
  public MapGroupToMappedPOI getMapGroupToMappedPOI() {
    return mapGroupToMappedPOI;
  }

  public <T extends MapGroupToMappedPOIUpdate> T setMapGroupToMappedPOI(
      MapGroupToMappedPOI mapGroupToMappedPOI) {
    this.mapGroupToMappedPOI = mapGroupToMappedPOI;
    return (T) this;
  }
}
