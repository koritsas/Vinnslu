package org.koritsas.vinnslu.ws.services.topo;

import org.koritsas.vinnslu.models.topo.EnvironmentalImpactStudy;
import org.koritsas.vinnslu.repos.topo.EnvironmentalImpactStudyRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class EnvironmentalImpactStudyService extends AbstractCRUDService<EnvironmentalImpactStudyRepository, EnvironmentalImpactStudy,Long> {
    public EnvironmentalImpactStudyService(EnvironmentalImpactStudyRepository repo) {
        super(repo);
    }
}
