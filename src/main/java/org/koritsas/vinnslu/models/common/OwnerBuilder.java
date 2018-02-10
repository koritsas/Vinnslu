package org.koritsas.vinnslu.models.common;

import javafx.util.Builder;

public abstract class OwnerBuilder<E,T> implements Builder<T>
{

    private String name;

    private Long afm;

    private String address;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Long getAfm() { return afm; }

    public String getAddress() { return address; }

    public OwnerBuilder(String name){
        this.name=name;
    }

    public E setAddress(String address){
        this.address=address;
        return (E) this;
    }

    public E setAfm(Long afm){
        this.afm=afm;
        return (E) this;
    }

}
