package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.exceptions.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public class AbstractService<E, R extends JpaRepository> {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private R repo;

    @Autowired
    public AbstractService(R repo) {this.repo = repo;}

    @Transactional
    public E find(long id) {
	return (E) repo.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<E> findAll() {
	return repo.findAll();
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public E create(E entity) {

	LOGGER.info("Creating entity: " + entity.toString());

	return (E) repo.save(entity);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public void delete(long id) {

	if (!repo.exists(id)) {
	    throw new EntityNotFoundException("Entity with id: " + id + " not found");
	}

	repo.delete(id);

    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public E update(E entity) {

	if (!repo.exists((Serializable) entity)) {

	    throw new EntityNotFoundException("Entity does not exist, therefore, cannot be updated");
	}

	E newe = entity;

	return (E) repo.save(entity);
    }

}