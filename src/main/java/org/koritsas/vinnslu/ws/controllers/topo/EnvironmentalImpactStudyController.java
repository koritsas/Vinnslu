package org.koritsas.vinnslu.ws.controllers.topo;

import org.koritsas.vinnslu.models.topo.EnvironmentalImpactStudy;
import org.koritsas.vinnslu.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.ws.dto.topo.EnvironmentalImpactStudyDTO;
import org.koritsas.vinnslu.ws.services.topo.EnvironmentalImpactStudyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/environmental_impact_studies")
public class EnvironmentalImpactStudyController extends AbstractCRUDController<EnvironmentalImpactStudyService, EnvironmentalImpactStudy,Long, EnvironmentalImpactStudyDTO> {
    public EnvironmentalImpactStudyController(EnvironmentalImpactStudyService service) {
        super(service);
    }
}
