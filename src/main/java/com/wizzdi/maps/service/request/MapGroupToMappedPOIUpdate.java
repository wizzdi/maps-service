package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.maps.model.MapGroupToMappedPOI;

/** Object Used to Update MapGroupToMappedPOI */
public class MapGroupToMappedPOIUpdate extends MapGroupToMappedPOICreate {

  @JsonIgnore private MapGroupToMappedPOI mapGroupToMappedPOI;

  private String id;

  /** @return mapGroupToMappedPOI */
  @JsonIgnore
  public MapGroupToMappedPOI getMapGroupToMappedPOI() {
    return this.mapGroupToMappedPOI;
  }

  /**
   * @param mapGroupToMappedPOI mapGroupToMappedPOI to set
   * @return MapGroupToMappedPOIUpdate
   */
  public <T extends MapGroupToMappedPOIUpdate> T setMapGroupToMappedPOI(
      MapGroupToMappedPOI mapGroupToMappedPOI) {
    this.mapGroupToMappedPOI = mapGroupToMappedPOI;
    return (T) this;
  }

  /** @return id */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return MapGroupToMappedPOIUpdate
   */
  public <T extends MapGroupToMappedPOIUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
