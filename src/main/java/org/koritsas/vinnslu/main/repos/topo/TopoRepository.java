package org.koritsas.vinnslu.main.repos.topo;

import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopoRepository extends JpaRepository<Topo,Long>{



    Topo findByAbl(Long abl);
    Topo findByArea(double area);

    List<Topo> findByLocation(String location);

    List<Topo> findByCommunity(String community);

    List<Topo> findByPrefecture(String prefecture);

    List<Topo> findByAreaOwner(Company areaOwner);

    List<Topo> findByTopoOwner(Company topoOwner);

    List<Topo> findByForest(boolean isForest);



    List<Topo> findByAreaGreaterThan(double area);

    List<Topo> findByAreaLessThan(double area);

    List<Topo> findByAreaGreaterThanEqual(double area);

    List<Topo> findByAreaLessThanEqual(double area);


    //Spatial Queries

    @Query(value = "SELECT p FROM #{#entityName} p WHERE intersection((:polygonA),(:polygonB)) = true")
    Topo findByPolygonContains(@Param("polygonA") Polygon polygonA, @Param("polygonB") Polygon B);

    @Query(value = "SELECT p FROM #{#entityName} p WHERE touches((:polygon),(:point)) = true")
    Topo findByPointTouches(@Param("polygon") Polygon polygon, @Param("point") Point point);

    @Query(value = "SELECT p FROM #{#entityName} p WHERE within((:point),(:polygon)) = true")
    Topo findByPointWithinPolygon(@Param("polygon") Polygon polygon, @Param("point") Point point);
}
