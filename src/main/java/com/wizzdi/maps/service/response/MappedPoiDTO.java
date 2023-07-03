package com.wizzdi.maps.service.response;

public class MappedPoiDTO {

    private final String id;
    private final MapIconDTO mapIcon;
    private final Double lat;
    private final Double lon;


    public MappedPoiDTO(String id, String mapIconId, double lat, double lon) {
        this.id = id;
        this.mapIcon = new MapIconDTO(mapIconId);
        this.lat = lat;
        this.lon = lon;
    }

    public String getId() {
        return id;
    }

    public MapIconDTO getMapIcon() {
        return mapIcon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
