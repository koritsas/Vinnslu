package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.exceptions.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractCRUDService<R extends JpaRepository, E extends Serializable, PK extends Serializable> {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    protected R repo;

    public AbstractCRUDService(R repo) {this.repo = repo;}

    @Transactional
    public E find(PK id) {
	return (E) repo.getOne(id);
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
    public E delete(PK id) {

	if (!repo.existsById(id)) {
	    throw new EntityNotFoundException("Entity with id: " + id + " not found");
	}

	E entity = (E) repo.getOne(id);

	repo.delete(id);

	return entity;

    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public E update(PK id, E entity) {

	if (!repo.existsById(id)) {
	    throw new EntityNotFoundException("Entity does not exist, therefore, cannot be updated");
	}

	return (E) repo.save(entity);
    }

}
