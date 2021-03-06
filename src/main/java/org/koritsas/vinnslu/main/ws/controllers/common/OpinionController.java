package org.koritsas.vinnslu.main.ws.controllers.common;

import org.koritsas.vinnslu.main.models.common.Opinion;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.common.OpinionDTO;
import org.koritsas.vinnslu.main.ws.services.common.OpinionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/opinions")
@CrossOrigin(origins = "http://localhost:4200")
public class OpinionController extends AbstractCRUDController<OpinionService, Opinion,Long, OpinionDTO> {
    public OpinionController(OpinionService service) {
        super(service);
    }
}
