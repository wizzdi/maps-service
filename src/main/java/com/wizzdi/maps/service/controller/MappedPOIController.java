package com.wizzdi.maps.service.controller;

import com.flexicore.annotations.OperationsInside;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.flexicore.security.validation.Create;
import com.wizzdi.flexicore.security.validation.Update;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.service.request.MappedPOICreate;
import com.wizzdi.maps.service.request.MappedPOIFilter;
import com.wizzdi.maps.service.request.MappedPOIUpdate;
import com.wizzdi.maps.service.service.MappedPOIService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("MappedPOI")
@Tag(name = "MappedPOI")
@OperationsInside
@Extension
public class MappedPOIController implements Plugin {

  @Autowired private MappedPOIService mappedPOIService;

  @PutMapping("updateMappedPOI")
  @Operation(summary = "updateMappedPOI", description = "Updates MappedPOI")
  public MappedPOI updateMappedPOI(
      @Validated(Update.class) @RequestBody MappedPOIUpdate mappedPOIUpdate,
      @RequestAttribute SecurityContextBase securityContext) {

    return mappedPOIService.updateMappedPOI(mappedPOIUpdate, securityContext);
  }

  @PostMapping("getAllMappedPOIs")
  @Operation(summary = "getAllMappedPOIs", description = "lists MappedPOIs")
  public PaginationResponse<MappedPOI> getAllMappedPOIs(
      @Valid @RequestBody MappedPOIFilter mappedPOIFilter,
      @RequestAttribute SecurityContextBase securityContext) {

    return mappedPOIService.getAllMappedPOIs(mappedPOIFilter, securityContext);
  }

  @PostMapping("createMappedPOI")
  @Operation(summary = "createMappedPOI", description = "Creates MappedPOI")
  public MappedPOI createMappedPOI(
      @Validated(Create.class) @RequestBody MappedPOICreate mappedPOICreate,
      @RequestAttribute SecurityContextBase securityContext) {

    return mappedPOIService.createMappedPOI(mappedPOICreate, securityContext);
  }
}
