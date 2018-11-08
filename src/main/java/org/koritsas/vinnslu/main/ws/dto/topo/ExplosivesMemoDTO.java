package org.koritsas.vinnslu.main.ws.dto.topo;

import org.koritsas.vinnslu.main.models.common.Document;
import org.koritsas.vinnslu.main.models.common.Person;
import org.koritsas.vinnslu.main.models.topo.ExplosivesMemo;
import org.koritsas.vinnslu.main.models.topo.Topo;
import org.koritsas.vinnslu.main.ws.dto.AbstractDto;

import java.util.Date;

public class ExplosivesMemoDTO implements AbstractDto<Long> {

    private Long id;

    private boolean active;

    private String protocol;

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

    private Topo topo;

    private Topo topo_abl;

    private Document document;

    public Long getId(){
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
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

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Topo getTopo_abl() {
        return topo_abl;
    }

    public void setTopo_abl(Topo topo_abl) {
        this.topo_abl = topo_abl;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }



    @Override
    public Class getClaZZ() {
        return ExplosivesMemo.class;
    }
}
