package org.koritsas.vinnslu.main.ws.services.topo;

import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.main.repos.topo.StandardTechnicalCommitmentsRepository;
import org.koritsas.vinnslu.main.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class StandardTechnicalCommitmentsService extends AbstractCRUDService<StandardTechnicalCommitmentsRepository, StandardTechnicalCommitments,Long> {
    public StandardTechnicalCommitmentsService(StandardTechnicalCommitmentsRepository repo) {
        super(repo);
    }
}
