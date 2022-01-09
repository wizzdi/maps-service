package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.model.Room;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

public class LocationHistoryFilter extends PaginationFilter {

  private Set<OffsetDateTime> dateAtLocation;

  private Set<Double> y;

  private Set<Double> z;

  @JsonIgnore private List<Room> room;

  @JsonIgnore private List<MappedPOI> mappedPOI;

  private Set<Double> x;

  private Set<String> roomIds;

  private BasicPropertiesFilter basicPropertiesFilter;

  private Set<String> mappedPOIIds;

  private Set<Double> lon;

  private Set<Double> lat;

  public Set<OffsetDateTime> getDateAtLocation() {
    return this.dateAtLocation;
  }

  public <T extends LocationHistoryFilter> T setDateAtLocation(Set<OffsetDateTime> dateAtLocation) {
    this.dateAtLocation = dateAtLocation;
    return (T) this;
  }

  public Set<Double> getY() {
    return this.y;
  }

  public <T extends LocationHistoryFilter> T setY(Set<Double> y) {
    this.y = y;
    return (T) this;
  }

  public Set<Double> getZ() {
    return this.z;
  }

  public <T extends LocationHistoryFilter> T setZ(Set<Double> z) {
    this.z = z;
    return (T) this;
  }

  @JsonIgnore
  public List<Room> getRoom() {
    return this.room;
  }

  public <T extends LocationHistoryFilter> T setRoom(List<Room> room) {
    this.room = room;
    return (T) this;
  }

  @JsonIgnore
  public List<MappedPOI> getMappedPOI() {
    return this.mappedPOI;
  }

  public <T extends LocationHistoryFilter> T setMappedPOI(List<MappedPOI> mappedPOI) {
    this.mappedPOI = mappedPOI;
    return (T) this;
  }

  public Set<Double> getX() {
    return this.x;
  }

  public <T extends LocationHistoryFilter> T setX(Set<Double> x) {
    this.x = x;
    return (T) this;
  }

  public Set<String> getRoomIds() {
    return this.roomIds;
  }

  public <T extends LocationHistoryFilter> T setRoomIds(Set<String> roomIds) {
    this.roomIds = roomIds;
    return (T) this;
  }

  public BasicPropertiesFilter getBasicPropertiesFilter() {
    return this.basicPropertiesFilter;
  }

  public <T extends LocationHistoryFilter> T setBasicPropertiesFilter(
      BasicPropertiesFilter basicPropertiesFilter) {
    this.basicPropertiesFilter = basicPropertiesFilter;
    return (T) this;
  }

  public Set<String> getMappedPOIIds() {
    return this.mappedPOIIds;
  }

  public <T extends LocationHistoryFilter> T setMappedPOIIds(Set<String> mappedPOIIds) {
    this.mappedPOIIds = mappedPOIIds;
    return (T) this;
  }

  public Set<Double> getLon() {
    return this.lon;
  }

  public <T extends LocationHistoryFilter> T setLon(Set<Double> lon) {
    this.lon = lon;
    return (T) this;
  }

  public Set<Double> getLat() {
    return this.lat;
  }

  public <T extends LocationHistoryFilter> T setLat(Set<Double> lat) {
    this.lat = lat;
    return (T) this;
  }
}
