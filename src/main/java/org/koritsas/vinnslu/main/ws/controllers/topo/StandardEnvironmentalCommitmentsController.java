package org.koritsas.vinnslu.main.ws.controllers.topo;

import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.StandardEnvironmentalCommitmentsDTO;
import org.koritsas.vinnslu.main.ws.services.topo.StandardEnvironmentalCommitmentsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/standard_environmental_commitments")
public class StandardEnvironmentalCommitmentsController extends AbstractCRUDController<StandardEnvironmentalCommitmentsService, StandardEnvironmentalCommitments, Long, StandardEnvironmentalCommitmentsDTO> {
    public StandardEnvironmentalCommitmentsController(StandardEnvironmentalCommitmentsService service) {
        super(service);
    }
}
