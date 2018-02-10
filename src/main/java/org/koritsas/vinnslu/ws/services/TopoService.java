package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Topo;

import java.util.List;

public interface TopoService {
    Topo createTopo(final Topo topo);
    Topo deleteTopo(final long id);
    List<Topo> getAllTopos();
    Topo findTopoById(final long id);
    Topo updateTopo(final Topo topo);
}
