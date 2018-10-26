package org.koritsas.vinnslu.models.vehicles;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.models.common.Person;
import org.koritsas.vinnslu.models.types.Fuel;
import org.koritsas.vinnslu.models.types.VehicleType;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Vehicle implements Serializable {

    @Id
    @GenericGenerator(
	name = "vehicle_generator",
	strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
	    @Parameter(name = "sequence_name", value = "vehicle_seq"),
	    @Parameter(name = "initial_value", value = "1"),
	    @Parameter(name = "increment_size", value = "1")
	}
    )
    @GeneratedValue(generator = "vehicle_generator")
    private Long id;

    @Column(precision = 17)
    @NaturalId
    private String frameNumber;

    @Column(precision = 6, unique = true)
    @NaturalId
    private String licensePlate;

    private String color;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Enumerated(EnumType.STRING)
    private Fuel fuel;

    @Temporal(TemporalType.DATE)
    private Date exhaustCardEnd;

    @Temporal(TemporalType.DATE)
    private Date tollsEnd;

    @Temporal(TemporalType.DATE)
    private Date securityEnd;

    @ManyToOne
    @JoinColumn(name = "owner_company", referencedColumnName = "id", foreignKey = @ForeignKey(name = "COMPANY_ID_FK"))
    private Company ownerCompany;

    @ManyToOne
    @JoinColumn(name = "driver", referencedColumnName = "id", foreignKey = @ForeignKey(name = "PERSON_ID_FK"))
    private Person driver;

    private String brand;

    private String model;

    public Vehicle() {
    }

    private Vehicle(Builder builder) {
	setFrameNumber(builder.nestedFrameNumber);
	setLicensePlate(builder.nestedLicensePlate);
	setColor(builder.nestedColor);
	setVehicleType(builder.nestedVehicleType);
	setExhaustCardEnd(builder.nestedExhaustCardEnd);
	setTollsEnd(builder.nestedTollsEnd);
	setSecurityEnd(builder.nestedSecurityEnd);
	setOwnerCompany(builder.nestedOwnerCompany);
	setDriver(builder.nestedDriver);
	setBrand(builder.nestedBrand);
	setModel(builder.nestedModel);
	setFuel(builder.nestedFuel);
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFrameNumber() { return frameNumber; }

    public void setFrameNumber(String frameNumber) { this.frameNumber = frameNumber; }

    public String getLicensePlate() { return licensePlate; }

    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public VehicleType getVehicleType() { return vehicleType; }

    public void setVehicleType(
	VehicleType vehicleType) { this.vehicleType = vehicleType; }

    public Date getExhaustCardEnd() { return exhaustCardEnd; }

    public void setExhaustCardEnd(Date exhaustCardEnd) { this.exhaustCardEnd = exhaustCardEnd; }

    public Date getTollsEnd() { return tollsEnd; }

    public void setTollsEnd(Date tollsEnd) { this.tollsEnd = tollsEnd; }

    public Date getSecurityEnd() { return securityEnd; }

    public void setSecurityEnd(Date securityEnd) { this.securityEnd = securityEnd; }

    public Company getOwnerCompany() { return ownerCompany; }

    public void setOwnerCompany(Company ownerCompany) { this.ownerCompany = ownerCompany; }

    public Person getDriver() { return driver; }

    public void setDriver(Person driver) { this.driver = driver; }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    /**
     * {@code Vehicle} builder static inner class.
     */
    public static final class Builder {

	//Required Parameters
	private String nestedFrameNumber;

	private String nestedLicensePlate;

	private VehicleType nestedVehicleType;

	//Optional parameters
	private String nestedBrand;

	private String nestedModel;

	private String nestedColor;

	private Date nestedExhaustCardEnd;

	private Date nestedTollsEnd;

	private Date nestedSecurityEnd;

	private Company nestedOwnerCompany;

	private Person nestedDriver;

	private Fuel nestedFuel;

	public Builder(String licensePlate, String frameNumber, VehicleType type) {
	    this.nestedLicensePlate = licensePlate;
	    this.nestedFrameNumber = frameNumber;
	    this.nestedVehicleType = type;
	}

	/**
	 * Sets the {@code color} and returns a reference to this Builder so that the methods can be chained together.
	 *
	 * @param color the {@code color} to set
	 * @return a reference to this Builder
	 */
	public Builder setColor(String color) {
	    nestedColor = color;
	    return this;
	}

	public Builder setFuel(Fuel fuel){
		nestedFuel = fuel;
		return this;
	}

	/**
	 * Sets the {@code exhaustCardEnd} and returns a reference to this Builder so that the methods can be chained together.
	 *
	 * @param exhaustCardEnd the {@code exhaustCardEnd} to set
	 * @return a reference to this Builder
	 */
	public Builder setExhaustCardEnd(Date exhaustCardEnd) {
	    nestedExhaustCardEnd = exhaustCardEnd;
	    return this;
	}

	/**
	 * Sets the {@code tollsEnd} and returns a reference to this Builder so that the methods can be chained together.
	 *
	 * @param tollsEnd the {@code tollsEnd} to set
	 * @return a reference to this Builder
	 */
	public Builder setTollsEnd(Date tollsEnd) {
	    nestedTollsEnd = tollsEnd;
	    return this;
	}

	/**
	 * Sets the {@code securityEnd} and returns a reference to this Builder so that the methods can be chained together.
	 *
	 * @param securityEnd the {@code securityEnd} to set
	 * @return a reference to this Builder
	 */
	public Builder setSecurityEnd(Date securityEnd) {
	    nestedSecurityEnd = securityEnd;
	    return this;
	}

	/**
	 * Sets the {@code ownerCompany} and returns a reference to this Builder so that the methods can be chained together.
	 *
	 * @param ownerComany the {@code ownerCompany} to set
	 * @return a reference to this Builder
	 */
	public Builder setOwnerCompany(Company ownerComany) {
	    nestedOwnerCompany = ownerComany;
	    return this;
	}

	/**
	 * Sets the {@code driver} and returns a reference to this Builder so that the methods can be chained together.
	 *
	 * @param driver the {@code driver} to set
	 * @return a reference to this Builder
	 */
	public Builder setDriver(Person driver) {
	    nestedDriver = driver;
	    return this;
	}

	/**
	 * Sets the {@code brand} and returns a reference to this Builder so that the methods can be chained together.
	 *
	 * @param brand the {@code brand} to set
	 * @return a reference to this Builder
	 */
	public Builder setBrand(String brand) {
	    nestedBrand = brand;
	    return this;
	}

	/**
	 * Sets the {@code model} and returns a reference to this Builder so that the methods can be chained together.
	 *
	 * @param model the {@code model} to set
	 * @return a reference to this Builder
	 */
	public Builder setModel(String model) {
	    nestedModel = model;
	    return this;
	}

	/**
	 * Returns a {@code Vehicle} built from the parameters previously set.
	 *
	 * @return a {@code Vehicle} built with parameters of this {@code Vehicle.Builder}
	 */
	public Vehicle build() {
	    return new Vehicle(this);
	}
    }
}
