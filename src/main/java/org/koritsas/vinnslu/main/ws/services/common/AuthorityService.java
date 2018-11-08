package org.koritsas.vinnslu.main.ws.services.common;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.repos.common.AuthorityRepository;
import org.koritsas.vinnslu.main.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService extends AbstractCRUDService<AuthorityRepository, Authority, Long> {

    public AuthorityService(AuthorityRepository repository) {
	super(repository);
    }
}
