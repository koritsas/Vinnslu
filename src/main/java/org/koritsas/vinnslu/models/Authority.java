package org.koritsas.vinnslu.models;

import javax.persistence.Entity;

@Entity
public class Authority extends Company{
    public Authority() {
    }

    public Authority(Long afm, String name, String address) {
	super(afm, name, address);
    }
}
