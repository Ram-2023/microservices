package com.microservices.organizationservice.service;

import com.microservices.organizationservice.dto.OrganizationDTO;

public interface OrganizationService {

    OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);

    OrganizationDTO getOrganizationByCode(String organizationCode);
}
