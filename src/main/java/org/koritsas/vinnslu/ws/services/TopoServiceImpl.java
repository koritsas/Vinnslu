package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.models.exceptions.EntityNotFoundException;
import org.koritsas.vinnslu.repos.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TopoServiceImpl implements TopoService{

    @Autowired
    TopoRepository topoRepository;

    @Override
    @Transactional
    public Topo createTopo(Topo topo) {
	return topoRepository.save(topo);
    }

    @Override
    @Transactional(rollbackFor = EntityNotFoundException.class)
    public Topo deleteTopo(long id) {
        Topo existing = topoRepository.findOne(id);
        if (existing == null){
            throw new EntityNotFoundException("Topo with id: " + id +" not found. Cannot delete");
	}
        topoRepository.delete(id);
	return existing;
    }

    @Override
    @Transactional
    public List<Topo> getAllTopos() {
	return topoRepository.findAll();
    }

    @Override
    @Transactional
    public Topo findTopoById(long id) {
	return topoRepository.findOne(id);
    }

    @Override
    @Transactional
    public Topo updateTopo(Topo topo) {
        Topo existing = topoRepository.findOne(topo.getId());
        if( existing == null){
            throw new EntityNotFoundException("Topo with id: " + topo.getId() + " not found. Cannot be updated");
	}
        topo.set
	return;
    }
}
