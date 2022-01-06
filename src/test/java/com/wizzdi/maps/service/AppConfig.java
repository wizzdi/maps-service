package com.wizzdi.maps.service;

import com.flexicore.security.SecurityContextBase;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.service.request.MapIconCreate;
import com.wizzdi.maps.service.service.MapIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Autowired private MapIconService mapIconService;

  @Autowired
  @Qualifier("adminSecurityContext")
  private SecurityContextBase securityContext;

  @Bean
  public MapIcon mapIcon() {
    MapIconCreate mapIconCreate = new MapIconCreate();
    return mapIconService.createMapIcon(mapIconCreate, securityContext);
  }
}
