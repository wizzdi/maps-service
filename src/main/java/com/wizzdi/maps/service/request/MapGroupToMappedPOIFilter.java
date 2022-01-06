package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import com.wizzdi.maps.model.MapGroup;
import com.wizzdi.maps.model.MappedPOI;
import java.util.List;

public class MapGroupToMappedPOIFilter extends PaginationFilter {

  @JsonIgnore private List<MappedPOI> mappedPOI;

  @JsonIgnore private List<MapGroup> mapGroup;

  private BasicPropertiesFilter basicPropertiesFilter;

  @JsonIgnore
  public List<MappedPOI> getMappedPOI() {
    return this.mappedPOI;
  }

  public <T extends MapGroupToMappedPOIFilter> T setMappedPOI(List<MappedPOI> mappedPOI) {
    this.mappedPOI = mappedPOI;
    return (T) this;
  }

  @JsonIgnore
  public List<MapGroup> getMapGroup() {
    return this.mapGroup;
  }

  public <T extends MapGroupToMappedPOIFilter> T setMapGroup(List<MapGroup> mapGroup) {
    this.mapGroup = mapGroup;
    return (T) this;
  }

  public BasicPropertiesFilter getBasicPropertiesFilter() {
    return this.basicPropertiesFilter;
  }

  public <T extends MapGroupToMappedPOIFilter> T setBasicPropertiesFilter(
      BasicPropertiesFilter basicPropertiesFilter) {
    this.basicPropertiesFilter = basicPropertiesFilter;
    return (T) this;
  }
}
