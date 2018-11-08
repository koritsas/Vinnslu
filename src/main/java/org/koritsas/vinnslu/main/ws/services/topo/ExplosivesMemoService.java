package org.koritsas.vinnslu.main.ws.services.topo;

import org.koritsas.vinnslu.main.models.topo.ExplosivesMemo;
import org.koritsas.vinnslu.main.repos.topo.ExplosivesMemoRepository;
import org.koritsas.vinnslu.main.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class ExplosivesMemoService extends AbstractCRUDService<ExplosivesMemoRepository, ExplosivesMemo,Long> {
    public ExplosivesMemoService(ExplosivesMemoRepository repo) {
        super(repo);
    }
}
