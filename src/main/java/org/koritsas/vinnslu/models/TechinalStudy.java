package org.koritsas.vinnslu.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
public class TechinalStudy implements Serializable {

    @Id
    @GenericGenerator(
        name = "technical_generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "technical_seq"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
    )
    @GeneratedValue(generator = "technical_generator")
    private Long id;

    @OneToOne
    @JoinColumn(name="licence_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="MINING_LICENSE_FK"))
    private MiningLicense miningLicense;


    @NaturalId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="abl",referencedColumnName = "abl",foreignKey = @ForeignKey(name="MINING_LICENCE_FK"))
    private Topo topo;

    private String protocolNumber;

    @Column(nullable = false)
    private boolean approved;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Temporal(TemporalType.DATE)
    private Date renewalDate;

    private Authority organization;

    @ManyToOne
    @JoinColumn(name="reductor_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="PERSONS_ID_FK"))
    private Person reductor;

    @ManyToOne
    @JoinColumn(name="supervisor_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="PERSONS_ID_FK"))
    private Person supervisor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "DOCUMENTS_ID_FK"))
    private Document document;

    public TechinalStudy(){
    }

    private TechinalStudy(TechincalStudyBuilder builder) {
        this.topo = builder.nestedTopo;
        this.protocolNumber = builder.nestedProtocolNumber;
        this.approved = builder.nestedApproved;
        this.startDate = builder.nestedStartDate;
        this.endDate = builder.nestedEndDate;
        this.renewalDate = builder.nestedRenewalDate;
        this.organization = builder.nestedOrganization;
        this.reductor = builder.nestedReductor;
        this.supervisor=builder.nestedSupervisor;
        this.document=builder.nestedDocument;
        this.miningLicense=builder.nestedMiningLicense;
    }

    public Long getId() { return id; }

    public MiningLicense getMiningLicense() { return miningLicense; }

    public void setMiningLicense(
        MiningLicense miningLicense) { this.miningLicense = miningLicense; }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
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

    public Authority getOrganization() {
        return organization;
    }

    public void setOrganization(Authority organization) {
        this.organization = organization;
    }

    public Person getReductor() {
        return reductor;
    }

    public void setReductor(Person reductor) {
        this.reductor = reductor;
    }

    public Person getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Person supervisor) {
        this.supervisor = supervisor;
    }

    public boolean getApproved() { return approved; }

    public Document getDocument() { return document; }

    public void setDocument(Document document) { this.document = document; }

    //Nested builder
    public static class  TechincalStudyBuilder{

        //Required parameters
        private Topo nestedTopo;

        private boolean nestedApproved;

        private MiningLicense nestedMiningLicense;

        //Optional parameters
        private String nestedProtocolNumber;

        private Authority nestedOrganization;

        private Date nestedStartDate;

        private Date nestedEndDate;

        private Date nestedRenewalDate;

        private Person nestedReductor;

        private Person nestedSupervisor;

        private Document nestedDocument;

        public TechincalStudyBuilder(Topo topo, boolean nestedApproved,MiningLicense miningLicense){
            this.nestedTopo=topo;
            this.nestedApproved=nestedApproved;
            this.nestedMiningLicense=miningLicense;
        }


        public TechincalStudyBuilder setTopo(Topo nestedTopo) {
            this.nestedTopo = nestedTopo;
            return this;
        }


        public TechincalStudyBuilder setApproved(boolean nestedApproved) {
            this.nestedApproved = nestedApproved;
            return this;
        }


        public TechincalStudyBuilder setProtocolNumber(String nestedProtocolNumber) {
            this.nestedProtocolNumber = nestedProtocolNumber;
            return this;
        }

        public TechincalStudyBuilder setOrganization(Authority nestedOrganization) {
            this.nestedOrganization = nestedOrganization;
            return this;
        }

        public TechincalStudyBuilder setStartDate(Date nestedStartDate) {
            this.nestedStartDate = nestedStartDate;
            return this;
        }


        public TechincalStudyBuilder setEndDate(Date nestedEndDate) {
            this.nestedEndDate = nestedEndDate;
            return this;
        }


        public TechincalStudyBuilder setRenewalDate(Date nestedRenewalDate) {
            this.nestedRenewalDate = nestedRenewalDate;
            return this;
        }


        public TechincalStudyBuilder setReductor(Person nestedReductor) {
            this.nestedReductor = nestedReductor;
            return this;
        }


        public TechincalStudyBuilder setSupervisor(Person nestedSupervisor) {
            this.nestedSupervisor = nestedSupervisor;
            return this;
        }

        public TechincalStudyBuilder setDocument(Document nestedDocument) {
            this.nestedDocument = nestedDocument;
            return this;
        }

        public TechinalStudy build(){
            TechinalStudy techinalStudy = new TechinalStudy(this);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nestedStartDate);
            calendar.add(Calendar.YEAR,15);

            techinalStudy.setEndDate(calendar.getTime());

            calendar.add(Calendar.MONTH,-3);

            techinalStudy.setRenewalDate(calendar.getTime());


            return techinalStudy;

        }
    }
}
