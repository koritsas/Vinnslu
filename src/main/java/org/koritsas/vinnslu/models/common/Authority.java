package org.koritsas.vinnslu.models.common;


import javax.persistence.Entity;

@Entity
public class Authority extends Company{
    public Authority() {
    }

    public Authority(int afm, String name, String address, String department, int phone) {
        super(afm, name, address, department, phone);
    }
}
