package com.microservices.employeeservice.service.impl;

import com.microservices.employeeservice.dto.APIResponseDTO;
import com.microservices.employeeservice.dto.DepartmentDTO;
import com.microservices.employeeservice.dto.EmployeeDto;
import com.microservices.employeeservice.dto.OrganizationDTO;
import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.repository.EmployeeRepository;
import com.microservices.employeeservice.service.APIClient;
import com.microservices.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;

    private WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(employeeDto.getId(),employeeDto.getFirstName(),employeeDto.getLastName(),employeeDto.getEmail(),employeeDto.getDepartmentCode(),employeeDto.getOrganizationCode());
        Employee savedEmployee = employeeRepository.save(employee);
        return new EmployeeDto(savedEmployee.getId(),savedEmployee.getFirstName(),savedEmployee.getLastName(),savedEmployee.getEmail(),savedEmployee.getDepartmentCode(),savedEmployee.getOrganizationCode());
    }

//    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDTO getEmployeeById(Long id) {
        LOGGER.info("Retrieving employee by id: {}", id);
        Employee employee = employeeRepository.findById(id).get();
//        ResponseEntity<DepartmentDTO> response = restTemplate.getForEntity("http://localhost:8080/v1/departments/"+employee.getDepartmentCode(), DepartmentDTO.class);
        DepartmentDTO departmentDTO = webClient.get().uri("http://localhost:8080/v1/departments/"+employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDTO.class).block();
        OrganizationDTO organizationDTO = webClient.get().uri("http://localhost:8083/v1/organizations/"+employee.getOrganizationCode()).retrieve().bodyToMono(OrganizationDTO.class).block();
//        DepartmentDTO departmentDTO = response.getBody();
//        DepartmentDTO departmentDTO = apiClient.getDepartmentByCode(employee.getDepartmentCode());
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentCode(),employee.getOrganizationCode());

        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployee(employeeDto);
        apiResponseDTO.setDepartment(departmentDTO);
        apiResponseDTO.setOrganization(organizationDTO);
        return apiResponseDTO;
    }

    public APIResponseDTO getDefaultDepartment(Long id,Exception exception) {
        LOGGER.info("Retrieving getDefaultDepartment by id: {}", id);
        Employee employee = employeeRepository.findById(id).get();
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentCode("BE02");
        departmentDTO.setDepartmentName("Backened default department");
        departmentDTO.setDepartmentDescription("Default department");
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentCode(),employee.getOrganizationCode());

        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployee(employeeDto);
        apiResponseDTO.setDepartment(departmentDTO);
        return apiResponseDTO;
    }
}
