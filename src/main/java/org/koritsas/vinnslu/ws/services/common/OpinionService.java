package org.koritsas.vinnslu.ws.services.common;

import org.koritsas.vinnslu.models.common.Opinion;
import org.koritsas.vinnslu.repos.common.OpinionRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class OpinionService extends AbstractCRUDService<OpinionRepository, Opinion,Long> {
    public OpinionService(OpinionRepository repo) {
        super(repo);
    }
}
