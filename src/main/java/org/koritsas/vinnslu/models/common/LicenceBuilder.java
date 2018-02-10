package org.koritsas.vinnslu.models.common;

import javafx.util.Builder;
import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.models.types.Contract;

import java.util.Date;

public abstract class LicenceBuilder<E,T> implements Builder<T>{


    //Required parameters
    private boolean active;

    private Contract contract;

    private Topo topo;

    private double area;


    //Optional parameters

    private Date endDate;

    private Date renewalDate;


    public LicenceBuilder(boolean active, Contract contract, Topo topo, double area) {
        this.active = active;
        this.contract = contract;
        this.topo = topo;
        this.area = area;
        this.endDate=calculateEndDate();
        this.renewalDate=calculateRenewalDate();

    }

    public boolean getActive() { return active; }

    public Contract getContract() { return contract; }

    public Topo getTopo() { return topo; }

    public double getArea() { return area; }

    public Date getEndDate() { return endDate; }

    public Date getRenewalDate() { return renewalDate; }

    public E setActive(boolean active){
        this.active=active;
        return (E) this;
    }

    public E setContract(Contract contract){
        this.contract=contract;
        return (E) this;
    }

    public E setTopo(Topo topo) {
        this.topo = topo;
        return (E) this;
    }

    public E setArea(double area) {
        this.area = area;
        return (E) this;
    }

    protected abstract Date calculateEndDate();

    protected abstract Date calculateRenewalDate();


}
