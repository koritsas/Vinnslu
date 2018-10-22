package org.koritsas.vinnslu.ws.services.topo;

import org.koritsas.vinnslu.models.topo.MiningLicense;
import org.koritsas.vinnslu.repos.topo.MiningLicenseRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class MiningLicenseService extends AbstractCRUDService<MiningLicenseRepository, MiningLicense,Long> {
    public MiningLicenseService(MiningLicenseRepository repo) {
        super(repo);
    }
}
