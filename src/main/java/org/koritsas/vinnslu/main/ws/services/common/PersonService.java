package org.koritsas.vinnslu.main.ws.services.common;

import org.koritsas.vinnslu.main.models.common.Person;
import org.koritsas.vinnslu.main.repos.common.PersonRepository;
import org.koritsas.vinnslu.main.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends AbstractCRUDService<PersonRepository, Person, Long> {
    public PersonService(PersonRepository repo) {
	super(repo);
    }
}
