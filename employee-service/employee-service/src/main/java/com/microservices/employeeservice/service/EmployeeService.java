package com.microservices.employeeservice.service;

import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.microservices.employeeservice.dto.APIResponseDTO;
import com.microservices.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDTO getEmployeeById(Long id);
}
