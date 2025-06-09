package com.microservices.organizationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Organization DTO model information")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {

    @Schema(description = "Organization ID")
    private Long id;
    @Schema(description = "Organization Name")
    private String name;
    @Schema(description = "Organization Description")
    private String description;
    @Schema(description = "Organization Code")
    private String code;
    @Schema(description = "Organization Created Date")
    private LocalDateTime created;

}
