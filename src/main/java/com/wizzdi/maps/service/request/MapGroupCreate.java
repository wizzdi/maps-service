package com.wizzdi.maps.service.request;

import com.wizzdi.flexicore.security.request.BasicCreate;

public class MapGroupCreate extends BasicCreate {

  private String externalId;

  public String getExternalId() {
    return this.externalId;
  }

  public <T extends MapGroupCreate> T setExternalId(String externalId) {
    this.externalId = externalId;
    return (T) this;
  }
}
