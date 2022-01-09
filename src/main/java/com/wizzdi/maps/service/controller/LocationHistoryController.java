package com.wizzdi.maps.service.controller;

import com.flexicore.annotations.OperationsInside;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.maps.model.LocationHistory;
import com.wizzdi.maps.model.LocationHistory_;
import com.wizzdi.maps.service.request.LocationHistoryCreate;
import com.wizzdi.maps.service.request.LocationHistoryFilter;
import com.wizzdi.maps.service.request.LocationHistoryUpdate;
import com.wizzdi.maps.service.service.LocationHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("LocationHistory")
@Extension
@Tag(name = "LocationHistory")
@OperationsInside
public class LocationHistoryController implements Plugin {

  @Autowired private LocationHistoryService locationHistoryService;

  @PostMapping("createLocationHistory")
  @Operation(summary = "createLocationHistory", description = "Creates LocationHistory")
  public LocationHistory createLocationHistory(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody LocationHistoryCreate locationHistoryCreate,
      @RequestAttribute SecurityContextBase securityContext) {
    locationHistoryService.validate(locationHistoryCreate, securityContext);
    return locationHistoryService.createLocationHistory(locationHistoryCreate, securityContext);
  }

  @Operation(summary = "updateLocationHistory", description = "Updates LocationHistory")
  @PutMapping("updateLocationHistory")
  public LocationHistory updateLocationHistory(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody LocationHistoryUpdate locationHistoryUpdate,
      @RequestAttribute SecurityContextBase securityContext) {
    String locationHistoryId = locationHistoryUpdate.getId();
    LocationHistory locationHistory =
        locationHistoryService.getByIdOrNull(
            locationHistoryId, LocationHistory.class, LocationHistory_.security, securityContext);
    if (locationHistory == null) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "No LocationHistory with id " + locationHistoryId);
    }
    locationHistoryUpdate.setLocationHistory(locationHistory);
    locationHistoryService.validate(locationHistoryUpdate, securityContext);
    return locationHistoryService.updateLocationHistory(locationHistoryUpdate, securityContext);
  }

  @Operation(
      summary = "getAllLocationHistories",
      description = "Gets All LocationHistories Filtered")
  @PostMapping("getAllLocationHistories")
  public PaginationResponse<LocationHistory> getAllLocationHistories(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody LocationHistoryFilter locationHistoryFilter,
      @RequestAttribute SecurityContextBase securityContext) {
    locationHistoryService.validate(locationHistoryFilter, securityContext);
    return locationHistoryService.getAllLocationHistories(locationHistoryFilter, securityContext);
  }
}
