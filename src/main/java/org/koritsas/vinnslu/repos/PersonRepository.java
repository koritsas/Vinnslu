package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.Person;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonRepository extends CompanyRepository{

	Person findByNameAndSurname(final String name,final String surname);
	Person findByNameAndSurnameAndFathername(final String name,final String surname,final String fathername);
	Person findByPhone(final Long phone);
	List<Person> findBySurnameStartingWith(final String name);
    	List<Person> findByNameStartingWith(final String name);
    	List<Person> findBySurnameLike(final String surname);
    	List<Person> findByBirthDate(final Date date);
}
