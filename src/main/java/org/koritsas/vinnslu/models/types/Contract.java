package org.koritsas.vinnslu.models.types;

import org.koritsas.vinnslu.models.common.Person;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Embeddable
public class Contract implements Serializable {

    @Column(name = "contract_id")
    private Long contractId;

    @Column(name = "start_date")
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

    public Long getContractId() {
	return contractId;
    }

    public void setContractId(Long contractId) {
	this.contractId = contractId;
    }

    public Date getContractDate() {
	return contractDate;
    }

    public void setContractDate(Date contractDate) {
	this.contractDate = contractDate;
    }

    public Person getNotary() {
	return notary;
    }

    public void setNotary(Person notary) {
	this.notary = notary;
    }
}
