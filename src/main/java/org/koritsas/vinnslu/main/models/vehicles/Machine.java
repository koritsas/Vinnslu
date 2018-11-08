package org.koritsas.vinnslu.main.models.vehicles;

import org.hibernate.annotations.GenericGenerator;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.types.Fuel;
import org.koritsas.vinnslu.main.models.types.MachineryType;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Machine implements Serializable {

    @Id
    @GenericGenerator(
	name = "machine_generator",
	strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
	    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "machine_seq"),
	    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
	    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
	}
    )
    @GeneratedValue(generator = "machine_generator")
    private Long id;

    @Enumerated(EnumType.STRING)
    private MachineryType category;

    private String brand;

    private String model;

    @Column(unique = true)
    private String stamp;

    @Column(unique = true)
    private String licensePlate;

    @Temporal(TemporalType.DATE)
    private Date licenseDate;

    private Long apad;

    private String ket;

    @Column(unique = true)
    private String frameNumber;

    @Column(unique = true)
    private String engineNumber;

    private int ps;

    private double kw;

    @Column(precision = 2)
    private double weight;

    @Column(precision = 2)
    private double length;

    @Column(precision = 2)
    private double width;

    @Column(precision = 2)
    private double height;

    @ManyToOne
    @JoinColumn(name = "company", referencedColumnName = "id", foreignKey = @ForeignKey(name = "COMPANY_FK"))
    private Company company;

    @Enumerated(EnumType.STRING)
    private Fuel fuel;



    private Machine(Builder builder) {

	setFuel(builder.nestedFuel);
	setHeight(builder.nestedHeight);
	setWidth(builder.nestedWidth);
	setLength(builder.nestedLength);
	setCompany(builder.nestedCompany);
	setCategory(builder.nestedCategory);
	setStamp(builder.nestedStamp);
	setBrand(builder.nestedBrand);
	setModel(builder.nestedModel);
	setLicensePlate(builder.nestedLicensePlate);
	setLicenseDate(builder.nestedLicenseDate);
	setApad(builder.nestedApad);
	setKet(builder.nestedKet);
	setFrameNumber(builder.nestedFrameNumber);
	setEngineNumber(builder.nestedEngineNumber);
	setPs(builder.nestedPs);
	setKw(builder.nestedKw);
	setWeight(builder.nestedWeight);
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public MachineryType getCategory() { return category; }

    public void setCategory(MachineryType category) { this.category = category; }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public String getStamp() { return stamp; }

    public void setStamp(String stamp) { this.stamp = stamp; }

    public String getLicensePlate() { return licensePlate; }

    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public Date getLicenseDate() { return licenseDate; }

    public void setLicenseDate(Date licenseDate) { this.licenseDate = licenseDate; }

    public Long getApad() { return apad; }

    public void setApad(Long apad) { this.apad = apad; }

    public String getKet() { return ket; }

    public void setKet(String ket) { this.ket = ket; }

    public String getFrameNumber() { return frameNumber; }

    public void setFrameNumber(String frameNumber) { this.frameNumber = frameNumber; }

    public String getEngineNumber() { return engineNumber; }

    public void setEngineNumber(String engineNumber) { this.engineNumber = engineNumber; }

    public int getPs() { return ps; }

    public void setPs(int ps) { this.ps = ps; }

    public double getKw() { return kw; }

    public void setKw(double kw) { this.kw = kw; }

    public double getWeight() { return weight; }

    public void setWeight(double weight) { this.weight = weight; }

    public double getLength() { return length; }

    public void setLength(double length) { this.length = length; }

    public double getWidth() { return width; }

    public void setWidth(double width) { this.width = width; }

    public double getHeight() { return height; }

    public void setHeight(double height) { this.height = height; }

    public Fuel getFuel() { return fuel; }

    public void setFuel(Fuel fuel) { this.fuel = fuel; }

    public Company getCompany() { return company; }

    public void setCompany(Company company) { this.company = company; }

    public static final class Builder {

	//Required Parameters
	private MachineryType nestedCategory;

	private String nestedStamp;

	//Optional Parameters

	private String nestedBrand;

	private String nestedModel;

	private String nestedLicensePlate;

	private Date nestedLicenseDate;

	private Long nestedApad;

	private String nestedKet;

	private String nestedFrameNumber;

	private String nestedEngineNumber;

	private int nestedPs;

	private int nestedKw;

	private double nestedWeight;

	private double nestedHeight;

	private double nestedWidth;

	private double nestedLength;

	private Company nestedCompany;

	private Fuel nestedFuel;


	public Builder(MachineryType category, String stamp) {
	    this.nestedCategory = category;
	    this.nestedStamp = stamp;
	}

	public Builder setCompany(Company company) {
	    nestedCompany = company;
	    return this;
	}

	public Builder setFuel(Fuel fuel) {
	    nestedFuel = fuel;
	    return this;
	}

	public Builder setHeight(double height) {
	    nestedHeight = height;
	    return this;
	}

	public Builder setWidth(double width) {
	    nestedWidth = width;
	    return this;
	}

	public Builder setLength(double length) {
	    nestedLength = length;
	    return this;
	}


	public Builder setBrand(String val) {
	    nestedBrand = val;
	    return this;
	}

	public Builder setModel(String val) {
	    nestedModel = val;
	    return this;
	}

	public Builder setLicensePlate(String val) {
	    nestedLicensePlate = val;
	    return this;
	}

	public Builder setLicenseDate(Date val) {
	    nestedLicenseDate = val;
	    return this;
	}

	public Builder setApad(Long val) {
	    nestedApad = val;
	    return this;
	}

	public Builder setKet(String val) {
	    nestedKet = val;
	    return this;
	}

	public Builder setFrameNumber(String val) {
	    nestedFrameNumber = val;
	    return this;
	}

	public Builder setEngineNumber(String val) {
	    nestedEngineNumber = val;
	    return this;
	}

	public Builder setPs(int val) {
	    nestedPs = val;
	    return this;
	}

	public Builder setKw(int val) {
	    nestedKw = val;
	    return this;
	}

	public Builder setWeight(double val) {
	    nestedWeight = val;
	    return this;
	}

	public Machine build() {
	    return new Machine(this);
	}
    }
}
