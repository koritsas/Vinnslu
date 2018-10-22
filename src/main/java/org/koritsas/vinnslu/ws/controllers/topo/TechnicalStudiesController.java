package org.koritsas.vinnslu.ws.controllers.topo;

import org.koritsas.vinnslu.models.topo.TechnicalStudy;
import org.koritsas.vinnslu.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.ws.dto.topo.TechnicalStudyDTO;
import org.koritsas.vinnslu.ws.services.topo.TechnicalStudyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/technical_studies")
public class TechnicalStudiesController extends AbstractCRUDController<TechnicalStudyService, TechnicalStudy,Long, TechnicalStudyDTO> {
    public TechnicalStudiesController(TechnicalStudyService service) {
        super(service);
    }
}
