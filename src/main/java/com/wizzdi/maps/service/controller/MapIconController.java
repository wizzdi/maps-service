package com.wizzdi.maps.service.controller;

import com.flexicore.annotations.OperationsInside;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.MapIcon_;
import com.wizzdi.maps.service.request.MapIconCreate;
import com.wizzdi.maps.service.request.MapIconFilter;
import com.wizzdi.maps.service.request.MapIconUpdate;
import com.wizzdi.maps.service.service.MapIconService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("MapIcon")
@Extension
@Tag(name = "MapIcon")
@OperationsInside
public class MapIconController implements Plugin {

  @Autowired private MapIconService mapIconService;

  @PostMapping("createMapIcon")
  @Operation(summary = "createMapIcon", description = "Creates MapIcon")
  public MapIcon createMapIcon(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody MapIconCreate mapIconCreate,
      @RequestAttribute SecurityContextBase securityContext) {

    mapIconService.validate(mapIconCreate, securityContext);
    return mapIconService.createMapIcon(mapIconCreate, securityContext);
  }

  @PutMapping("updateMapIcon")
  @Operation(summary = "updateMapIcon", description = "Updates MapIcon")
  public MapIcon updateMapIcon(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody MapIconUpdate mapIconUpdate,
      @RequestAttribute SecurityContextBase securityContext) {

    String mapIconId = mapIconUpdate.getId();
    MapIcon mapIcon =
        mapIconService.getByIdOrNull(mapIconId, MapIcon.class, MapIcon_.security, securityContext);
    if (mapIcon == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No MapIcon with id " + mapIconId);
    }
    mapIconUpdate.setMapIcon(mapIcon);
    mapIconService.validate(mapIconUpdate, securityContext);
    return mapIconService.updateMapIcon(mapIconUpdate, securityContext);
  }

  @PostMapping("getAllMapIcons")
  @Operation(summary = "getAllMapIcons", description = "lists MapIcons")
  public PaginationResponse<MapIcon> getAllMapIcons(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody MapIconFilter mapIconFilter,
      @RequestAttribute SecurityContextBase securityContext) {

    mapIconService.validate(mapIconFilter, securityContext);
    return mapIconService.getAllMapIcons(mapIconFilter, securityContext);
  }
}
