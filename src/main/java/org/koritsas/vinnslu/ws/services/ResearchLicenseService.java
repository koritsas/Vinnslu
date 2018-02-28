package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.ResearchLicense;
import org.koritsas.vinnslu.repos.ResearchLicenseRepository;

public class ResearchLicenseService extends AbstractCRUDService<ResearchLicenseRepository, ResearchLicense, Long> {
    public ResearchLicenseService(ResearchLicenseRepository repo) {
	super(repo);
    }
}
