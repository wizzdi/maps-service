package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.maps.model.LocationHistory;

/** Object Used to Update LocationHistory */
public class LocationHistoryUpdate extends LocationHistoryCreate {

  @JsonIgnore private LocationHistory locationHistory;

  private String id;

  /** @return locationHistory */
  @JsonIgnore
  public LocationHistory getLocationHistory() {
    return this.locationHistory;
  }

  /**
   * @param locationHistory locationHistory to set
   * @return LocationHistoryUpdate
   */
  public <T extends LocationHistoryUpdate> T setLocationHistory(LocationHistory locationHistory) {
    this.locationHistory = locationHistory;
    return (T) this;
  }

  /** @return id */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return LocationHistoryUpdate
   */
  public <T extends LocationHistoryUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
