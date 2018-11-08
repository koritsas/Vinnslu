package org.koritsas.vinnslu.main.ws.controllers.topo;

import org.koritsas.vinnslu.main.models.topo.ResearchLicense;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.ResearchLicenseDTO;
import org.koritsas.vinnslu.main.ws.services.topo.ResearchLicenseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/research_licenses")
public class ResearchLicenseController extends AbstractCRUDController<ResearchLicenseService, ResearchLicense, Long, ResearchLicenseDTO> {
    public ResearchLicenseController(ResearchLicenseService service) {
        super(service);
    }
}
