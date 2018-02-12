package org.koritsas.vinnslu.ws.services;

import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.repos.TopoRepository;
import org.koritsas.vinnslu.utils.PolygonParser;
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
    public TopoService(TopoRepository repository){this.repository=repository;}

    public ResponseEntity<Void> createTopo(TopoDto dto) {
	LOGGER.debug("Got this request body: " + dto.toString());
	Topo topo = new Topo();

	//Reading polygon string
	/*WKTReader reader = new WKTReader();

	Polygon polygon = null;

	try {
	    polygon = (Polygon) reader.read(dto.getPolygon());
	} catch (ParseException e) {
	    e.printStackTrace();
	}
*/
	Polygon polygon = PolygonParser.parse(dto.getPolygon());


	topo.setPolygon(polygon);
	topo.setAbl(dto.getAbl());
	topo.setCommunity(dto.getCommunity());
	topo.setLocation(dto.getLocation());
	topo.setPrefecture(dto.getPrefecture());
	topo.setOwner(dto.getOwner());
	topo.setTopoOwner(dto.getTopoOwner());



	repository.save(topo);
        return ResponseEntity.noContent().build();
    }

}
