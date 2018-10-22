package org.koritsas.vinnslu.ws.services.topo;

import org.koritsas.vinnslu.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.repos.topo.StandardTechnicalCommitmentsRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class StandardTechnicalCommitmentsService extends AbstractCRUDService<StandardTechnicalCommitmentsRepository, StandardTechnicalCommitments,Long> {
    public StandardTechnicalCommitmentsService(StandardTechnicalCommitmentsRepository repo) {
        super(repo);
    }
}
