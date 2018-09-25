package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.common.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findById(@Param("id") final int id);

    Person findByName(final String name);

    Person findByAfm(final Long afm);

    List<Person> findByAddress(final String address);

    List<Person> findByAddressLike(final String address);

    List<Person> findByAddressIsNull();

    Person findByNameAndSurname(final String name, final String surname);

    Person findByNameAndSurnameAndFathername(final String name, final String surname, final String fathername);

    Person findByPhone(final Long phone);

    List<Person> findBySurnameStartingWith(final String name);

    List<Person> findByNameStartingWith(final String name);

    List<Person> findBySurnameLike(final String surname);

    List<Person> findByBirthDate(final Date date);
}
