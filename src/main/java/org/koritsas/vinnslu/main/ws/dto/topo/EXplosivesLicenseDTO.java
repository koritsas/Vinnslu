package org.koritsas.vinnslu.main.ws.dto.topo;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Person;
import org.koritsas.vinnslu.main.models.topo.ExplosivesLicense;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import java.util.Date;

public class EXplosivesLicenseDTO implements AbstractDto<Long> {

    private Long id;

    private Date startDate;

    private Date endDate;

    private Date renewalDate;

    private double anfo;

    private double gelignite;

    private int commonCartridge;

    private int nonel;

    private int shortFuse;

    private int instantFuse;

    private int retardants;

    private Person blaster;

    private Person licenseHolder;

    private Authority policeStation;

    private Topo topo;

    private Document document;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Class getClaZZ() {
        return ExplosivesLicense.class;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public double getAnfo() {
        return anfo;
    }

    public void setAnfo(double anfo) {
        this.anfo = anfo;
    }

    public double getGelignite() {
        return gelignite;
    }

    public void setGelignite(double gelignite) {
        this.gelignite = gelignite;
    }

    public int getCommonCartridge() {
        return commonCartridge;
    }

    public void setCommonCartridge(int commonCartridge) {
        this.commonCartridge = commonCartridge;
    }

    public int getNonel() {
        return nonel;
    }

    public void setNonel(int nonel) {
        this.nonel = nonel;
    }

    public int getShortFuse() {
        return shortFuse;
    }

    public void setShortFuse(int shortFuse) {
        this.shortFuse = shortFuse;
    }

    public int getInstantFuse() {
        return instantFuse;
    }

    public void setInstantFuse(int instantFuse) {
        this.instantFuse = instantFuse;
    }

    public int getRetardants() {
        return retardants;
    }

    public void setRetardants(int retardants) {
        this.retardants = retardants;
    }

    public Person getBlaster() {
        return blaster;
    }

    public void setBlaster(Person blaster) {
        this.blaster = blaster;
    }

    public Person getLicenseHolder() {
        return licenseHolder;
    }

    public void setLicenseHolder(Person licenseHolder) {
        this.licenseHolder = licenseHolder;
    }

    public Authority getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(Authority policeStation) {
        this.policeStation = policeStation;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
