package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.security.request.BasicCreate;
import com.wizzdi.maps.model.MapGroup;
import com.wizzdi.maps.model.MappedPOI;

public class MapGroupToMappedPOICreate extends BasicCreate {

  @JsonIgnore private MappedPOI mappedPOI;

  @JsonIgnore private MapGroup mapGroup;

  @JsonIgnore
  public MappedPOI getMappedPOI() {
    return this.mappedPOI;
  }

  public <T extends MapGroupToMappedPOICreate> T setMappedPOI(MappedPOI mappedPOI) {
    this.mappedPOI = mappedPOI;
    return (T) this;
  }

  @JsonIgnore
  public MapGroup getMapGroup() {
    return this.mapGroup;
  }

  public <T extends MapGroupToMappedPOICreate> T setMapGroup(MapGroup mapGroup) {
    this.mapGroup = mapGroup;
    return (T) this;
  }
}
