package org.koritsas.vinnslu.repos;

import com.vividsolutions.jts.geom.Point;
import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.models.topo.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopoRepository extends JpaRepository<Topo,Long>{

    //Spatial Queries

    @Query(value = "SELECT p FROM #{#entityName} p WHERE intersection(p.polygon,(:point)) = true")
    Topo findByPolygonContains(@Param("point") Point point);




}
