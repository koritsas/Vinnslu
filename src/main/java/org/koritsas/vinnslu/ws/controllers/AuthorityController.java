package org.koritsas.vinnslu.ws.controllers;

import org.koritsas.vinnslu.ws.services.AuthorityService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorityController extends AbstractController<AuthorityService> {
    public AuthorityController(AuthorityService service) {
	super(service);
    }
}
