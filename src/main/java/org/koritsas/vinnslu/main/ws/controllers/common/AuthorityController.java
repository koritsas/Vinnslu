package org.koritsas.vinnslu.main.ws.controllers.common;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.ws.controllers.AbstractCRUDController;
import org.koritsas.vinnslu.main.ws.dto.common.AuthorityDto;
import org.koritsas.vinnslu.main.ws.services.common.AuthorityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/authorities")
public class AuthorityController
    extends AbstractCRUDController<AuthorityService, Authority, Long, AuthorityDto> {
    public AuthorityController(AuthorityService service) {
	super(service);
    }
}
