package com.wizzdi.maps.service.controller;

import com.flexicore.annotations.OperationsInside;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.maps.service.request.StatusHistoryGroupedRequest;
import com.wizzdi.maps.service.response.StatusHistoryGroupedResponse;
import com.wizzdi.maps.service.service.StatusHistoryGroupedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("StatusHistoryGrouped")
@Extension
@Tag(name = "@RequestMapping(\"StatusHistoryGrouped\")\n")
@OperationsInside
public class StatusHistoryGroupedController implements Plugin {

  @Autowired private StatusHistoryGroupedService statusHistoryGroupedService;

  @PostMapping("listAllStatusHistoriesGrouped")
  @Operation(summary = "listAllStatusHistoriesGrouped", description = "lists StatusHistories grouped")
  public StatusHistoryGroupedResponse listAllStatusHistoriesGrouped(
      @RequestHeader("authenticationKey") String authenticationKey,
      @RequestBody StatusHistoryGroupedRequest statusHistoryGroupedRequest,
      @RequestAttribute SecurityContextBase securityContext) {

    statusHistoryGroupedService.validate(statusHistoryGroupedRequest, securityContext);
    return statusHistoryGroupedService.listAllStatusHistoriesGrouped(statusHistoryGroupedRequest, securityContext);
  }

}
