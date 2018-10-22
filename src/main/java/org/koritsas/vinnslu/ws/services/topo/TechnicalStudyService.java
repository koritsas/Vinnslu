package org.koritsas.vinnslu.ws.services.topo;

import org.koritsas.vinnslu.models.topo.TechnicalStudy;
import org.koritsas.vinnslu.repos.topo.TechnicalStudyRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class TechnicalStudyService extends AbstractCRUDService<TechnicalStudyRepository, TechnicalStudy,Long> {
    public TechnicalStudyService(TechnicalStudyRepository repo) {
        super(repo);
    }
}
