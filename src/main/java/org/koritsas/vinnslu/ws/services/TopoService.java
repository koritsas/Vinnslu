package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.repos.TopoRepository;
import org.springframework.stereotype.Service;

@Service
public class TopoService extends AbstractCRUDService<TopoRepository, Topo, Long> {
    public TopoService(TopoRepository repo) {
	super(repo);
    }
}
