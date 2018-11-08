package org.koritsas.vinnslu.main.ws.services.topo;

import org.koritsas.vinnslu.main.models.topo.MiningLicense;
import org.koritsas.vinnslu.main.repos.topo.MiningLicenseRepository;
import org.koritsas.vinnslu.main.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class MiningLicenseService extends AbstractCRUDService<MiningLicenseRepository, MiningLicense,Long> {
    public MiningLicenseService(MiningLicenseRepository repo) {
        super(repo);
    }
}
