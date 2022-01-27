package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.maps.model.MapGroup;

/** Object Used to Update MapGroup */
public class MapGroupUpdate extends MapGroupCreate {

  @JsonIgnore private MapGroup mapGroup;

  private String id;

  /** @return mapGroup */
  @JsonIgnore
  public MapGroup getMapGroup() {
    return this.mapGroup;
  }

  /**
   * @param mapGroup mapGroup to set
   * @return MapGroupUpdate
   */
  public <T extends MapGroupUpdate> T setMapGroup(MapGroup mapGroup) {
    this.mapGroup = mapGroup;
    return (T) this;
  }

  /** @return id */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return MapGroupUpdate
   */
  public <T extends MapGroupUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
