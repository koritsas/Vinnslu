package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Person;
import org.koritsas.vinnslu.repos.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends AbstractService<Person, PersonRepository> {
    public PersonService(PersonRepository repo) {
	super(repo);
    }
}
