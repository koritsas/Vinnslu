package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Person;
import org.koritsas.vinnslu.models.exceptions.EntityAlreadyExistsException;
import org.koritsas.vinnslu.models.exceptions.EntityNotFoundException;
import org.koritsas.vinnslu.repos.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    PersonRepository repository;

    public PersonService(PersonRepository repository) {this.repository = repository;}

    @Transactional(readOnly = true)
    public List<Person> getPersons() {
	return repository.findAll(new Sort(Sort.Direction.ASC, "surname"));
    }

    @Transactional
    public Person findPerson(long id) {
	return repository.findOne(id);
    }

    @Transactional(rollbackFor = EntityAlreadyExistsException.class)
    public Person createPerson(Person person) {

	LOGGER.info("Creating Person: " + person.toString());

	return repository.save(person);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public Person deletePerson(long id) {
	Person existing = repository.findOne(id);

	if (existing == null) {
	    throw new EntityNotFoundException("Person with id: " + id + " does not exist");
	}

	LOGGER.info("Deleting Person: " + existing.toString());

	repository.delete(id);

	return existing;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public Person updatePerson(Person person) {
	Person existing = repository.findOne(person.getId());

	if (existing == null) {
	    throw new EntityNotFoundException("Person with id: " + person.getId() + " does not exist");
	}

	existing.setBirthDate(person.getBirthDate());
	existing.setFathername(person.getFathername());
	existing.setIdCardNumber(person.getIdCardNumber());
	existing.setMothername(person.getMothername());
	existing.setJob(person.getJob());
	existing.setPhone(person.getPhone());
	existing.setSurname(person.getSurname());
	existing.setAddress(person.getAddress());
	existing.setName(person.getName());
	existing.setAfm(person.getAfm());

	repository.save(existing);

	return existing;
    }
}
