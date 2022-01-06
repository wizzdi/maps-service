package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import com.wizzdi.maps.model.MapGroup;
import com.wizzdi.maps.model.MappedPOI;
import java.util.List;
import java.util.Set;

public class MapGroupToMappedPOIFilter extends PaginationFilter {

  private Set<String> mapGroupIds;

  private Set<String> mappedPOIIds;

  private BasicPropertiesFilter basicPropertiesFilter;

  @JsonIgnore private List<MappedPOI> mappedPOI;

  @JsonIgnore private List<MapGroup> mapGroup;

  public Set<String> getMapGroupIds() {
    return this.mapGroupIds;
  }

  public <T extends MapGroupToMappedPOIFilter> T setMapGroupIds(Set<String> mapGroupIds) {
    this.mapGroupIds = mapGroupIds;
    return (T) this;
  }

  public Set<String> getMappedPOIIds() {
    return this.mappedPOIIds;
  }

  public <T extends MapGroupToMappedPOIFilter> T setMappedPOIIds(Set<String> mappedPOIIds) {
    this.mappedPOIIds = mappedPOIIds;
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
}
