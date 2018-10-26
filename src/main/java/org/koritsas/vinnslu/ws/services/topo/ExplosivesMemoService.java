package org.koritsas.vinnslu.ws.services.topo;

import org.koritsas.vinnslu.models.topo.ExplosivesMemo;
import org.koritsas.vinnslu.repos.topo.ExplosivesMemoRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class ExplosivesMemoService extends AbstractCRUDService<ExplosivesMemoRepository, ExplosivesMemo,Long> {
    public ExplosivesMemoService(ExplosivesMemoRepository repo) {
        super(repo);
    }
}
