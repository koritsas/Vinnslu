package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.models.exceptions.EntityAlreadyExistsException;
import org.koritsas.vinnslu.models.exceptions.EntityNotFoundException;
import org.koritsas.vinnslu.repos.TopoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopoService.class.getName());


    private TopoRepository repository;

    @Autowired
    public TopoService(TopoRepository repository){this.repository=repository;}


    @Transactional(rollbackFor = EntityAlreadyExistsException.class)
    public Topo createTopo(Topo topo) {
        return repository.save(topo);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class)
    public Topo deleteTopo(long topoId){

        Topo existing = repository.findOne(topoId);

        if (existing == null){
            throw new EntityNotFoundException("Topo with id: "+ topoId + " not found. Nothing has changed...But has ever?");
	}

	repository.delete(topoId);

        return existing;
    }

    @Transactional(readOnly = true)
    public List<Topo> getAllTopos() {
	return repository.findAll();
    }

    @Transactional
    public Topo findByAbl(int abl){return repository.findByAbl(abl);}

    @Transactional
    public Topo findById(long id) {
	return repository.findOne(id);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public Topo updateUser(Topo topo) {
	Topo existing = repository.findOne(topo.getId());
	if (existing == null) {
	    throw new EntityNotFoundException("Topo with id: " + topo.getId() + " not found. Cannot update.");
	}
	topo.setPolygon(existing.getPolygon());
	topo.setAbl(existing.getAbl());
	topo.setOwner(existing.getOwner());
	topo.setTopoOwner(existing.getTopoOwner());
	topo.setCommunity(existing.getCommunity());
	topo.setLocation(existing.getLocation());
	topo.setPrefecture(existing.getPrefecture());
	topo.setForest(existing.getForest());

	repository.save(topo);
	return existing;
    }
}
