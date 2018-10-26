package org.koritsas.vinnslu.models.types;

import org.koritsas.vinnslu.models.common.Person;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Embeddable
public class Contract implements Serializable {


    private Long contractId;

    private String contractProtocol;

    @Temporal(TemporalType.DATE)
    private Date contractDate;

    @ManyToOne
    @JoinColumn(name = "notary_id", foreignKey = @ForeignKey(name = "PERSONS_ID_FK"))
    private Person notary;

    public Contract(Long contractId, Date contractDate, Person notary) {
	this.contractId = contractId;
	this.contractDate = contractDate;
	this.notary = notary;
    }

    private Contract() {}

    public Contract(Long contractId, String contractProtocol, Date contractDate, Person notary) {
        this.contractId = contractId;
        this.contractProtocol = contractProtocol;
        this.contractDate = contractDate;
        this.notary = notary;
    }
}
