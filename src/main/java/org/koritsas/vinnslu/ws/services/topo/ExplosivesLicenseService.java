package org.koritsas.vinnslu.ws.services.topo;

import org.koritsas.vinnslu.models.topo.ExplosivesLicense;
import org.koritsas.vinnslu.repos.topo.ExplosivesLicenseRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class ExplosivesLicenseService extends AbstractCRUDService<ExplosivesLicenseRepository, ExplosivesLicense, Long> {
    public ExplosivesLicenseService(ExplosivesLicenseRepository repo) {
        super(repo);
    }
}
