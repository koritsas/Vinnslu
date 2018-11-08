package org.koritsas.vinnslu.main.ws.dto.vehicles;

import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.types.Fuel;
import org.koritsas.vinnslu.main.models.types.MachineryType;
import org.koritsas.vinnslu.main.models.vehicles.Machine;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import java.util.Date;

public class MachineDTO implements AbstractDto<Long> {
    private Long id;

    private MachineryType category;

    private String brand;

    private String model;

    private String stamp;

    private String licensePlate;

    private Date licenseDate;

    private Long apad;

    private String ket;

    private String frameNumber;

    private String engineNumber;

    private int ps;

    private double kw;

    private double weight;

    private Company company;

    private Fuel fuel;

    private double length;

    private double width;

    private double height;

    public Long getId() { return id; }

    @Override
    public Class getClaZZ() {
        return Machine.class;
    }

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

    public Company getCompany() { return company; }

    public void setCompany(Company company) { this.company = company; }

    public Fuel getFuel() { return fuel; }

    public void setFuel(Fuel fuel) { this.fuel = fuel; }

    public double getLength() { return length; }

    public void setLength(double length) { this.length = length; }

    public double getWidth() { return width; }

    public void setWidth(double width) { this.width = width; }

    public double getHeight() { return height; }

    public void setHeight(double height) { this.height = height; }
}
