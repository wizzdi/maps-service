package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import com.wizzdi.maps.model.Building;
import java.util.List;
import java.util.Set;

/** Object Used to List Room */
public class RoomFilter extends PaginationFilter {

  private Set<String> buildingIds;

  private Set<Double> z;

  private BasicPropertiesFilter basicPropertiesFilter;

  private Set<String> externalId;

  private Set<Double> y;

  private Set<Double> x;

  @JsonIgnore private List<Building> building;

  /** @return buildingIds */
  public Set<String> getBuildingIds() {
    return this.buildingIds;
  }

  /**
   * @param buildingIds buildingIds to set
   * @return RoomFilter
   */
  public <T extends RoomFilter> T setBuildingIds(Set<String> buildingIds) {
    this.buildingIds = buildingIds;
    return (T) this;
  }

  /** @return z */
  public Set<Double> getZ() {
    return this.z;
  }

  /**
   * @param z z to set
   * @return RoomFilter
   */
  public <T extends RoomFilter> T setZ(Set<Double> z) {
    this.z = z;
    return (T) this;
  }

  /** @return basicPropertiesFilter */
  public BasicPropertiesFilter getBasicPropertiesFilter() {
    return this.basicPropertiesFilter;
  }

  /**
   * @param basicPropertiesFilter basicPropertiesFilter to set
   * @return RoomFilter
   */
  public <T extends RoomFilter> T setBasicPropertiesFilter(
      BasicPropertiesFilter basicPropertiesFilter) {
    this.basicPropertiesFilter = basicPropertiesFilter;
    return (T) this;
  }

  /** @return externalId */
  public Set<String> getExternalId() {
    return this.externalId;
  }

  /**
   * @param externalId externalId to set
   * @return RoomFilter
   */
  public <T extends RoomFilter> T setExternalId(Set<String> externalId) {
    this.externalId = externalId;
    return (T) this;
  }

  /** @return y */
  public Set<Double> getY() {
    return this.y;
  }

  /**
   * @param y y to set
   * @return RoomFilter
   */
  public <T extends RoomFilter> T setY(Set<Double> y) {
    this.y = y;
    return (T) this;
  }

  /** @return x */
  public Set<Double> getX() {
    return this.x;
  }

  /**
   * @param x x to set
   * @return RoomFilter
   */
  public <T extends RoomFilter> T setX(Set<Double> x) {
    this.x = x;
    return (T) this;
  }

  /** @return building */
  @JsonIgnore
  public List<Building> getBuilding() {
    return this.building;
  }

  /**
   * @param building building to set
   * @return RoomFilter
   */
  public <T extends RoomFilter> T setBuilding(List<Building> building) {
    this.building = building;
    return (T) this;
  }
}
