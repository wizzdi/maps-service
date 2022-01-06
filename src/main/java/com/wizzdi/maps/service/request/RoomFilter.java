package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import com.wizzdi.maps.model.Building;
import java.util.List;
import java.util.Set;

public class RoomFilter extends PaginationFilter {

  @JsonIgnore private List<Building> building;

  private Set<Double> z;

  private Set<Double> x;

  private Set<String> externalId;

  private Set<Double> y;

  private BasicPropertiesFilter basicPropertiesFilter;

  private Set<String> buildingIds;

  @JsonIgnore
  public List<Building> getBuilding() {
    return this.building;
  }

  public <T extends RoomFilter> T setBuilding(List<Building> building) {
    this.building = building;
    return (T) this;
  }

  public Set<Double> getZ() {
    return this.z;
  }

  public <T extends RoomFilter> T setZ(Set<Double> z) {
    this.z = z;
    return (T) this;
  }

  public Set<Double> getX() {
    return this.x;
  }

  public <T extends RoomFilter> T setX(Set<Double> x) {
    this.x = x;
    return (T) this;
  }

  public Set<String> getExternalId() {
    return this.externalId;
  }

  public <T extends RoomFilter> T setExternalId(Set<String> externalId) {
    this.externalId = externalId;
    return (T) this;
  }

  public Set<Double> getY() {
    return this.y;
  }

  public <T extends RoomFilter> T setY(Set<Double> y) {
    this.y = y;
    return (T) this;
  }

  public BasicPropertiesFilter getBasicPropertiesFilter() {
    return this.basicPropertiesFilter;
  }

  public <T extends RoomFilter> T setBasicPropertiesFilter(
      BasicPropertiesFilter basicPropertiesFilter) {
    this.basicPropertiesFilter = basicPropertiesFilter;
    return (T) this;
  }

  public Set<String> getBuildingIds() {
    return this.buildingIds;
  }

  public <T extends RoomFilter> T setBuildingIds(Set<String> buildingIds) {
    this.buildingIds = buildingIds;
    return (T) this;
  }
}
