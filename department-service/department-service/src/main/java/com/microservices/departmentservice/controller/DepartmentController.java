package com.microservices.departmentservice.controller;

import com.microservices.departmentservice.dto.DepartmentDTO;
import com.microservices.departmentservice.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Department Controller", description = "Department Controller API")
@RestController
@RequestMapping("/v1/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    /**
     * Save the department object
     * 
     * @Params DepartmentDTO
     *         using .saveDepartment method from departmentService class
     */

    @Operation(summary = "Save Department", description = "Save Department API")
    @ApiResponse(responseCode = "201", description = "Department created successfully")
    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDTO), HttpStatus.CREATED);
    }

    /**
     * get department object by department code
     * 
     * @param code
     * @return departmentDTO
     */
    @Operation(summary = "Get Department by Code", description = "Get Department by Code API")
    @ApiResponse(responseCode = "200", description = "Department fetched successfully")
    @GetMapping("{code}")
    public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(departmentService.getDepartmentByCode(code), HttpStatus.OK);
    }
}
