package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.common.Person;
import org.koritsas.vinnslu.repos.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends AbstractCRUDService<PersonRepository, Person, Long> {
    public PersonService(PersonRepository repo) {
	super(repo);
    }
}
