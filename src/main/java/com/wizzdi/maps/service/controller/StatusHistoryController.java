package com.wizzdi.maps.service.controller;

import com.flexicore.annotations.OperationsInside;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.maps.model.StatusHistory;
import com.wizzdi.maps.model.StatusHistory_;
import com.wizzdi.maps.service.request.StatusHistoryCreate;
import com.wizzdi.maps.service.request.StatusHistoryFilter;
import com.wizzdi.maps.service.request.StatusHistoryUpdate;
import com.wizzdi.maps.service.service.StatusHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("StatusHistory")
@Extension
@Tag(name = "StatusHistory")
@OperationsInside
public class StatusHistoryController implements Plugin {

  @Autowired private StatusHistoryService statusHistoryService;

  @PostMapping("getAllStatusHistories")
  @Operation(summary = "getAllStatusHistories", description = "lists StatusHistories")
  public PaginationResponse<StatusHistory> getAllStatusHistories(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody StatusHistoryFilter statusHistoryFilter,
      @RequestAttribute SecurityContextBase securityContext) {

    statusHistoryService.validate(statusHistoryFilter, securityContext);
    return statusHistoryService.getAllStatusHistories(statusHistoryFilter, securityContext);
  }

  @PutMapping("updateStatusHistory")
  @Operation(summary = "updateStatusHistory", description = "Updates StatusHistory")
  public StatusHistory updateStatusHistory(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody StatusHistoryUpdate statusHistoryUpdate,
      @RequestAttribute SecurityContextBase securityContext) {

    String statusHistoryId = statusHistoryUpdate.getId();
    StatusHistory statusHistory =
        statusHistoryService.getByIdOrNull(
            statusHistoryId, StatusHistory.class, StatusHistory_.security, securityContext);
    if (statusHistory == null) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "No StatusHistory with id " + statusHistoryId);
    }
    statusHistoryUpdate.setStatusHistory(statusHistory);
    statusHistoryService.validate(statusHistoryUpdate, securityContext);
    return statusHistoryService.updateStatusHistory(statusHistoryUpdate, securityContext);
  }

  @PostMapping("createStatusHistory")
  @Operation(summary = "createStatusHistory", description = "Creates StatusHistory")
  public StatusHistory createStatusHistory(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody StatusHistoryCreate statusHistoryCreate,
      @RequestAttribute SecurityContextBase securityContext) {

    statusHistoryService.validate(statusHistoryCreate, securityContext);
    return statusHistoryService.createStatusHistory(statusHistoryCreate, securityContext);
  }
}
