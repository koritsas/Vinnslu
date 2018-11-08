package org.koritsas.vinnslu.main.ws.services.topo;

import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.repos.topo.TopoRepository;
import org.koritsas.vinnslu.main.ws.services.AbstractCRUDService;
import org.springframework.stereotype.Service;

@Service
public class TopoService extends AbstractCRUDService<TopoRepository, Topo, Long> {
    public TopoService(TopoRepository repo) {
	super(repo);
    }
}
