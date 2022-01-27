package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.territories.Address;
import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.Room;
import java.util.List;
import java.util.Set;

/** Object Used to List MappedPOI */
public class MappedPOIFilter extends PaginationFilter {

  @JsonIgnore private List<Address> address;

  private Set<Double> y;

  private Set<String> geoHash4;

  private Set<String> addressIds;

  private Set<String> geoHash7;

  private Set<String> geoHash10;

  private BasicPropertiesFilter basicPropertiesFilter;

  private Set<String> geoHash11;

  private Set<String> geoHash12;

  private Set<String> geoHash9;

  private Set<String> geoHash8;

  @JsonIgnore private List<Room> room;

  private Set<Double> x;

  private Set<String> geoHash3;

  private Set<String> relatedType;

  private Set<String> roomIds;

  private Set<Boolean> keepHistory;

  private Set<String> geoHash2;

  private Set<Double> z;

  private Set<String> geoHash1;

  private Set<String> mapIconIds;

  private Set<Double> lat;

  private Set<String> externalId;

  private Set<String> geoHash6;

  @JsonIgnore private List<MapIcon> mapIcon;

  private Set<Double> lon;

  private Set<String> geoHash5;

  /** @return address */
  @JsonIgnore
  public List<Address> getAddress() {
    return this.address;
  }

  /**
   * @param address address to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setAddress(List<Address> address) {
    this.address = address;
    return (T) this;
  }

  /** @return y */
  public Set<Double> getY() {
    return this.y;
  }

  /**
   * @param y y to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setY(Set<Double> y) {
    this.y = y;
    return (T) this;
  }

  /** @return geoHash4 */
  public Set<String> getGeoHash4() {
    return this.geoHash4;
  }

  /**
   * @param geoHash4 geoHash4 to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setGeoHash4(Set<String> geoHash4) {
    this.geoHash4 = geoHash4;
    return (T) this;
  }

  /** @return addressIds */
  public Set<String> getAddressIds() {
    return this.addressIds;
  }

  /**
   * @param addressIds addressIds to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setAddressIds(Set<String> addressIds) {
    this.addressIds = addressIds;
    return (T) this;
  }

  /** @return geoHash7 */
  public Set<String> getGeoHash7() {
    return this.geoHash7;
  }

  /**
   * @param geoHash7 geoHash7 to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setGeoHash7(Set<String> geoHash7) {
    this.geoHash7 = geoHash7;
    return (T) this;
  }

  /** @return geoHash10 */
  public Set<String> getGeoHash10() {
    return this.geoHash10;
  }

  /**
   * @param geoHash10 geoHash10 to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setGeoHash10(Set<String> geoHash10) {
    this.geoHash10 = geoHash10;
    return (T) this;
  }

  /** @return basicPropertiesFilter */
  public BasicPropertiesFilter getBasicPropertiesFilter() {
    return this.basicPropertiesFilter;
  }

  /**
   * @param basicPropertiesFilter basicPropertiesFilter to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setBasicPropertiesFilter(
      BasicPropertiesFilter basicPropertiesFilter) {
    this.basicPropertiesFilter = basicPropertiesFilter;
    return (T) this;
  }

  /** @return geoHash11 */
  public Set<String> getGeoHash11() {
    return this.geoHash11;
  }

  /**
   * @param geoHash11 geoHash11 to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setGeoHash11(Set<String> geoHash11) {
    this.geoHash11 = geoHash11;
    return (T) this;
  }

  /** @return geoHash12 */
  public Set<String> getGeoHash12() {
    return this.geoHash12;
  }

  /**
   * @param geoHash12 geoHash12 to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setGeoHash12(Set<String> geoHash12) {
    this.geoHash12 = geoHash12;
    return (T) this;
  }

  /** @return geoHash9 */
  public Set<String> getGeoHash9() {
    return this.geoHash9;
  }

  /**
   * @param geoHash9 geoHash9 to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setGeoHash9(Set<String> geoHash9) {
    this.geoHash9 = geoHash9;
    return (T) this;
  }

  /** @return geoHash8 */
  public Set<String> getGeoHash8() {
    return this.geoHash8;
  }

