package org.koritsas.vinnslu.ws.controllers.common;

import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.ws.dto.common.CompanyDto;
import org.koritsas.vinnslu.ws.services.common.CompanyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/common/companies")
public class CompanyController  extends AbstractCRUDController<CompanyService,Company,Long,CompanyDto> {
    public CompanyController(CompanyService service) {
        super(service);
    }
}
