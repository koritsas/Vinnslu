package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Company;
import org.koritsas.vinnslu.repos.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends AbstractCRUDService<CompanyRepository, Company, Long> {

    public CompanyService(CompanyRepository repo) {
        super(repo);
    }
}