  /**
   * @param geoHash8 geoHash8 to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setGeoHash8(Set<String> geoHash8) {
    this.geoHash8 = geoHash8;
    return (T) this;
  }

  /** @return room */
  @JsonIgnore
  public List<Room> getRoom() {
    return this.room;
  }

  /**
   * @param room room to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setRoom(List<Room> room) {
    this.room = room;
    return (T) this;
  }

  /** @return x */
  public Set<Double> getX() {
    return this.x;
  }

  /**
   * @param x x to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setX(Set<Double> x) {
    this.x = x;
    return (T) this;
  }

  /** @return geoHash3 */
  public Set<String> getGeoHash3() {
    return this.geoHash3;
  }

  /**
   * @param geoHash3 geoHash3 to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setGeoHash3(Set<String> geoHash3) {
    this.geoHash3 = geoHash3;
    return (T) this;
  }

  /** @return relatedType */
  public Set<String> getRelatedType() {
    return this.relatedType;
  }

  /**
   * @param relatedType relatedType to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setRelatedType(Set<String> relatedType) {
    this.relatedType = relatedType;
    return (T) this;
  }

  /** @return roomIds */
  public Set<String> getRoomIds() {
    return this.roomIds;
  }

  /**
   * @param roomIds roomIds to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setRoomIds(Set<String> roomIds) {
    this.roomIds = roomIds;
    return (T) this;
  }

  /** @return keepHistory */
  public Set<Boolean> getKeepHistory() {
    return this.keepHistory;
  }

  /**
   * @param keepHistory keepHistory to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setKeepHistory(Set<Boolean> keepHistory) {
    this.keepHistory = keepHistory;
    return (T) this;
  }

  /** @return geoHash2 */
  public Set<String> getGeoHash2() {
    return this.geoHash2;
  }

  /**
   * @param geoHash2 geoHash2 to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setGeoHash2(Set<String> geoHash2) {
    this.geoHash2 = geoHash2;
    return (T) this;
  }

  /** @return z */
  public Set<Double> getZ() {
    return this.z;
  }

  /**
   * @param z z to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setZ(Set<Double> z) {
    this.z = z;
    return (T) this;
  }

  /** @return geoHash1 */
  public Set<String> getGeoHash1() {
    return this.geoHash1;
  }

  /**
   * @param geoHash1 geoHash1 to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setGeoHash1(Set<String> geoHash1) {
    this.geoHash1 = geoHash1;
    return (T) this;
  }

  /** @return mapIconIds */
  public Set<String> getMapIconIds() {
    return this.mapIconIds;
  }

  /**
   * @param mapIconIds mapIconIds to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setMapIconIds(Set<String> mapIconIds) {
    this.mapIconIds = mapIconIds;
    return (T) this;
  }

  /** @return lat */
  public Set<Double> getLat() {
    return this.lat;
  }

  /**
   * @param lat lat to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setLat(Set<Double> lat) {
    this.lat = lat;
    return (T) this;
  }

  /** @return externalId */
  public Set<String> getExternalId() {
    return this.externalId;
  }

  /**
   * @param externalId externalId to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setExternalId(Set<String> externalId) {
    this.externalId = externalId;
    return (T) this;
  }

  /** @return geoHash6 */
  public Set<String> getGeoHash6() {
    return this.geoHash6;
  }

  /**
   * @param geoHash6 geoHash6 to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setGeoHash6(Set<String> geoHash6) {
    this.geoHash6 = geoHash6;
    return (T) this;
  }

  /** @return mapIcon */
  @JsonIgnore
  public List<MapIcon> getMapIcon() {
    return this.mapIcon;
  }

  /**
   * @param mapIcon mapIcon to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setMapIcon(List<MapIcon> mapIcon) {
    this.mapIcon = mapIcon;
    return (T) this;
  }

  /** @return lon */
  public Set<Double> getLon() {
    return this.lon;
  }

  /**
   * @param lon lon to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setLon(Set<Double> lon) {
    this.lon = lon;
    return (T) this;
  }

  /** @return geoHash5 */
  public Set<String> getGeoHash5() {
    return this.geoHash5;
  }

  /**
   * @param geoHash5 geoHash5 to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setGeoHash5(Set<String> geoHash5) {
    this.geoHash5 = geoHash5;
    return (T) this;
  }
}
