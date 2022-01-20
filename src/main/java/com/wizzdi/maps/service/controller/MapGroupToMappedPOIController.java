package com.wizzdi.maps.service.controller;

import com.flexicore.annotations.OperationsInside;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.maps.model.MapGroupToMappedPOI;
import com.wizzdi.maps.model.MapGroupToMappedPOI_;
import com.wizzdi.maps.service.request.MapGroupToMappedPOICreate;
import com.wizzdi.maps.service.request.MapGroupToMappedPOIFilter;
import com.wizzdi.maps.service.request.MapGroupToMappedPOIUpdate;
import com.wizzdi.maps.service.service.MapGroupToMappedPOIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("MapGroupToMappedPOI")
@Extension
@Tag(name = "MapGroupToMappedPOI")
@OperationsInside
public class MapGroupToMappedPOIController implements Plugin {

  @Autowired private MapGroupToMappedPOIService mapGroupToMappedPOIService;

  @PostMapping("createMapGroupToMappedPOI")
  @Operation(summary = "createMapGroupToMappedPOI", description = "Creates MapGroupToMappedPOI")
  public MapGroupToMappedPOI createMapGroupToMappedPOI(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody MapGroupToMappedPOICreate mapGroupToMappedPOICreate,
      @RequestAttribute SecurityContextBase securityContext) {

    mapGroupToMappedPOIService.validate(mapGroupToMappedPOICreate, securityContext);
    return mapGroupToMappedPOIService.createMapGroupToMappedPOI(
        mapGroupToMappedPOICreate, securityContext);
  }

  @PutMapping("updateMapGroupToMappedPOI")
  @Operation(summary = "updateMapGroupToMappedPOI", description = "Updates MapGroupToMappedPOI")
  public MapGroupToMappedPOI updateMapGroupToMappedPOI(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody MapGroupToMappedPOIUpdate mapGroupToMappedPOIUpdate,
      @RequestAttribute SecurityContextBase securityContext) {

    String mapGroupToMappedPOIId = mapGroupToMappedPOIUpdate.getId();
    MapGroupToMappedPOI mapGroupToMappedPOI =
        mapGroupToMappedPOIService.getByIdOrNull(
            mapGroupToMappedPOIId,
            MapGroupToMappedPOI.class,
            MapGroupToMappedPOI_.security,
            securityContext);
    if (mapGroupToMappedPOI == null) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "No MapGroupToMappedPOI with id " + mapGroupToMappedPOIId);
    }
    mapGroupToMappedPOIUpdate.setMapGroupToMappedPOI(mapGroupToMappedPOI);
    mapGroupToMappedPOIService.validate(mapGroupToMappedPOIUpdate, securityContext);
    return mapGroupToMappedPOIService.updateMapGroupToMappedPOI(
        mapGroupToMappedPOIUpdate, securityContext);
  }

  @PostMapping("getAllMapGroupToMappedPOIs")
  @Operation(summary = "getAllMapGroupToMappedPOIs", description = "lists MapGroupToMappedPOIs")
  public PaginationResponse<MapGroupToMappedPOI> getAllMapGroupToMappedPOIs(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody MapGroupToMappedPOIFilter mapGroupToMappedPOIFilter,
      @RequestAttribute SecurityContextBase securityContext) {

    mapGroupToMappedPOIService.validate(mapGroupToMappedPOIFilter, securityContext);
    return mapGroupToMappedPOIService.getAllMapGroupToMappedPOIs(
        mapGroupToMappedPOIFilter, securityContext);
  }
}
