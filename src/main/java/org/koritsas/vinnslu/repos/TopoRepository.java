package org.koritsas.vinnslu.repos;

import com.vividsolutions.jts.geom.Point;
import org.koritsas.vinnslu.models.Company;
import org.koritsas.vinnslu.models.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopoRepository extends JpaRepository<Topo,Long>{


    Topo findByAbl(final int abl);
    List<Topo> findByForest(final boolean forest);
    List<Topo> findByCommunity(final String community);
    List<Topo> findByLocation(final String location);
    List<Topo> findByPrefecture(final String prefecture);
    List<Topo> findByTopoOwner(final Company topoOwner);


    //Spatial Queries

    @Query(value = "SELECT p FROM #{#entityName} p WHERE intersection(p.polygon,(:point)) = true")
    Topo findByPolygonContains(@Param("point") Point point);





}
