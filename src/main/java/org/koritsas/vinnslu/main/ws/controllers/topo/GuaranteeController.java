package org.koritsas.vinnslu.main.ws.controllers.topo;

import org.koritsas.vinnslu.main.models.topo.Guarantee;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.GuaranteeDTO;
import org.koritsas.vinnslu.main.ws.services.topo.GuaranteeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guarantees")
public class GuaranteeController  extends AbstractCRUDController<GuaranteeService, Guarantee,Long, GuaranteeDTO> {
    public GuaranteeController(GuaranteeService service) {
        super(service);
    }
}
