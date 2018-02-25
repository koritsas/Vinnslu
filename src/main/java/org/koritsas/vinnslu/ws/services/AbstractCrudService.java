package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.exceptions.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class AbstractCrudService<R extends JpaRepository, E, PK extends Serializable> {

    protected R repository;

    public AbstractCrudService(R repository) {
	this.repository = repository;
    }

    public E get(PK id) {
        return (E) repository.findOne(id);
    }

    public List<E> getAll() {
        return repository.findAll();
    }

    public E create(E entity) {
        return (E) repository.save(entity);
    }

    public E delete(PK id) {
        entityExists(id);
	E toDelete = (E) repository.findOne(id);
	repository.delete(toDelete);
	return toDelete;
    }

    public E update(PK id) {
        E toUpdate = (E) repository.findOne(id);
        entityExists(id);
        return (E) repository.save(toUpdate);
    }

    private void entityExists(PK id) {
        if (!repository.exists(id)) {
	    throw new EntityNotFoundException("Entity of type: "
		+ repository.getClass()
		+ " with id: " + id + " not found");
	}
    }

}
