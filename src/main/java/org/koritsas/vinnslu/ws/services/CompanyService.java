package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Company;
import org.koritsas.vinnslu.models.exceptions.EntityAlreadyExistsException;
import org.koritsas.vinnslu.models.exceptions.EntityNotFoundException;
import org.koritsas.vinnslu.repos.CompanyRepository;
import org.koritsas.vinnslu.ws.dto.CompanyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyService.class.getName());

    private CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository){this.repository=repository;}

    @Transactional
    public Company findCompanyById(long id){
        return repository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<Company> getCompanies(){
        return repository.findAll();
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public Company deleteCompany(long id){
        Company existing = repository.findOne(id);

        if (existing == null){
            throw new EntityNotFoundException("Company with id: " + id +" not found.");
        }

        repository.delete(id);

        return existing;
    }

    @Transactional(rollbackFor = EntityAlreadyExistsException.class)
    public Company createCompany(Company company){
        return repository.save(company);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public Company updateCompany(Company company){
        Company existing = repository.findOne(company.getId());
        if (existing == null){
            throw new EntityNotFoundException("Company with id: " + company.getId() +" not found.");
        }

        existing.setAddress(company.getAddress());
        existing.setAfm(company.getAfm());
        existing.setName(company.getName());

        repository.save(existing);

        return existing;
    }
}
