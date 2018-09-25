package org.koritsas.vinnslu.ws.dto;

import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.models.common.Person;
import org.koritsas.vinnslu.models.vehicles.Vehicle;
import org.koritsas.vinnslu.models.types.VehicleType;
import org.koritsas.vinnslu.utils.AbstractDto;

import java.util.Date;

public class VehicleDto implements AbstractDto<Long> {

    private Long id;

    private String frameNumber;

    private String licensePlate;

    private String color;

    private VehicleType vehicleType;

    private Date exhaustCardEnd;

    private Date tollsEnd;

    private Date securityEnd;

    private Company ownerCompany;

    private Person driver;

    private String brand;

    private String model;

    public Long getId() { return id; }

    @Override
    public Class getClaZZ() {
        return Vehicle.class;
    }

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

}
