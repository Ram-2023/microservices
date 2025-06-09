package com.microservices.organizationservice.mapper;

import com.microservices.organizationservice.dto.OrganizationDTO;
import com.microservices.organizationservice.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationDTO mapToOrganizationDTO(Organization organization);

    Organization mapToOrganization(OrganizationDTO organizationDTO);
}
