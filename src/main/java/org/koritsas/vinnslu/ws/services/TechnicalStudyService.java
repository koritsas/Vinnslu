package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.TechinalStudy;
import org.koritsas.vinnslu.repos.TechnicalStudyRepository;

public class TechnicalStudyService extends AbstractCRUDService<TechnicalStudyRepository, TechinalStudy, Long> {

    public TechnicalStudyService(TechnicalStudyRepository repo) {
	super(repo);
    }
}
