package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.MiningLicense;
import org.koritsas.vinnslu.repos.MiningLicenseRepository;

public class MiningLicenseService extends AbstractCRUDService<MiningLicenseRepository, MiningLicense, Long> {
    public MiningLicenseService(MiningLicenseRepository repo) {
	super(repo);
    }
}
