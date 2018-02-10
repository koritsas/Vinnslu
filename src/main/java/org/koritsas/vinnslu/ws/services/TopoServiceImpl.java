package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.repos.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

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
    @Transactional
    public Topo deleteTopo(long id) {
	return null;
    }

    @Override
    public List<Topo> getAllTopos() {
	return null;
    }

    @Override
    public Topo findTopoById(long id) {
	return null;
    }

    @Override
    public Topo updateTopo(Topo topo) {
	return null;
    }
}
