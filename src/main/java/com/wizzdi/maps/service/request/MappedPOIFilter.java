package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.territories.Address;
import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.Room;
import java.util.List;
import java.util.Set;

public class MappedPOIFilter extends PaginationFilter {

  private Set<String> geoHash7;

  private Set<String> geoHash10;

  private Set<String> geoHash2;

  private Set<Double> y;

  private Set<String> geoHash11;

  private Set<String> geoHash4;

  private Set<String> geoHash6;

  private Set<String> geoHash8;

  private Set<Double> z;

  private Set<String> geoHash1;

  private Set<String> geoHash3;

  @JsonIgnore private List<MapIcon> mapIcon;

  private Set<String> mapIconIds;

  private Set<String> addressIds;

  private Set<String> geoHash9;

  @JsonIgnore private List<Room> room;

  private Set<Double> lat;

  private Set<Double> x;

  private Set<String> roomIds;

  @JsonIgnore private List<Address> address;

  private Set<String> geoHash12;

  private BasicPropertiesFilter basicPropertiesFilter;

  private Set<Double> lon;

  private Set<String> geoHash5;

  public Set<String> getGeoHash7() {
    return this.geoHash7;
  }

  public <T extends MappedPOIFilter> T setGeoHash7(Set<String> geoHash7) {
    this.geoHash7 = geoHash7;
    return (T) this;
  }

  public Set<String> getGeoHash10() {
    return this.geoHash10;
  }

  public <T extends MappedPOIFilter> T setGeoHash10(Set<String> geoHash10) {
    this.geoHash10 = geoHash10;
    return (T) this;
  }

  public Set<String> getGeoHash2() {
    return this.geoHash2;
  }

  public <T extends MappedPOIFilter> T setGeoHash2(Set<String> geoHash2) {
    this.geoHash2 = geoHash2;
    return (T) this;
  }

  public Set<Double> getY() {
    return this.y;
  }

  public <T extends MappedPOIFilter> T setY(Set<Double> y) {
    this.y = y;
    return (T) this;
  }

  public Set<String> getGeoHash11() {
    return this.geoHash11;
  }

  public <T extends MappedPOIFilter> T setGeoHash11(Set<String> geoHash11) {
    this.geoHash11 = geoHash11;
    return (T) this;
  }

  public Set<String> getGeoHash4() {
    return this.geoHash4;
  }

  public <T extends MappedPOIFilter> T setGeoHash4(Set<String> geoHash4) {
    this.geoHash4 = geoHash4;
    return (T) this;
  }

  public Set<String> getGeoHash6() {
    return this.geoHash6;
  }

  public <T extends MappedPOIFilter> T setGeoHash6(Set<String> geoHash6) {
    this.geoHash6 = geoHash6;
    return (T) this;
  }

  public Set<String> getGeoHash8() {
    return this.geoHash8;
  }

  public <T extends MappedPOIFilter> T setGeoHash8(Set<String> geoHash8) {
    this.geoHash8 = geoHash8;
    return (T) this;
  }

  public Set<Double> getZ() {
    return this.z;
  }

  public <T extends MappedPOIFilter> T setZ(Set<Double> z) {
    this.z = z;
    return (T) this;
  }

  public Set<String> getGeoHash1() {
    return this.geoHash1;
  }

  public <T extends MappedPOIFilter> T setGeoHash1(Set<String> geoHash1) {
    this.geoHash1 = geoHash1;
    return (T) this;
  }

  public Set<String> getGeoHash3() {
    return this.geoHash3;
  }

  public <T extends MappedPOIFilter> T setGeoHash3(Set<String> geoHash3) {
    this.geoHash3 = geoHash3;
    return (T) this;
  }

  @JsonIgnore
  public List<MapIcon> getMapIcon() {
    return this.mapIcon;
  }

  public <T extends MappedPOIFilter> T setMapIcon(List<MapIcon> mapIcon) {
    this.mapIcon = mapIcon;
    return (T) this;
  }

  public Set<String> getMapIconIds() {
    return this.mapIconIds;
  }

  public <T extends MappedPOIFilter> T setMapIconIds(Set<String> mapIconIds) {
    this.mapIconIds = mapIconIds;
    return (T) this;
  }

  public Set<String> getAddressIds() {
    return this.addressIds;
  }

  public <T extends MappedPOIFilter> T setAddressIds(Set<String> addressIds) {
    this.addressIds = addressIds;
    return (T) this;
  }

  public Set<String> getGeoHash9() {
    return this.geoHash9;
  }

  public <T extends MappedPOIFilter> T setGeoHash9(Set<String> geoHash9) {
    this.geoHash9 = geoHash9;
    return (T) this;
  }

  @JsonIgnore
  public List<Room> getRoom() {
    return this.room;
  }

  public <T extends MappedPOIFilter> T setRoom(List<Room> room) {
    this.room = room;
    return (T) this;
  }

  public Set<Double> getLat() {
    return this.lat;
  }

  public <T extends MappedPOIFilter> T setLat(Set<Double> lat) {
    this.lat = lat;
    return (T) this;
  }

  public Set<Double> getX() {
    return this.x;
  }

  public <T extends MappedPOIFilter> T setX(Set<Double> x) {
    this.x = x;
    return (T) this;
  }

  public Set<String> getRoomIds() {
    return this.roomIds;
  }

  public <T extends MappedPOIFilter> T setRoomIds(Set<String> roomIds) {
    this.roomIds = roomIds;
    return (T) this;
  }

  @JsonIgnore
  public List<Address> getAddress() {
    return this.address;
  }

  public <T extends MappedPOIFilter> T setAddress(List<Address> address) {
    this.address = address;
    return (T) this;
  }

  public Set<String> getGeoHash12() {
    return this.geoHash12;
  }

  public <T extends MappedPOIFilter> T setGeoHash12(Set<String> geoHash12) {
    this.geoHash12 = geoHash12;
    return (T) this;
  }

  public BasicPropertiesFilter getBasicPropertiesFilter() {
    return this.basicPropertiesFilter;
  }

  public <T extends MappedPOIFilter> T setBasicPropertiesFilter(
      BasicPropertiesFilter basicPropertiesFilter) {
    this.basicPropertiesFilter = basicPropertiesFilter;
    return (T) this;
  }

  public Set<Double> getLon() {
    return this.lon;
  }

  public <T extends MappedPOIFilter> T setLon(Set<Double> lon) {
    this.lon = lon;
    return (T) this;
  }

  public Set<String> getGeoHash5() {
    return this.geoHash5;
  }

  public <T extends MappedPOIFilter> T setGeoHash5(Set<String> geoHash5) {
    this.geoHash5 = geoHash5;
    return (T) this;
  }
}
