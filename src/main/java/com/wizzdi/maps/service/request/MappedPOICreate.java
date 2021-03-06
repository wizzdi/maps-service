package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.territories.Address;
import com.wizzdi.flexicore.security.request.BasicCreate;
import com.wizzdi.flexicore.security.validation.IdValid;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.Room;

/** Object Used to Create MappedPOI */
@com.wizzdi.flexicore.security.validation.IdValid.List({
  @IdValid(
      targetField = "room",
      field = "roomId",
      fieldType = com.wizzdi.maps.model.Room.class,
      groups = {
        com.wizzdi.flexicore.security.validation.Update.class,
        com.wizzdi.flexicore.security.validation.Create.class
      }),
  @IdValid(
      targetField = "mapIcon",
      field = "mapIconId",
      fieldType = com.wizzdi.maps.model.MapIcon.class,
      groups = {
        com.wizzdi.flexicore.security.validation.Create.class,
        com.wizzdi.flexicore.security.validation.Update.class
      }),
  @IdValid(
      targetField = "address",
      field = "addressId",
      fieldType = com.flexicore.model.territories.Address.class,
      groups = {
        com.wizzdi.flexicore.security.validation.Update.class,
        com.wizzdi.flexicore.security.validation.Create.class
      })
})
public class MappedPOICreate extends BasicCreate {

  @JsonIgnore private Address address;

  private String addressId;

  private String externalId;

  private String geoHash1;

  private String geoHash10;

  private String geoHash11;

  private String geoHash12;

  private String geoHash2;

  private String geoHash3;

  private String geoHash4;

  private String geoHash5;

  private String geoHash6;

  private String geoHash7;

  private String geoHash8;

  private String geoHash9;

  private Boolean keepLocationHistory;

  private Boolean keepStatusHistory;

  private Double lat;

  private Double lon;

  @JsonIgnore private MapIcon mapIcon;

  private String mapIconId;

  private String relatedId;

  private String relatedType;

  @JsonIgnore private Room room;

  private String roomId;

  private Double x;

  private Double y;

  private Double z;

  /** @return address */
  @JsonIgnore
  public Address getAddress() {
    return this.address;
  }

  /**
   * @param address address to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setAddress(Address address) {
    this.address = address;
    return (T) this;
  }

  /** @return addressId */
  public String getAddressId() {
    return this.addressId;
  }

  /**
   * @param addressId addressId to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setAddressId(String addressId) {
    this.addressId = addressId;
    return (T) this;
  }

  /** @return externalId */
  public String getExternalId() {
    return this.externalId;
  }

  /**
   * @param externalId externalId to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setExternalId(String externalId) {
    this.externalId = externalId;
    return (T) this;
  }

  /** @return geoHash1 */
  public String getGeoHash1() {
    return this.geoHash1;
  }

  /**
   * @param geoHash1 geoHash1 to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setGeoHash1(String geoHash1) {
    this.geoHash1 = geoHash1;
    return (T) this;
  }

  /** @return geoHash10 */
  public String getGeoHash10() {
    return this.geoHash10;
  }

  /**
   * @param geoHash10 geoHash10 to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setGeoHash10(String geoHash10) {
    this.geoHash10 = geoHash10;
    return (T) this;
  }

  /** @return geoHash11 */
  public String getGeoHash11() {
    return this.geoHash11;
  }

  /**
   * @param geoHash11 geoHash11 to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setGeoHash11(String geoHash11) {
    this.geoHash11 = geoHash11;
    return (T) this;
  }

  /** @return geoHash12 */
  public String getGeoHash12() {
    return this.geoHash12;
  }

  /**
   * @param geoHash12 geoHash12 to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setGeoHash12(String geoHash12) {
    this.geoHash12 = geoHash12;
    return (T) this;
  }

  /** @return geoHash2 */
  public String getGeoHash2() {
    return this.geoHash2;
  }

  /**
   * @param geoHash2 geoHash2 to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setGeoHash2(String geoHash2) {
    this.geoHash2 = geoHash2;
    return (T) this;
  }

  /** @return geoHash3 */
  public String getGeoHash3() {
    return this.geoHash3;
  }

  /**
   * @param geoHash3 geoHash3 to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setGeoHash3(String geoHash3) {
    this.geoHash3 = geoHash3;
    return (T) this;
  }

  /** @return geoHash4 */
  public String getGeoHash4() {
    return this.geoHash4;
  }

