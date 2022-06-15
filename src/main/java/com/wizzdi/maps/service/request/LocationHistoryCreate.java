package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.security.request.BasicCreate;
import com.wizzdi.flexicore.security.validation.IdValid;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.model.Room;
import java.time.OffsetDateTime;

/** Object Used to Create LocationHistory */
@com.wizzdi.flexicore.security.validation.IdValid.List({
  @IdValid(
      targetField = "room",
      field = "roomId",
      fieldType = com.wizzdi.maps.model.Room.class,
      groups = {
        com.wizzdi.flexicore.security.validation.Create.class,
        com.wizzdi.flexicore.security.validation.Update.class
      }),
  @IdValid(
      targetField = "mappedPOI",
      field = "mappedPOIId",
      fieldType = com.wizzdi.maps.model.MappedPOI.class,
      groups = {
        com.wizzdi.flexicore.security.validation.Update.class,
        com.wizzdi.flexicore.security.validation.Create.class
      })
})
public class LocationHistoryCreate extends BasicCreate {

  private OffsetDateTime dateAtLocation;

  private Double lat;

  private Double lon;

  @JsonIgnore private MappedPOI mappedPOI;

  private String mappedPOIId;

  @JsonIgnore private Room room;

  private String roomId;

  private Double x;

  private Double y;

  private Double z;

  /** @return dateAtLocation */
  public OffsetDateTime getDateAtLocation() {
    return this.dateAtLocation;
  }

  /**
   * @param dateAtLocation dateAtLocation to set
   * @return LocationHistoryCreate
   */
  public <T extends LocationHistoryCreate> T setDateAtLocation(OffsetDateTime dateAtLocation) {
    this.dateAtLocation = dateAtLocation;
    return (T) this;
  }

  /** @return lat */
  public Double getLat() {
    return this.lat;
  }

  /**
   * @param lat lat to set
   * @return LocationHistoryCreate
   */
  public <T extends LocationHistoryCreate> T setLat(Double lat) {
    this.lat = lat;
    return (T) this;
  }

  /** @return lon */
  public Double getLon() {
    return this.lon;
  }

  /**
   * @param lon lon to set
   * @return LocationHistoryCreate
   */
  public <T extends LocationHistoryCreate> T setLon(Double lon) {
    this.lon = lon;
    return (T) this;
  }

  /** @return mappedPOI */
  @JsonIgnore
  public MappedPOI getMappedPOI() {
    return this.mappedPOI;
  }

  /**
   * @param mappedPOI mappedPOI to set
   * @return LocationHistoryCreate
   */
  public <T extends LocationHistoryCreate> T setMappedPOI(MappedPOI mappedPOI) {
    this.mappedPOI = mappedPOI;
    return (T) this;
  }

  /** @return mappedPOIId */
  public String getMappedPOIId() {
    return this.mappedPOIId;
  }

  /**
   * @param mappedPOIId mappedPOIId to set
   * @return LocationHistoryCreate
   */
  public <T extends LocationHistoryCreate> T setMappedPOIId(String mappedPOIId) {
    this.mappedPOIId = mappedPOIId;
    return (T) this;
  }

  /** @return room */
  @JsonIgnore
  public Room getRoom() {
    return this.room;
  }

  /**
   * @param room room to set
   * @return LocationHistoryCreate
   */
  public <T extends LocationHistoryCreate> T setRoom(Room room) {
    this.room = room;
    return (T) this;
  }

  /** @return roomId */
  public String getRoomId() {
    return this.roomId;
  }

  /**
   * @param roomId roomId to set
   * @return LocationHistoryCreate
   */
  public <T extends LocationHistoryCreate> T setRoomId(String roomId) {
    this.roomId = roomId;
    return (T) this;
  }

  /** @return x */
  public Double getX() {
    return this.x;
  }

  /**
   * @param x x to set
   * @return LocationHistoryCreate
   */
  public <T extends LocationHistoryCreate> T setX(Double x) {
    this.x = x;
    return (T) this;
  }

  /** @return y */
  public Double getY() {
    return this.y;
  }

  /**
   * @param y y to set
   * @return LocationHistoryCreate
   */
  public <T extends LocationHistoryCreate> T setY(Double y) {
    this.y = y;
    return (T) this;
  }

  /** @return z */
  public Double getZ() {
    return this.z;
  }

  /**
   * @param z z to set
   * @return LocationHistoryCreate
   */
  public <T extends LocationHistoryCreate> T setZ(Double z) {
    this.z = z;
    return (T) this;
  }
}
