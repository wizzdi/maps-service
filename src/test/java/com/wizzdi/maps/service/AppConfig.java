package com.wizzdi.maps.service;

import com.flexicore.security.SecurityContextBase;
import com.wizzdi.maps.model.Building;
import com.wizzdi.maps.model.MapGroup;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.model.Room;
import com.wizzdi.maps.service.request.BuildingCreate;
import com.wizzdi.maps.service.request.MapGroupCreate;
import com.wizzdi.maps.service.request.MapIconCreate;
import com.wizzdi.maps.service.request.MappedPOICreate;
import com.wizzdi.maps.service.request.RoomCreate;
import com.wizzdi.maps.service.service.BuildingService;
import com.wizzdi.maps.service.service.MapGroupService;
import com.wizzdi.maps.service.service.MapIconService;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.service.request.MappedPOICreate;
import com.wizzdi.maps.service.service.MappedPOIService;
import com.wizzdi.maps.service.service.MappedPOIService;
import com.wizzdi.maps.service.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    public static final String ON = "on";
    public static final String OFF = "off";
    public static final String UNKNOWN = "unknown";
    @Autowired
    private RoomService roomService;

    @Autowired
    private MappedPOIService mappedPOIService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private MapIconService mapIconService;

    @Autowired
    @Qualifier("adminSecurityContext")
    private SecurityContextBase securityContext;


    @Autowired
    private MapGroupService mapGroupService;

    @Bean
    public MappedPOI first() {
        return mappedPOIService.createMappedPOI(new MappedPOICreate().setLat(32.06121634257458).setLon(34.77602769776043).setName("first"), securityContext);
    }

    @Bean
    public MappedPOI second() {
        return mappedPOIService.createMappedPOI(new MappedPOICreate().setLat(32.06207103256403).setLon(34.777958888094304).setName("second"), securityContext);
    }


    @Bean
    @Qualifier("historyIcons")
    public Map<String,MapIcon> historyIcons(){
        String type="test";
        Map<String,MapIcon> map=new HashMap<>();
        for (String statusName : Arrays.asList(ON, OFF, UNKNOWN)) {
            String externalId=type+"_"+statusName;
            map.put(statusName,mapIconService.createMapIcon(new MapIconCreate().setExternalId(externalId).setName(statusName),securityContext));
        }
        return map;
    }

    @Bean
    public Room room() {
        RoomCreate roomCreate = new RoomCreate();
        return roomService.createRoom(roomCreate, securityContext);
    }

    @Bean
    public MappedPOI mappedPOI() {
        MappedPOICreate mappedPOICreate = new MappedPOICreate();
        return mappedPOIService.createMappedPOI(mappedPOICreate, securityContext);
    }

    @Bean
    public MapGroup mapGroup() {
        MapGroupCreate mapGroupCreate = new MapGroupCreate();
        return mapGroupService.createMapGroup(mapGroupCreate, securityContext);
    }

    @Bean
    public Building building() {
        BuildingCreate buildingCreate = new BuildingCreate();
        return buildingService.createBuilding(buildingCreate, securityContext);
    }

    @Bean
    public MapIcon mapIcon() {
        MapIconCreate mapIconCreate = new MapIconCreate();
        return mapIconService.createMapIcon(mapIconCreate, securityContext);
    }
}
