package org.koritsas.vinnslu.main.models.metamodels;

import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Person;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Person.class)
public class Person_ {


    public static volatile SingularAttribute<Person,Long> id;


    public static volatile SingularAttribute<Person,Long> afm;


    public static volatile SingularAttribute<Person,String> name;

    public static volatile SingularAttribute<Person,String> address;

    public static volatile SingularAttribute<Person,String> department;

    public static volatile SingularAttribute<Person,Long> phone;

   public static volatile SingularAttribute<Person,String> fathername;

    public static volatile SingularAttribute<Person,String> mothername;

    public static volatile SingularAttribute<Person,String> idCardNumber;

    public static volatile SingularAttribute<Person,String> job;

    public static volatile SingularAttribute<Person,String> surname;



    public static volatile SingularAttribute<Person,Date> birthDate;
}
