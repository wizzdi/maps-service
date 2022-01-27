package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.maps.model.Room;

/** Object Used to Update Room */
public class RoomUpdate extends RoomCreate {

  @JsonIgnore private Room room;

  private String id;

  /** @return room */
  @JsonIgnore
  public Room getRoom() {
    return this.room;
  }

  /**
   * @param room room to set
   * @return RoomUpdate
   */
  public <T extends RoomUpdate> T setRoom(Room room) {
    this.room = room;
    return (T) this;
  }

  /** @return id */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return RoomUpdate
   */
  public <T extends RoomUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
