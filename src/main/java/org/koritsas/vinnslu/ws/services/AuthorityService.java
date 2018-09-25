package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.common.Authority;
import org.koritsas.vinnslu.repos.AuthorityRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService extends AbstractCRUDService<AuthorityRepository, Authority, Long> {

    public AuthorityService(AuthorityRepository repository) {
	super(repository);
    }
}
