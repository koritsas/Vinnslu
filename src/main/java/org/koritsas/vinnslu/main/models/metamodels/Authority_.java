package org.koritsas.vinnslu.main.models.metamodels;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Authority.class)
public class Authority_ {


    public static volatile SingularAttribute<Authority,Long> id;


    public static volatile SingularAttribute<Authority,Long> afm;


    public static volatile SingularAttribute<Authority,String> name;

    public static volatile SingularAttribute<Authority,String> address;

    public static volatile SingularAttribute<Authority,String> department;

    public static volatile SingularAttribute<Authority,Long> phone;
}
