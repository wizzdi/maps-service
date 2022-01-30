package com.wizzdi.maps.service.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.MappedPOI;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;

/** Object Used to List StatusHistory */
public class StatusHistoryFilter extends PaginationFilter {

  private Set<String> mappedPOIIds;

  @JsonIgnore private List<MappedPOI> mappedPOI;

  @JsonIgnore private List<MapIcon> mapIcon;

  private Set<OffsetDateTime> dateAtStatus;

  private BasicPropertiesFilter basicPropertiesFilter;

  private Set<String> mapIconIds;

  /** @return mappedPOIIds */
  public Set<String> getMappedPOIIds() {
    return this.mappedPOIIds;
  }

  /**
   * @param mappedPOIIds mappedPOIIds to set
   * @return StatusHistoryFilter
   */
  public <T extends StatusHistoryFilter> T setMappedPOIIds(Set<String> mappedPOIIds) {
    this.mappedPOIIds = mappedPOIIds;
    return (T) this;
  }

  /** @return mappedPOI */
  @JsonIgnore
  public List<MappedPOI> getMappedPOI() {
    return this.mappedPOI;
  }

  /**
   * @param mappedPOI mappedPOI to set
   * @return StatusHistoryFilter
   */
  public <T extends StatusHistoryFilter> T setMappedPOI(List<MappedPOI> mappedPOI) {
    this.mappedPOI = mappedPOI;
    return (T) this;
  }

  /** @return mapIcon */
  @JsonIgnore
  public List<MapIcon> getMapIcon() {
    return this.mapIcon;
  }

  /**
   * @param mapIcon mapIcon to set
   * @return StatusHistoryFilter
   */
  public <T extends StatusHistoryFilter> T setMapIcon(List<MapIcon> mapIcon) {
    this.mapIcon = mapIcon;
    return (T) this;
  }

  /** @return dateAtStatus */
  public Set<OffsetDateTime> getDateAtStatus() {
    return this.dateAtStatus;
  }

  /**
   * @param dateAtStatus dateAtStatus to set
   * @return StatusHistoryFilter
   */
  public <T extends StatusHistoryFilter> T setDateAtStatus(Set<OffsetDateTime> dateAtStatus) {
    this.dateAtStatus = dateAtStatus;
    return (T) this;
  }

  /** @return basicPropertiesFilter */
  public BasicPropertiesFilter getBasicPropertiesFilter() {
    return this.basicPropertiesFilter;
  }

  /**
   * @param basicPropertiesFilter basicPropertiesFilter to set
   * @return StatusHistoryFilter
   */
  public <T extends StatusHistoryFilter> T setBasicPropertiesFilter(
      BasicPropertiesFilter basicPropertiesFilter) {
    this.basicPropertiesFilter = basicPropertiesFilter;
    return (T) this;
  }

  /** @return mapIconIds */
  public Set<String> getMapIconIds() {
    return this.mapIconIds;
  }

  /**
   * @param mapIconIds mapIconIds to set
   * @return StatusHistoryFilter
   */
  public <T extends StatusHistoryFilter> T setMapIconIds(Set<String> mapIconIds) {
    this.mapIconIds = mapIconIds;
    return (T) this;
  }
}
