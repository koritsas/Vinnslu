package org.koritsas.vinnslu.ws.services.topo;

import org.koritsas.vinnslu.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.repos.topo.StandardEnvironmentalCommitmentsRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class StandardEnvironmentalCommitmentsService extends AbstractCRUDService<StandardEnvironmentalCommitmentsRepository, StandardTechnicalCommitments,Long> {
    public StandardEnvironmentalCommitmentsService(StandardEnvironmentalCommitmentsRepository repo) {
        super(repo);
    }
}
