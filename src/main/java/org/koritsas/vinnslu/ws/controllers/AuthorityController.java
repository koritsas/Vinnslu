package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.models.common.Authority;
import org.koritsas.vinnslu.ws.dto.AuthorityDto;
import org.koritsas.vinnslu.ws.services.AuthorityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authority")
public class AuthorityController
    extends AbstractCRUDController<AuthorityService, Authority, Long, AuthorityDto> {
    public AuthorityController(AuthorityService service) {
	super(service);
    }
}
