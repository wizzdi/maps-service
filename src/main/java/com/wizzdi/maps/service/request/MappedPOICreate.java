package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.territories.Address;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.security.request.BasicCreate;

public class MappedPOICreate extends BasicCreate {

  private String geoHash7;

  private String iconId;

  private String geoHash10;

  private String geoHash2;

  private Double y;

  private String geoHash11;

  private String geoHash4;

  private String geoHash6;

  private String geoHash8;

  private Double z;

  private String geoHash1;

  private String geoHash3;

  private String addressId;

  private String geoHash9;

  private Double lat;

  private Double x;

  @JsonIgnore private Address address;

  @JsonIgnore private FileResource icon;

  private String geoHash12;

  private Double lon;

  private String geoHash5;

  public String getGeoHash7() {
    return this.geoHash7;
  }

  public <T extends MappedPOICreate> T setGeoHash7(String geoHash7) {
    this.geoHash7 = geoHash7;
    return (T) this;
  }

  public String getIconId() {
    return this.iconId;
  }

  public <T extends MappedPOICreate> T setIconId(String iconId) {
    this.iconId = iconId;
    return (T) this;
  }

  public String getGeoHash10() {
    return this.geoHash10;
  }

  public <T extends MappedPOICreate> T setGeoHash10(String geoHash10) {
    this.geoHash10 = geoHash10;
    return (T) this;
  }

  public String getGeoHash2() {
    return this.geoHash2;
  }

  public <T extends MappedPOICreate> T setGeoHash2(String geoHash2) {
    this.geoHash2 = geoHash2;
    return (T) this;
  }

  public Double getY() {
    return this.y;
  }

  public <T extends MappedPOICreate> T setY(Double y) {
    this.y = y;
    return (T) this;
  }

  public String getGeoHash11() {
    return this.geoHash11;
  }

  public <T extends MappedPOICreate> T setGeoHash11(String geoHash11) {
    this.geoHash11 = geoHash11;
    return (T) this;
  }

  public String getGeoHash4() {
    return this.geoHash4;
  }

  public <T extends MappedPOICreate> T setGeoHash4(String geoHash4) {
    this.geoHash4 = geoHash4;
    return (T) this;
  }

  public String getGeoHash6() {
    return this.geoHash6;
  }

  public <T extends MappedPOICreate> T setGeoHash6(String geoHash6) {
    this.geoHash6 = geoHash6;
    return (T) this;
  }

  public String getGeoHash8() {
    return this.geoHash8;
  }

  public <T extends MappedPOICreate> T setGeoHash8(String geoHash8) {
    this.geoHash8 = geoHash8;
    return (T) this;
  }

  public Double getZ() {
    return this.z;
  }

  public <T extends MappedPOICreate> T setZ(Double z) {
    this.z = z;
    return (T) this;
  }

  public String getGeoHash1() {
    return this.geoHash1;
  }

  public <T extends MappedPOICreate> T setGeoHash1(String geoHash1) {
    this.geoHash1 = geoHash1;
    return (T) this;
  }

  public String getGeoHash3() {
    return this.geoHash3;
  }

  public <T extends MappedPOICreate> T setGeoHash3(String geoHash3) {
    this.geoHash3 = geoHash3;
    return (T) this;
  }

  public String getAddressId() {
    return this.addressId;
  }

  public <T extends MappedPOICreate> T setAddressId(String addressId) {
    this.addressId = addressId;
    return (T) this;
  }

  public String getGeoHash9() {
    return this.geoHash9;
  }

  public <T extends MappedPOICreate> T setGeoHash9(String geoHash9) {
    this.geoHash9 = geoHash9;
    return (T) this;
  }

  public Double getLat() {
    return this.lat;
  }

  public <T extends MappedPOICreate> T setLat(Double lat) {
    this.lat = lat;
    return (T) this;
  }

  public Double getX() {
    return this.x;
  }

  public <T extends MappedPOICreate> T setX(Double x) {
    this.x = x;
    return (T) this;
  }

  @JsonIgnore
  public Address getAddress() {
    return this.address;
  }

  public <T extends MappedPOICreate> T setAddress(Address address) {
    this.address = address;
    return (T) this;
  }

  @JsonIgnore
  public FileResource getIcon() {
    return this.icon;
  }

  public <T extends MappedPOICreate> T setIcon(FileResource icon) {
    this.icon = icon;
    return (T) this;
  }

  public String getGeoHash12() {
    return this.geoHash12;
  }

  public <T extends MappedPOICreate> T setGeoHash12(String geoHash12) {
    this.geoHash12 = geoHash12;
    return (T) this;
  }

  public Double getLon() {
    return this.lon;
  }

  public <T extends MappedPOICreate> T setLon(Double lon) {
    this.lon = lon;
    return (T) this;
  }

  public String getGeoHash5() {
    return this.geoHash5;
  }

  public <T extends MappedPOICreate> T setGeoHash5(String geoHash5) {
    this.geoHash5 = geoHash5;
    return (T) this;
  }
}
