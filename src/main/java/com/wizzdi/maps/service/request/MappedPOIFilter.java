package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.territories.Address;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import com.wizzdi.maps.model.Room;

import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.Room;

import java.util.List;
import java.util.Set;

public class MappedPOIFilter extends PaginationFilter {

    private Set<String> addressIds;
    @JsonIgnore
    private List<Address> address;
    private BasicPropertiesFilter basicPropertiesFilter;
    private LocationArea locationArea;
    @JsonIgnore
    private List<Room> room;
    private Set<String> roomIds;
    private MapGroupFilter mapGroupFilter;


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
}
