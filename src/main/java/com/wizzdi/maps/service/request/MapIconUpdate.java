package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.maps.model.MapIcon;

public class MapIconUpdate extends MapIconCreate {

  private String id;
  @JsonIgnore private MapIcon mapIcon;

  public String getId() {
    return id;
  }

  public <T extends MapIconUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  @JsonIgnore
  public MapIcon getMapIcon() {
    return mapIcon;
  }

  public <T extends MapIconUpdate> T setMapIcon(MapIcon mapIcon) {
    this.mapIcon = mapIcon;
    return (T) this;
  }
}
