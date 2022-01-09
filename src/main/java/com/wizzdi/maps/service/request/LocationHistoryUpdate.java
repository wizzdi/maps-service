package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.maps.model.LocationHistory;

public class LocationHistoryUpdate extends LocationHistoryCreate {

  private String id;
  @JsonIgnore private LocationHistory locationHistory;

  public String getId() {
    return id;
  }

  public <T extends LocationHistoryUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  @JsonIgnore
  public LocationHistory getLocationHistory() {
    return locationHistory;
  }

  public <T extends LocationHistoryUpdate> T setLocationHistory(LocationHistory locationHistory) {
    this.locationHistory = locationHistory;
    return (T) this;
  }
}
