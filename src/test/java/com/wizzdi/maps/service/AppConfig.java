package com.wizzdi.maps.service;

import com.flexicore.security.SecurityContextBase;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.service.request.MapIconCreate;
import com.wizzdi.maps.service.service.MapIconService;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.service.request.MappedPOICreate;
import com.wizzdi.maps.service.service.MappedPOIService;
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
  @Autowired
  private MappedPOIService mappedPOIService;

  @Bean
  public MappedPOI first(){
    return mappedPOIService.createMappedPOI(new MappedPOICreate().setLat(32.06121634257458).setLon( 34.77602769776043).setName("first"),securityContext);
  }

  @Bean
  public MappedPOI second(){
    return mappedPOIService.createMappedPOI(new MappedPOICreate().setLat(32.06207103256403 ).setLon( 34.777958888094304).setName("second"),securityContext);
  }

  @Bean
  public MapIcon mapIcon() {
    MapIconCreate mapIconCreate = new MapIconCreate();
    return mapIconService.createMapIcon(mapIconCreate, securityContext);
  }
}
