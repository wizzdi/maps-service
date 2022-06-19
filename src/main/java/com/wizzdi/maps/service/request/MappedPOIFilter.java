package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.SecurityTenant;
import com.flexicore.model.territories.Address;
import com.flexicore.territories.request.AddressFilter;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import com.wizzdi.flexicore.security.validation.IdValid;
import com.wizzdi.maps.model.Room;

import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.Room;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Object Used to List MappedPOI */
@com.wizzdi.flexicore.security.validation.IdValid.List({
  @IdValid(
      targetField = "address",
      field = "addressIds",
      fieldType = com.flexicore.model.territories.Address.class),
  @IdValid(
      targetField = "mapIcon",
      field = "mapIconIds",
      fieldType = com.wizzdi.maps.model.MapIcon.class),
  @IdValid(targetField = "room", field = "roomIds", fieldType = com.wizzdi.maps.model.Room.class),
  @IdValid(
      targetField = "mappedPOILocationHistories",
      field = "mappedPOILocationHistoriesIds",
      fieldType = com.wizzdi.maps.model.LocationHistory.class)
})
public class MappedPOIFilter extends PaginationFilter {

  private Set<String> addressIds=new HashSet<>();
  @JsonIgnore
  private List<Address> address;
  private boolean addressExclude;
  private BasicPropertiesFilter basicPropertiesFilter;
  private LocationArea locationArea;
  @JsonIgnore
  private List<Room> room;
  private boolean roomExclude;

  private Set<String> roomIds=new HashSet<>();
  private MapGroupFilter mapGroupFilter;
  private Set<String> externalId;
  private boolean externalIdExclude;

  private Set<String> relatedType;
  private boolean relatedTypeExclude;

  private Set<String> relatedId;
  private boolean relatedIdExclude;

  private AddressFilter addressFilter;
  @JsonIgnore
  private List<MapIcon> mapIcons;
  private boolean mapIconsExclude;

  private Set<String> mapIconsIds=new HashSet<>();
  @JsonIgnore
  private List<SecurityTenant> tenants;
  private boolean tenantsExclude;

  private Set<String> tenantIds=new HashSet<>();





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

  @JsonIgnore
  public List<MapIcon> getMapIcons() {
    return mapIcons;
  }

  public <T extends MappedPOIFilter> T setMapIcons(List<MapIcon> mapIcons) {
    this.mapIcons = mapIcons;
    return (T) this;
  }

  public Set<String> getMapIconsIds() {
    return mapIconsIds;
  }

  public <T extends MappedPOIFilter> T setMapIconsIds(Set<String> mapIconsIds) {
    this.mapIconsIds = mapIconsIds;
    return (T) this;
  }

  @JsonIgnore
  public List<SecurityTenant> getTenants() {
    return tenants;
  }

  public <T extends MappedPOIFilter> T setTenants(List<SecurityTenant> tenants) {
    this.tenants = tenants;
    return (T) this;
  }

  public Set<String> getTenantIds() {
    return tenantIds;
  }

  public <T extends MappedPOIFilter> T setTenantIds(Set<String> tenantIds) {
    this.tenantIds = tenantIds;
    return (T) this;
  }

  public boolean isAddressExclude() {
    return addressExclude;
  }

  public <T extends MappedPOIFilter> T setAddressExclude(boolean addressExclude) {
    this.addressExclude = addressExclude;
    return (T) this;
  }

  public boolean isRoomExclude() {
    return roomExclude;
  }

  public <T extends MappedPOIFilter> T setRoomExclude(boolean roomExclude) {
    this.roomExclude = roomExclude;
    return (T) this;
  }

  public boolean isExternalIdExclude() {
    return externalIdExclude;
  }

  public <T extends MappedPOIFilter> T setExternalIdExclude(boolean externalIdExclude) {
    this.externalIdExclude = externalIdExclude;
    return (T) this;
  }

  public boolean isRelatedTypeExclude() {
    return relatedTypeExclude;
  }

  public <T extends MappedPOIFilter> T setRelatedTypeExclude(boolean relatedTypeExclude) {
    this.relatedTypeExclude = relatedTypeExclude;
    return (T) this;
  }

  public boolean isRelatedIdExclude() {
    return relatedIdExclude;
  }

  public <T extends MappedPOIFilter> T setRelatedIdExclude(boolean relatedIdExclude) {
    this.relatedIdExclude = relatedIdExclude;
    return (T) this;
  }

  public boolean isMapIconsExclude() {
    return mapIconsExclude;
  }

  public <T extends MappedPOIFilter> T setMapIconsExclude(boolean mapIconsExclude) {
    this.mapIconsExclude = mapIconsExclude;
    return (T) this;
  }

  public boolean isTenantsExclude() {
    return tenantsExclude;
  }

  public <T extends MappedPOIFilter> T setTenantsExclude(boolean tenantsExclude) {
    this.tenantsExclude = tenantsExclude;
    return (T) this;
  }
}
