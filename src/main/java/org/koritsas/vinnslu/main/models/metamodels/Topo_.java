package org.koritsas.vinnslu.main.models.metamodels;

import com.vividsolutions.jts.geom.Polygon;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.topo.Topo;

import javax.persistence.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.validation.constraints.Max;

@StaticMetamodel(Topo.class)
public class Topo_ {

    public static volatile SingularAttribute<Topo,Long> id;

    public static volatile SingularAttribute<Topo,Long> abl;


   public static volatile SingularAttribute<Topo,Double> area;


    public static volatile SingularAttribute<Topo,Polygon> polygon;

    public static volatile SingularAttribute<Topo,String> municipality;

    public static volatile SingularAttribute<Topo,String> community;

    public static volatile SingularAttribute<Topo,String> location;


    public static volatile SingularAttribute<Topo,String> prefecture;

    public static volatile SingularAttribute<Topo,Boolean> forest;

    public static volatile SingularAttribute<Topo,Company> topoOwner;


    public static volatile SingularAttribute<Topo,Company> areaOwner;
}
