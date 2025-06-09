package com.microservices.organizationservice.controller;

import com.microservices.organizationservice.dto.OrganizationDTO;
import com.microservices.organizationservice.service.OrganizationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Organization Controller", description = "Organization Controller API")
@RestController
@RequestMapping("/v1/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @Operation(summary = "Save Organization", description = "Save Organization API")
    @ApiResponse(responseCode = "201", description = "Organization created successfully")
    @PostMapping
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO) {
        OrganizationDTO organizationDTO1 = organizationService.saveOrganization(organizationDTO);
        return new ResponseEntity<>(organizationDTO1, HttpStatus.CREATED);
    }

    @Operation(summary = "Get Organization by Code", description = "Get Organization by Code API")
    @ApiResponse(responseCode = "200", description = "Organization fetched successfully")
    @GetMapping("{organizationCode}")
    public ResponseEntity<OrganizationDTO> getOrganizationByCode(@PathVariable String organizationCode) {
        return new ResponseEntity<>(organizationService.getOrganizationByCode(organizationCode), HttpStatus.OK);
    }
}
