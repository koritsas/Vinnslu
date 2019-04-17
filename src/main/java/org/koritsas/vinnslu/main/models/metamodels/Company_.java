package org.koritsas.vinnslu.main.models.metamodels;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.koritsas.vinnslu.main.models.common.Company;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Company.class)
public class Company_ {

    public static volatile SingularAttribute<Company,Long> id;


    public static volatile SingularAttribute<Company,Long> afm;


    public static volatile SingularAttribute<Company,String> name;

    public static volatile SingularAttribute<Company,String> address;

    public static volatile SingularAttribute<Company,String> department;

    public static volatile SingularAttribute<Company,Long> phone;

}
