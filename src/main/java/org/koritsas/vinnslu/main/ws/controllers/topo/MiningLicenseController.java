package org.koritsas.vinnslu.main.ws.controllers.topo;

import org.koritsas.vinnslu.main.models.topo.MiningLicense;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.topo.MiningLicenseDTO;
import org.koritsas.vinnslu.main.ws.services.topo.MiningLicenseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mining_licenses")
public class MiningLicenseController extends AbstractCRUDController<MiningLicenseService, MiningLicense,Long, MiningLicenseDTO> {
    public MiningLicenseController(MiningLicenseService service) {
        super(service);
    }
}
