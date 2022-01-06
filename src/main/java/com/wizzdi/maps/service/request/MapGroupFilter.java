package com.wizzdi.maps.service.request;

import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;
import java.util.Set;

public class MapGroupFilter extends PaginationFilter {

  private BasicPropertiesFilter basicPropertiesFilter;

  private Set<String> externalId;

  public BasicPropertiesFilter getBasicPropertiesFilter() {
    return this.basicPropertiesFilter;
  }

  public <T extends MapGroupFilter> T setBasicPropertiesFilter(
      BasicPropertiesFilter basicPropertiesFilter) {
    this.basicPropertiesFilter = basicPropertiesFilter;
    return (T) this;
  }

  public Set<String> getExternalId() {
    return this.externalId;
  }

  public <T extends MapGroupFilter> T setExternalId(Set<String> externalId) {
    this.externalId = externalId;
    return (T) this;
  }
}
