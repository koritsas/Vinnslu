package org.koritsas.vinnslu.ws.services.common;

import org.koritsas.vinnslu.models.common.Person;
import org.koritsas.vinnslu.repos.common.PersonRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends AbstractCRUDService<PersonRepository, Person, Long> {
    public PersonService(PersonRepository repo) {
	super(repo);
    }
}
