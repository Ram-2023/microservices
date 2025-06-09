package com.microservices.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDTO {

    private EmployeeDto employee;
    private DepartmentDTO department;
    private OrganizationDTO organization;
}
