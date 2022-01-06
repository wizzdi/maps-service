package com.wizzdi.maps.service.controller;

import com.flexicore.annotations.OperationsInside;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.maps.model.MapGroup;
import com.wizzdi.maps.model.MapGroup_;
import com.wizzdi.maps.service.request.MapGroupCreate;
import com.wizzdi.maps.service.request.MapGroupFilter;
import com.wizzdi.maps.service.request.MapGroupUpdate;
import com.wizzdi.maps.service.service.MapGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("MapGroup")
@Extension
@Tag(name = "MapGroup")
@OperationsInside
public class MapGroupController implements Plugin {

  @Autowired private MapGroupService mapGroupService;

  @PostMapping("createMapGroup")
  @Operation(summary = "createMapGroup", description = "Creates MapGroup")
  public MapGroup createMapGroup(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody MapGroupCreate mapGroupCreate,
      @RequestAttribute SecurityContextBase securityContext) {
    mapGroupService.validate(mapGroupCreate, securityContext);
    return mapGroupService.createMapGroup(mapGroupCreate, securityContext);
  }

  @Operation(summary = "updateMapGroup", description = "Updates MapGroup")
  @PutMapping("updateMapGroup")
  public MapGroup updateMapGroup(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody MapGroupUpdate mapGroupUpdate,
      @RequestAttribute SecurityContextBase securityContext) {
    String mapGroupId = mapGroupUpdate.getId();
    MapGroup mapGroup =
        mapGroupService.getByIdOrNull(
            mapGroupId, MapGroup.class, MapGroup_.security, securityContext);
    if (mapGroup == null) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "No MapGroup with id " + mapGroupId);
    }
    mapGroupUpdate.setMapGroup(mapGroup);
    mapGroupService.validate(mapGroupUpdate, securityContext);
    return mapGroupService.updateMapGroup(mapGroupUpdate, securityContext);
  }

  @Operation(summary = "getAllMapGroups", description = "Gets All MapGroups Filtered")
  @PostMapping("getAllMapGroups")
  public PaginationResponse<MapGroup> getAllMapGroups(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody MapGroupFilter mapGroupFilter,
      @RequestAttribute SecurityContextBase securityContext) {
    mapGroupService.validate(mapGroupFilter, securityContext);
    return mapGroupService.getAllMapGroups(mapGroupFilter, securityContext);
  }
}
