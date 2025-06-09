package com.microservices.organizationservice.service.impl;

import com.microservices.organizationservice.dto.OrganizationDTO;
import com.microservices.organizationservice.entity.Organization;
import com.microservices.organizationservice.mapper.OrganizationMapper;
import com.microservices.organizationservice.repository.OrganizationRepository;
import com.microservices.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;
    @Override
    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {

        Organization organization = organizationMapper.mapToOrganization(organizationDTO);
        Organization savedOrganization = organizationRepository.save(organization);
        return organizationMapper.mapToOrganizationDTO(savedOrganization);
    }

    @Override
    public OrganizationDTO getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByCode(organizationCode);
        return organizationMapper.mapToOrganizationDTO(organization);
    }
}
