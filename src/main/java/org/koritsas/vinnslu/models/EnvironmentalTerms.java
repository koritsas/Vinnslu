package org.koritsas.vinnslu.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
public class EnvironmentalTerms implements Serializable {

    //Required parameters

    @Id
    @GenericGenerator(
	name = "environmental_generator",
	strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
	    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "environmental_seq"),
	    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
	    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
	}
    )
    @GeneratedValue(generator = "environmental_generator")
    private Long environmentlId;

    @OneToOne
    @JoinColumn(name="licence_id",foreignKey = @ForeignKey(name="MINING_LICENSE_FK"))
    private MiningLicense miningLicense;

    @NaturalId
    @OneToOne
    @JoinColumn(name = "abl", foreignKey = @ForeignKey(name = "TOPOS_ABL_FK"))
    private Topo topo;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date startDate;

    //Optional parameters
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Temporal(TemporalType.DATE)
    private Date renewalDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reductor_id", foreignKey = @ForeignKey(name = "PERSONS_ID_FK"))
    private Person reductor;

    private Authority organization;

    private String protocolNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", foreignKey = @ForeignKey(name = "DOCUMENTS_ID_FK"))
    private Document document;

    public EnvironmentalTerms() {}

    private EnvironmentalTerms(EnvironmentalTermsBuilder builder) {
	this.topo = builder.nestedTopo;
	this.protocolNumber = builder.nestedProtocolNumber;
	this.startDate = builder.nestedStartDate;
	this.endDate = builder.nestedEndDate;
	this.renewalDate = builder.nestedRenewalDate;
	this.reductor = builder.nestedReductor;
	this.organization = builder.nestedOrganization;
	this.document = builder.nestedDocument;
	this.miningLicense = builder.nestedMiningLicence;
    }


    public Long getEnvironmentlId() { return environmentlId; }

    public MiningLicense getMiningLicense() { return miningLicense; }

    public void setMiningLicense(
	MiningLicense miningLicense) { this.miningLicense = miningLicense; }

    public Topo getTopo() {
	return topo;
    }

    public void setTopo(Topo topo) {
	this.topo = topo;
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

    public Person getReductor() {
	return reductor;
    }

    public void setReductor(Person reductor) {
	this.reductor = reductor;
    }

    public Authority getOrganization() {
	return organization;
    }

    public void setOrganization(Authority organization) {
	this.organization = organization;
    }

    public String getProtocolNumber() {
	return protocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
	this.protocolNumber = protocolNumber;
    }

    public Document getDocument() {
	return document;
    }

    public void setDocument(Document document) {
	this.document = document;
    }

    //LicenceBuilder class
    public static class EnvironmentalTermsBuilder {

	//Required parameters
	private Topo nestedTopo;

	private Date nestedStartDate;

	private MiningLicense nestedMiningLicence;

	//Optional Parameters
	private String nestedProtocolNumber;

	private Date nestedEndDate;

	private Date nestedRenewalDate;

	private Person nestedReductor;

	private Authority nestedOrganization;

	private Document nestedDocument;

	public EnvironmentalTermsBuilder(Topo topo, Date startDate,MiningLicense miningLicense) {
	    this.nestedTopo = topo;
	    this.nestedStartDate = startDate;
	    this.nestedMiningLicence = miningLicense;
	}

	public EnvironmentalTermsBuilder setProtocolNumber(String protocolNumber) {
	    this.nestedProtocolNumber = protocolNumber;
	    return this;
	}

	public EnvironmentalTermsBuilder setEndDate(Date endDate) {
	    this.nestedEndDate = endDate;
	    return this;
	}

	public EnvironmentalTermsBuilder setRenewalDate(Date renewalDate) {
	    this.nestedRenewalDate = renewalDate;
	    return this;
	}

	public EnvironmentalTermsBuilder setReductor(Person reductor) {
	    this.nestedReductor = reductor;
	    return this;
	}

	public EnvironmentalTermsBuilder setOrganization(Authority organization) {
	    this.nestedOrganization = organization;
	    return this;
	}

	public EnvironmentalTermsBuilder setDocument(Document document) {
	    this.nestedDocument = document;
	    return this;
	}

	public EnvironmentalTerms build() {
	    EnvironmentalTerms environmentalTerms = new EnvironmentalTerms(this);
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(nestedStartDate);
	    calendar.add(Calendar.YEAR, 10);

	    environmentalTerms.setEndDate(calendar.getTime());

	    calendar.add(Calendar.MONTH, -3);

	    environmentalTerms.setRenewalDate(calendar.getTime());

	    return environmentalTerms;
	}

    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
	}
        if(super.equals(o)){
            return true;
	}
	if(o == null || this.getClass() != o.getClass()){
            return false;
	}
	EnvironmentalTerms terms = (EnvironmentalTerms) o;
        return topo == terms.topo &&
	    startDate == terms.startDate &&
	    renewalDate == terms.renewalDate &&
	    endDate == terms.endDate &&
	    reductor == terms.reductor &&
	    organization == terms.organization &&
	    protocolNumber == terms.protocolNumber &&
	    document == terms.document;
    }

    @Override
    public int hashCode(){return Objects.hash(super.hashCode(),topo,startDate,endDate,renewalDate,reductor,organization,protocolNumber,document);}

}
