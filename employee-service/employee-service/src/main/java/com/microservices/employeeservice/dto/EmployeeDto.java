package com.microservices.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Employee DTO model information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    @Schema(description = "Employee ID")
    private Long id;
    @Schema(description = "Employee First Name")
    private String firstName;
    @Schema(description = "Employee Last Name")
    private String lastName;
    @Schema(description = "Employee Email")
    private String email;
    @Schema(description = "Employee Department Code")
    private String departmentCode;
    @Schema(description = "Employee Organization Code")
    private String organizationCode;

}
