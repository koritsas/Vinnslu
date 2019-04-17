package org.koritsas.vinnslu.main.models.metamodels;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.common.Person;
import org.koritsas.vinnslu.main.models.types.Fuel;
import org.koritsas.vinnslu.main.models.types.VehicleType;
import org.koritsas.vinnslu.main.models.vehicles.Vehicle;

import javax.persistence.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Vehicle.class)
public class Vehicle_ {


   public static volatile SingularAttribute<Vehicle,Long> id;

    public static volatile SingularAttribute<Vehicle,String> frameNumber;

    public static volatile SingularAttribute<Vehicle,String> licensePlate;

    public static volatile SingularAttribute<Vehicle,String> color;

    public static volatile SingularAttribute<Vehicle,VehicleType> vehicleType;

   public static volatile SingularAttribute<Vehicle,Fuel> fuel;

    public static volatile SingularAttribute<Vehicle,Date> exhaustCardEnd;

    public static volatile SingularAttribute<Vehicle,Date> tollsEnd;

    public static volatile SingularAttribute<Vehicle,Date> securityEnd;

    public static volatile SingularAttribute<Vehicle,Company> ownerCompany;

    public static volatile SingularAttribute<Vehicle,Person> driver;

    public static volatile SingularAttribute<Vehicle,String> brand;

    public static volatile SingularAttribute<Vehicle,String> model;
}
