package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.security.request.BasicCreate;
import com.wizzdi.maps.model.Building;

public class RoomCreate extends BasicCreate {

  @JsonIgnore private Building building;

  private Double z;

  private Double x;

  private String externalId;

  private Double y;

  private String buildingId;

  @JsonIgnore
  public Building getBuilding() {
    return this.building;
  }

  public <T extends RoomCreate> T setBuilding(Building building) {
    this.building = building;
    return (T) this;
  }

  public Double getZ() {
    return this.z;
  }

  public <T extends RoomCreate> T setZ(Double z) {
    this.z = z;
    return (T) this;
  }

  public Double getX() {
    return this.x;
  }

  public <T extends RoomCreate> T setX(Double x) {
    this.x = x;
    return (T) this;
  }

  public String getExternalId() {
    return this.externalId;
  }

  public <T extends RoomCreate> T setExternalId(String externalId) {
    this.externalId = externalId;
    return (T) this;
  }

  public Double getY() {
    return this.y;
  }

  public <T extends RoomCreate> T setY(Double y) {
    this.y = y;
    return (T) this;
  }

  public String getBuildingId() {
    return this.buildingId;
  }

  public <T extends RoomCreate> T setBuildingId(String buildingId) {
    this.buildingId = buildingId;
    return (T) this;
  }
}