  /**
   * @param geoHash4 geoHash4 to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setGeoHash4(String geoHash4) {
    this.geoHash4 = geoHash4;
    return (T) this;
  }

  /** @return geoHash5 */
  public String getGeoHash5() {
    return this.geoHash5;
  }

  /**
   * @param geoHash5 geoHash5 to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setGeoHash5(String geoHash5) {
    this.geoHash5 = geoHash5;
    return (T) this;
  }

  /** @return geoHash6 */
  public String getGeoHash6() {
    return this.geoHash6;
  }

  /**
   * @param geoHash6 geoHash6 to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setGeoHash6(String geoHash6) {
    this.geoHash6 = geoHash6;
    return (T) this;
  }

  /** @return geoHash7 */
  public String getGeoHash7() {
    return this.geoHash7;
  }

  /**
   * @param geoHash7 geoHash7 to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setGeoHash7(String geoHash7) {
    this.geoHash7 = geoHash7;
    return (T) this;
  }

  /** @return geoHash8 */
  public String getGeoHash8() {
    return this.geoHash8;
  }

  /**
   * @param geoHash8 geoHash8 to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setGeoHash8(String geoHash8) {
    this.geoHash8 = geoHash8;
    return (T) this;
  }

  /** @return geoHash9 */
  public String getGeoHash9() {
    return this.geoHash9;
  }

  /**
   * @param geoHash9 geoHash9 to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setGeoHash9(String geoHash9) {
    this.geoHash9 = geoHash9;
    return (T) this;
  }

  /** @return keepLocationHistory */
  public Boolean getKeepLocationHistory() {
    return this.keepLocationHistory;
  }

  /**
   * @param keepLocationHistory keepLocationHistory to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setKeepLocationHistory(Boolean keepLocationHistory) {
    this.keepLocationHistory = keepLocationHistory;
    return (T) this;
  }

  /** @return keepStatusHistory */
  public Boolean getKeepStatusHistory() {
    return this.keepStatusHistory;
  }

  /**
   * @param keepStatusHistory keepStatusHistory to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setKeepStatusHistory(Boolean keepStatusHistory) {
    this.keepStatusHistory = keepStatusHistory;
    return (T) this;
  }

  /** @return lat */
  public Double getLat() {
    return this.lat;
  }

  /**
   * @param lat lat to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setLat(Double lat) {
    this.lat = lat;
    return (T) this;
  }

  /** @return lon */
  public Double getLon() {
    return this.lon;
  }

  /**
   * @param lon lon to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setLon(Double lon) {
    this.lon = lon;
    return (T) this;
  }

  /** @return mapIcon */
  @JsonIgnore
  public MapIcon getMapIcon() {
    return this.mapIcon;
  }

  /**
   * @param mapIcon mapIcon to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setMapIcon(MapIcon mapIcon) {
    this.mapIcon = mapIcon;
    return (T) this;
  }

  /** @return mapIconId */
  public String getMapIconId() {
    return this.mapIconId;
  }

  /**
   * @param mapIconId mapIconId to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setMapIconId(String mapIconId) {
    this.mapIconId = mapIconId;
    return (T) this;
  }

  /** @return relatedId */
  public String getRelatedId() {
    return this.relatedId;
  }

  /**
   * @param relatedId relatedId to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setRelatedId(String relatedId) {
    this.relatedId = relatedId;
    return (T) this;
  }

  /** @return relatedType */
  public String getRelatedType() {
    return this.relatedType;
  }

  /**
   * @param relatedType relatedType to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setRelatedType(String relatedType) {
    this.relatedType = relatedType;
    return (T) this;
  }

  /** @return room */
  @JsonIgnore
  public Room getRoom() {
    return this.room;
  }

  /**
   * @param room room to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setRoom(Room room) {
    this.room = room;
    return (T) this;
  }

  /** @return roomId */
  public String getRoomId() {
    return this.roomId;
  }

  /**
   * @param roomId roomId to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setRoomId(String roomId) {
    this.roomId = roomId;
    return (T) this;
  }

  /** @return x */
  public Double getX() {
    return this.x;
  }

  /**
   * @param x x to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setX(Double x) {
    this.x = x;
    return (T) this;
  }

  /** @return y */
  public Double getY() {
    return this.y;
  }

  /**
   * @param y y to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setY(Double y) {
    this.y = y;
    return (T) this;
  }

  /** @return z */
  public Double getZ() {
    return this.z;
  }

  /**
   * @param z z to set
   * @return MappedPOICreate
   */
  public <T extends MappedPOICreate> T setZ(Double z) {
    this.z = z;
    return (T) this;
  }
}
