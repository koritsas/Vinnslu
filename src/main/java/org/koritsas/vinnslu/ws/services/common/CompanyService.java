package org.koritsas.vinnslu.ws.services.common;

import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.repos.common.CompanyRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends AbstractCRUDService<CompanyRepository, Company, Long> {

    public CompanyService(CompanyRepository repo) {
        super(repo);
    }
}
