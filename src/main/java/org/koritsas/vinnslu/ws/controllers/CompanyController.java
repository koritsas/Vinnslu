package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.ws.dto.CompanyDto;
import org.koritsas.vinnslu.ws.services.CompanyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController  extends AbstractCRUDController<CompanyService,Company,Long,CompanyDto>{


    public CompanyController(CompanyService service) {
        super(service);
    }
}
