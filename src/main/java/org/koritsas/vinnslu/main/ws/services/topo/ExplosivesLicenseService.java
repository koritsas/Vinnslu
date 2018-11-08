package org.koritsas.vinnslu.main.ws.services.topo;

import org.koritsas.vinnslu.main.models.topo.ExplosivesLicense;
import org.koritsas.vinnslu.main.repos.topo.ExplosivesLicenseRepository;
import org.koritsas.vinnslu.main.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class ExplosivesLicenseService extends AbstractCRUDService<ExplosivesLicenseRepository, ExplosivesLicense, Long> {
    public ExplosivesLicenseService(ExplosivesLicenseRepository repo) {
        super(repo);
    }
}
