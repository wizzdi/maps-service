package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.security.request.BasicCreate;
import com.wizzdi.maps.model.MapGroup;
import com.wizzdi.maps.model.MappedPOI;

public class MapGroupToMappedPOICreate extends BasicCreate {

  private String mapGroupId;

  private String mappedPOIId;

  @JsonIgnore private MappedPOI mappedPOI;

  @JsonIgnore private MapGroup mapGroup;

  public String getMapGroupId() {
    return this.mapGroupId;
  }

  public <T extends MapGroupToMappedPOICreate> T setMapGroupId(String mapGroupId) {
    this.mapGroupId = mapGroupId;
    return (T) this;
  }

  public String getMappedPOIId() {
    return this.mappedPOIId;
  }

  public <T extends MapGroupToMappedPOICreate> T setMappedPOIId(String mappedPOIId) {
    this.mappedPOIId = mappedPOIId;
    return (T) this;
  }

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
