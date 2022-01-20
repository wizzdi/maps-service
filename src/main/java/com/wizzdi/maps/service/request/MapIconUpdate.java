package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.maps.model.MapIcon;

/** Object Used to Update MapIcon */
public class MapIconUpdate extends MapIconCreate {

  private String id;

  @JsonIgnore private MapIcon mapIcon;

  /** @return id */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return MapIconUpdate
   */
  public <T extends MapIconUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /** @return mapIcon */
  @JsonIgnore
  public MapIcon getMapIcon() {
    return this.mapIcon;
  }

  /**
   * @param mapIcon mapIcon to set
   * @return MapIconUpdate
   */
  public <T extends MapIconUpdate> T setMapIcon(MapIcon mapIcon) {
    this.mapIcon = mapIcon;
    return (T) this;
  }
}
