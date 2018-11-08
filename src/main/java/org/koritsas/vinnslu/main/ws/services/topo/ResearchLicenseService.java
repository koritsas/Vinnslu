package org.koritsas.vinnslu.main.ws.services.topo;

import org.koritsas.vinnslu.main.models.topo.ResearchLicense;
import org.koritsas.vinnslu.main.repos.topo.ResearchLicenseRepository;
import org.koritsas.vinnslu.main.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class ResearchLicenseService extends AbstractCRUDService<ResearchLicenseRepository, ResearchLicense,Long> {
    public ResearchLicenseService(ResearchLicenseRepository repo) {
        super(repo);
    }
}
