package org.koritsas.vinnslu.ws.services.topo;

import org.koritsas.vinnslu.models.topo.ResearchLicense;
import org.koritsas.vinnslu.repos.topo.ResearchLicenseRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class ResearchLicenseService extends AbstractCRUDService<ResearchLicenseRepository, ResearchLicense,Long> {
    public ResearchLicenseService(ResearchLicenseRepository repo) {
        super(repo);
    }
}
