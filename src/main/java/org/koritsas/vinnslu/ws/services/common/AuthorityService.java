package org.koritsas.vinnslu.ws.services.common;

import org.koritsas.vinnslu.models.common.Authority;
import org.koritsas.vinnslu.repos.common.AuthorityRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService extends AbstractCRUDService<AuthorityRepository, Authority, Long> {

    public AuthorityService(AuthorityRepository repository) {
	super(repository);
    }
}
