package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.maps.model.StatusHistory;

/** Object Used to Update StatusHistory */
public class StatusHistoryUpdate extends StatusHistoryCreate {

  @JsonIgnore private StatusHistory statusHistory;

  private String id;

  /** @return statusHistory */
  @JsonIgnore
  public StatusHistory getStatusHistory() {
    return this.statusHistory;
  }

  /**
   * @param statusHistory statusHistory to set
   * @return StatusHistoryUpdate
   */
  public <T extends StatusHistoryUpdate> T setStatusHistory(StatusHistory statusHistory) {
    this.statusHistory = statusHistory;
    return (T) this;
  }

  /** @return id */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return StatusHistoryUpdate
   */
  public <T extends StatusHistoryUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
