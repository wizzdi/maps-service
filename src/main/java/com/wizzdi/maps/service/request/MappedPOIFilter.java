package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.territories.Address;
import com.flexicore.territories.request.AddressFilter;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import com.wizzdi.maps.model.Room;

import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.Room;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MappedPOIFilter extends PaginationFilter {

  private Set<String> addressIds=new HashSet<>();
  @JsonIgnore
  private List<Address> address;
  private BasicPropertiesFilter basicPropertiesFilter;
  private LocationArea locationArea;
  @JsonIgnore
  private List<Room> room;
  private Set<String> roomIds=new HashSet<>();
  private MapGroupFilter mapGroupFilter;
  private Set<String> externalId;
  private Set<String> relatedType;
  private Set<String> relatedId;
  private AddressFilter addressFilter;





  public Set<String> getAddressIds() {
    return addressIds;
  }

  public <T extends MappedPOIFilter> T setAddressIds(Set<String> addressIds) {
    this.addressIds = addressIds;
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

  public Set<String> getRoomIds() {
    return this.roomIds;
  }

  public <T extends MappedPOIFilter> T setRoomIds(Set<String> roomIds) {
    this.roomIds = roomIds;
    return (T) this;
  }

  @JsonIgnore
  public List<Address> getAddress() {
    return address;
  }

  public <T extends MappedPOIFilter> T setAddress(List<Address> address) {
    this.address = address;
    return (T) this;
  }

  public BasicPropertiesFilter getBasicPropertiesFilter() {
    return basicPropertiesFilter;
  }

  public <T extends MappedPOIFilter> T setBasicPropertiesFilter(BasicPropertiesFilter basicPropertiesFilter) {
    this.basicPropertiesFilter = basicPropertiesFilter;
    return (T) this;
  }

  public LocationArea getLocationArea() {
    return locationArea;
  }

  public <T extends MappedPOIFilter> T setLocationArea(LocationArea locationArea) {
    this.locationArea = locationArea;
    return (T) this;
  }

  public MapGroupFilter getMapGroupFilter() {
    return mapGroupFilter;
  }

  public <T extends MappedPOIFilter> T setMapGroupFilter(MapGroupFilter mapGroupFilter) {
    this.mapGroupFilter = mapGroupFilter;
    return (T) this;
  }
  public Set<String> getExternalId() {
    return this.externalId;
  }

  public <T extends MappedPOIFilter> T setExternalId(Set<String> externalId) {
    this.externalId = externalId;
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

  /** @return relatedId */
  public Set<String> getRelatedId() {
    return this.relatedId;
  }

  /**
   * @param relatedId relatedId to set
   * @return MappedPOIFilter
   */
  public <T extends MappedPOIFilter> T setRelatedId(Set<String> relatedId) {
    this.relatedId = relatedId;
    return (T) this;
  }

  public AddressFilter getAddressFilter() {
    return addressFilter;
  }

  public <T extends MappedPOIFilter> T setAddressFilter(AddressFilter addressFilter) {
    this.addressFilter = addressFilter;
    return (T) this;
  }
}
