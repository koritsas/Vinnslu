package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.EnvironmentalTerms;
import org.koritsas.vinnslu.repos.EnvironmentalTermsRepository;

public class EnvironmentalTermsService
    extends AbstractCRUDService<EnvironmentalTermsRepository, EnvironmentalTerms, Long> {
    public EnvironmentalTermsService(EnvironmentalTermsRepository repo) {
	super(repo);
    }
}
