package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Company;
import org.koritsas.vinnslu.repos.CompanyRepository;
import org.koritsas.vinnslu.ws.dto.CompanyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyService.class.getName());

    private CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository){this.repository=repository;}

    public ResponseEntity<Void> createCompany(CompanyDto dto){
	LOGGER.debug("Got this request body: " + dto.toString());

	Company company = new Company(dto.getAfm(),dto.getName(),dto.getAddress());

	repository.save(company);

	return ResponseEntity.noContent().build();
    }
}
