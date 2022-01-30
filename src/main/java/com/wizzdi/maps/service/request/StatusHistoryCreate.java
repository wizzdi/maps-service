package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.security.request.BasicCreate;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.MappedPOI;
import java.time.OffsetDateTime;

/** Object Used to Create StatusHistory */
public class StatusHistoryCreate extends BasicCreate {

  private String mapIconId;

  @JsonIgnore private MappedPOI mappedPOI;

  private String mappedPOIId;

  private OffsetDateTime dateAtStatus;

  @JsonIgnore private MapIcon mapIcon;

  /** @return mapIconId */
  public String getMapIconId() {
    return this.mapIconId;
  }

  /**
   * @param mapIconId mapIconId to set
   * @return StatusHistoryCreate
   */
  public <T extends StatusHistoryCreate> T setMapIconId(String mapIconId) {
    this.mapIconId = mapIconId;
    return (T) this;
  }

  /** @return mappedPOI */
  @JsonIgnore
  public MappedPOI getMappedPOI() {
    return this.mappedPOI;
  }

  /**
   * @param mappedPOI mappedPOI to set
   * @return StatusHistoryCreate
   */
  public <T extends StatusHistoryCreate> T setMappedPOI(MappedPOI mappedPOI) {
    this.mappedPOI = mappedPOI;
    return (T) this;
  }

  /** @return mappedPOIId */
  public String getMappedPOIId() {
    return this.mappedPOIId;
  }

  /**
   * @param mappedPOIId mappedPOIId to set
   * @return StatusHistoryCreate
   */
  public <T extends StatusHistoryCreate> T setMappedPOIId(String mappedPOIId) {
    this.mappedPOIId = mappedPOIId;
    return (T) this;
  }

  /** @return dateAtStatus */
  public OffsetDateTime getDateAtStatus() {
    return this.dateAtStatus;
  }

  /**
   * @param dateAtStatus dateAtStatus to set
   * @return StatusHistoryCreate
   */
  public <T extends StatusHistoryCreate> T setDateAtStatus(OffsetDateTime dateAtStatus) {
    this.dateAtStatus = dateAtStatus;
    return (T) this;
  }

  /** @return mapIcon */
  @JsonIgnore
  public MapIcon getMapIcon() {
    return this.mapIcon;
  }

  /**
   * @param mapIcon mapIcon to set
   * @return StatusHistoryCreate
   */
  public <T extends StatusHistoryCreate> T setMapIcon(MapIcon mapIcon) {
    this.mapIcon = mapIcon;
    return (T) this;
  }
}
