package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.security.request.BasicCreate;
import com.wizzdi.maps.model.Building;

/** Object Used to Create Room */
public class RoomCreate extends BasicCreate {

  @JsonIgnore private Building building;

  private String externalId;

  private String buildingId;

  private Double x;

  private Double y;

  private Double z;

  /** @return building */
  @JsonIgnore
  public Building getBuilding() {
    return this.building;
  }

  /**
   * @param building building to set
   * @return RoomCreate
   */
  public <T extends RoomCreate> T setBuilding(Building building) {
    this.building = building;
    return (T) this;
  }

  /** @return externalId */
  public String getExternalId() {
    return this.externalId;
  }

  /**
   * @param externalId externalId to set
   * @return RoomCreate
   */
  public <T extends RoomCreate> T setExternalId(String externalId) {
    this.externalId = externalId;
    return (T) this;
  }

  /** @return buildingId */
  public String getBuildingId() {
    return this.buildingId;
  }

  /**
   * @param buildingId buildingId to set
   * @return RoomCreate
   */
  public <T extends RoomCreate> T setBuildingId(String buildingId) {
    this.buildingId = buildingId;
    return (T) this;
  }

  /** @return x */
  public Double getX() {
    return this.x;
  }

  /**
   * @param x x to set
   * @return RoomCreate
   */
  public <T extends RoomCreate> T setX(Double x) {
    this.x = x;
    return (T) this;
  }

  /** @return y */
  public Double getY() {
    return this.y;
  }

  /**
   * @param y y to set
   * @return RoomCreate
   */
  public <T extends RoomCreate> T setY(Double y) {
    this.y = y;
    return (T) this;
  }

  /** @return z */
  public Double getZ() {
    return this.z;
  }

  /**
   * @param z z to set
   * @return RoomCreate
   */
  public <T extends RoomCreate> T setZ(Double z) {
    this.z = z;
    return (T) this;
  }
}
