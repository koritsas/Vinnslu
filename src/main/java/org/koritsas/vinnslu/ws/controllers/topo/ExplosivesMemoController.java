package org.koritsas.vinnslu.ws.controllers.topo;

import org.koritsas.vinnslu.models.topo.ExplosivesMemo;
import org.koritsas.vinnslu.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.ws.dto.topo.ExplosivesMemoDTO;
import org.koritsas.vinnslu.ws.services.topo.ExplosivesMemoService;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/explosives_memos")
public class ExplosivesMemoController extends AbstractCRUDController<ExplosivesMemoService, ExplosivesMemo,Long, ExplosivesMemoDTO> {
    public ExplosivesMemoController(ExplosivesMemoService service) {
        super(service);
    }
}
