package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.maps.model.MapGroup;

public class MapGroupUpdate extends MapGroupCreate {

  private String id;
  @JsonIgnore private MapGroup mapGroup;

  public String getId() {
    return id;
  }

  public <T extends MapGroupUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  @JsonIgnore
  public MapGroup getMapGroup() {
    return mapGroup;
  }

  public <T extends MapGroupUpdate> T setMapGroup(MapGroup mapGroup) {
    this.mapGroup = mapGroup;
    return (T) this;
  }
}
