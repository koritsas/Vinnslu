package org.koritsas.vinnslu.main.ws.services.common;

import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.repos.common.CompanyRepository;
import org.koritsas.vinnslu.main.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends AbstractCRUDService<CompanyRepository, Company, Long> {

    public CompanyService(CompanyRepository repo) {
        super(repo);
    }
}
