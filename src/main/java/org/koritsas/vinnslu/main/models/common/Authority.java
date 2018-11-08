package org.koritsas.vinnslu.main.models.common;


import javax.persistence.Entity;

@Entity
public class Authority extends Company{
    public Authority() {
    }

    public Authority(Long afm, String name, String address, String department, Long phone) {
        super(afm, name, address, department, phone);
    }
}
