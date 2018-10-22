package org.koritsas.vinnslu.ws.services.topo;

import org.koritsas.vinnslu.models.topo.Topo;
import org.koritsas.vinnslu.repos.topo.TopoRepository;
import org.koritsas.vinnslu.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class TopoService extends AbstractCRUDService<TopoRepository, Topo, Long> {
    public TopoService(TopoRepository repo) {
	super(repo);
    }
}
