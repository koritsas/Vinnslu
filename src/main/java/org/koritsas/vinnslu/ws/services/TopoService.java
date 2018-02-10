package org.koritsas.vinnslu.ws.services;

import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.repos.TopoRepository;
import org.koritsas.vinnslu.ws.dto.TopoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TopoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopoService.class.getName());

    private TopoRepository repository;

    @Autowired
    public TopoService(TopoRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Void> createTopo(TopoDto dto) {
	LOGGER.debug("Got this request body: " + dto.toString());
	Topo topo = new Topo();
	topo.setAbl(dto.getAbl());
	topo.setCommunity(dto.getCommunity());
	topo.setLocation(dto.getLocation());
	topo.setPrefecture(dto.getPrefecture());
	repository.save(topo);
        return ResponseEntity.noContent().build();
    }

}
