package org.koritsas.vinnslu.repos;

import com.vividsolutions.jts.geom.Geometry;
import org.koritsas.vinnslu.models.Company;
import org.koritsas.vinnslu.models.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query(value = "SELECT p FROM Topo p WHERE p.the_geom.contains(:point)=true")
    Topo findByPolygonContaining(final Geometry point);

    @Query("SELECT p FROM #{#entityName} p WHERE p.the_geom.getArea()>:area")
    List<Topo> findByPolygonGreaterThan(final double area);

    @Query("SELECT p FROM #{#entityName} p WHERE p.the_geom.getArea()<:area")
    List<Topo> findByAreaSmallerThan(final double area);

    @Query("SELECT p FROM #{#entityName} p WHERE p.the_geom.getArea()>=:area")
    List<Topo> findByAreaLargerOrEqualThan(final double area);

    @Query("SELECT p FROM #{#entityName} p WHERE p.the_geom.getArea()<=:area")
    List<Topo> findByAreaSmallerOrEqualThan(final double area);

    @Query("SELECT p FROM #{#entityName} p WHERE p.the_geom.intersects(:geometry) = true")
    List<Topo> findByIntersection(Geometry geometry);
}
