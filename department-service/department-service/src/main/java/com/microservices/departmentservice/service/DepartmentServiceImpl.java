package com.microservices.departmentservice.service;

import com.microservices.departmentservice.dto.DepartmentDTO;
import com.microservices.departmentservice.entity.Department;
import com.microservices.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    /**
     * saving the department object into the database
     */
    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        //convert the departmentDTO into department jpa entity
        Department department = new Department(departmentDTO.getId(),departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription(),departmentDTO.getDepartmentCode());

        //save the department jpa entity using repository save method
        departmentRepository.save(department);

        //convert the department jpa entity into departmentDTO
        return new DepartmentDTO(department.getId(),department.getDepartmentName()
        ,department.getDepartmentDescription(),department.getDepartmentCode());
    }

    /**
     * GET department object by departmentCode
     * @param code
     * @return departmentDTO
     */
    @Override
    public DepartmentDTO getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);

        return new DepartmentDTO(department.getId()
        ,department.getDepartmentName(),department.getDepartmentDescription(),department.getDepartmentCode());
    }
}
