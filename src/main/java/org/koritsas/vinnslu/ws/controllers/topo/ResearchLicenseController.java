package org.koritsas.vinnslu.ws.controllers.topo;

import org.koritsas.vinnslu.models.topo.ResearchLicense;
import org.koritsas.vinnslu.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.ws.dto.topo.ResearchLicenseDTO;
import org.koritsas.vinnslu.ws.services.topo.ResearchLicenseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/research_licenses")
public class ResearchLicenseController extends AbstractCRUDController<ResearchLicenseService, ResearchLicense, Long, ResearchLicenseDTO> {
    public ResearchLicenseController(ResearchLicenseService service) {
        super(service);
    }
}
