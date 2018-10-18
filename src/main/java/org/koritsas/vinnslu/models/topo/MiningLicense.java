package org.koritsas.vinnslu.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.models.common.Person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Mining_License")
public class MiningLicense {

    @Id
    @GenericGenerator(
            name = "min_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "min_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @GeneratedValue(generator = "min_generator")
    private Long id;

    @NaturalId
    @JoinColumn(name = "topo_abl", referencedColumnName = "abl", foreignKey = @ForeignKey(name = "MINING_LICENSE_TOPO_ABL_ID"))
    private Topo topo_abl;

    private boolean active;

    private String ada;


    @Embedded
    @Column(unique = true)
    private Contract contract;

    @Temporal(TemporalType.DATE)
    private Date endDate;


    @ManyToOne
    @JoinColumn(name = "technical_study_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "MINING_LICENSE_TECHNICAL_STUDY_ID"))
    private TechnicalStudy technicalStudy;

    @ManyToOne
    @JoinColumn(name = "topo_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "MINING_LICENSE_TOPO_ID"))
    private Topo topo;

    @ManyToOne
    @JoinColumn(name = "environmental_guarantee_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "MINING_LICENSE_ENVIRONMENTAL_GUARANTEE_ID"))
    private Guarantee environmentalGuarantee;

    @ManyToOne
    @JoinColumn(name = "lease_guarantee_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "MINING_LICENSE_LEASE_GUARANTEE_ID"))
    private Guarantee leaseGuarantee;

    public MiningLicense() {
    }

    public MiningLicense(Topo topo_abl, boolean active, String ada, Contract contract, Date endDate, TechnicalStudy technicalStudy, Topo topo, Guarantee environmentalGuarantee, Guarantee leaseGuarantee) {
        this.topo_abl = topo_abl;
        this.active = active;
        this.ada = ada;
        this.contract = contract;
        this.endDate = endDate;
        this.technicalStudy = technicalStudy;
        this.topo = topo;
        this.environmentalGuarantee = environmentalGuarantee;
        this.leaseGuarantee = leaseGuarantee;
    }

    public Long getId() {
        return id;
    }

    public Topo getTopo_abl() {
        return topo_abl;
    }

    public void setTopo_abl(Topo topo_abl) {
        this.topo_abl = topo_abl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAda() {
        return ada;
    }

    public void setAda(String ada) {
        this.ada = ada;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public TechnicalStudy getTechnicalStudy() {
        return technicalStudy;
    }

    public void setTechnicalStudy(TechnicalStudy technicalStudy) {
        this.technicalStudy = technicalStudy;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Guarantee getEnvironmentalGuarantee() {
        return environmentalGuarantee;
    }

    public void setEnvironmentalGuarantee(Guarantee environmentalGuarantee) {
        this.environmentalGuarantee = environmentalGuarantee;
    }

    public Guarantee getLeaseGuarantee() {
        return leaseGuarantee;
    }

    public void setLeaseGuarantee(Guarantee leaseGuarantee) {
        this.leaseGuarantee = leaseGuarantee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiningLicense)) return false;
        MiningLicense that = (MiningLicense) o;
        return active == that.active &&
                Objects.equals(topo_abl, that.topo_abl) &&
                Objects.equals(ada, that.ada) &&
                Objects.equals(contract, that.contract) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(technicalStudy, that.technicalStudy) &&
                Objects.equals(topo, that.topo) &&
                Objects.equals(environmentalGuarantee, that.environmentalGuarantee) &&
                Objects.equals(leaseGuarantee, that.leaseGuarantee);
    }

    @Override
    public String toString() {
        return "MiningLicense{" +
                "topo_abl=" + topo_abl +
                ", active=" + active +
                ", ada='" + ada + '\'' +
                ", contract=" + contract +
                ", endDate=" + endDate +
                ", technicalStudy=" + technicalStudy +
                ", topo=" + topo +
                ", environmentalGuarantee=" + environmentalGuarantee +
                ", leaseGuarantee=" + leaseGuarantee +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(topo_abl, active, ada, contract, endDate, technicalStudy, topo, environmentalGuarantee, leaseGuarantee);
    }

    // Embeddable class for Contract
    @Embeddable
    private class Contract{

        private Date date;

        private Person notary;

        private int contractNumber;

        public Contract() {
        }

        public Contract(Date date, Person notary, int contractNumber) {
            this.date = date;
            this.notary = notary;
            this.contractNumber = contractNumber;
        }


    }


}
