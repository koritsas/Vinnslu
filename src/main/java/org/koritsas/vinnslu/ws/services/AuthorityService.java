package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Authority;
import org.koritsas.vinnslu.repos.AuthorityRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService extends AbstractService<Authority, AuthorityRepository> {
    public AuthorityService(AuthorityRepository repo) {
	super(repo);
    }
}
