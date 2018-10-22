package org.koritsas.vinnslu.ws.controllers.topo;


import org.koritsas.vinnslu.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.ws.dto.topo.StandardEnvironmentalCommitmentsDTO;
import org.koritsas.vinnslu.ws.services.topo.StandardEnvironmentalCommitmentsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/standard_technical_commitments")
public class StandardTechnicalCommitmentsController extends AbstractCRUDController<StandardEnvironmentalCommitmentsService, StandardEnvironmentalCommitments, Long, StandardEnvironmentalCommitmentsDTO> {
    public StandardTechnicalCommitmentsController(StandardEnvironmentalCommitmentsService service) {
        super(service);
    }
}
