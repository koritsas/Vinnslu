package org.koritsas.vinnslu.main.ws.services.topo;

import org.koritsas.vinnslu.main.models.topo.TechnicalStudy;
import org.koritsas.vinnslu.main.repos.topo.TechnicalStudyRepository;
import org.koritsas.vinnslu.main.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class TechnicalStudyService extends AbstractCRUDService<TechnicalStudyRepository, TechnicalStudy,Long> {
    public TechnicalStudyService(TechnicalStudyRepository repo) {
        super(repo);
    }
}
