package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.territories.Address;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.security.request.BasicCreate;

public class MappedPOICreate extends BasicCreate {

    private String iconId;
    private Double y;
    private Double z;
    private Double lat;
    private Double x;
    private String addressId;
    @JsonIgnore
    private Address address;
    @JsonIgnore
    private FileResource icon;
    private Double lon;


    public String getIconId() {
        return iconId;
    }

    public <T extends MappedPOICreate> T setIconId(String iconId) {
        this.iconId = iconId;
        return (T) this;
    }

    public Double getY() {
        return y;
    }

    public <T extends MappedPOICreate> T setY(Double y) {
        this.y = y;
        return (T) this;
    }

    public Double getZ() {
        return z;
    }

    public <T extends MappedPOICreate> T setZ(Double z) {
        this.z = z;
        return (T) this;
    }

    public Double getLat() {
        return lat;
    }

    public <T extends MappedPOICreate> T setLat(Double lat) {
        this.lat = lat;
        return (T) this;
    }

    public Double getX() {
        return x;
    }

    public <T extends MappedPOICreate> T setX(Double x) {
        this.x = x;
        return (T) this;
    }

    @JsonIgnore
    public Address getAddress() {
        return address;
    }

    public <T extends MappedPOICreate> T setAddress(Address address) {
        this.address = address;
        return (T) this;
    }

    @JsonIgnore
    public FileResource getIcon() {
        return icon;
    }

    public <T extends MappedPOICreate> T setIcon(FileResource icon) {
        this.icon = icon;
        return (T) this;
    }

    public Double getLon() {
        return lon;
    }

    public <T extends MappedPOICreate> T setLon(Double lon) {
        this.lon = lon;
        return (T) this;
    }

    public String getAddressId() {
        return addressId;
    }

    public <T extends MappedPOICreate> T setAddressId(String addressId) {
        this.addressId = addressId;
        return (T) this;
    }
}
