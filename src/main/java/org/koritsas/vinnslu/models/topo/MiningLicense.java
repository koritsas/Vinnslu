package org.koritsas.vinnslu.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Parameter;
import org.koritsas.vinnslu.models.common.Person;
import org.koritsas.vinnslu.models.common.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Mining_License",uniqueConstraints = @UniqueConstraint(columnNames = {"notary","contractDate","contractNumber"}))
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
    @NotNull
    @JoinColumn(name = "abl", referencedColumnName = "abl", foreignKey = @ForeignKey(name = "ABL_ID"))
    private Long abl;

    private Person notary;

    @Temporal(TemporalType.DATE)
    private Date contractDate;

    private int contractNumber;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @OneToOne
    @JoinColumn(name="environmental_impact_study", referencedColumnName = "id", foreignKey = @ForeignKey(name = "EIS_FK"))
    private EnvironmentalImpactStudy environmentalImpactStudy;

    @OneToOne
    @JoinColumn(name="technical_study", referencedColumnName = "id", foreignKey = @ForeignKey(name = "TS_FK"))
    private TechnicalStudy technicalStudy;

    private Status status;

    public MiningLicense() {
    }

    public MiningLicense(Long abl, Person notary, Date contractDate, int contractNumber, Date startDate, Date endDate, EnvironmentalImpactStudy environmentalImpactStudy, TechnicalStudy technicalStudy, Status status) {
        this.abl = abl;
        this.notary = notary;
        this.contractDate = contractDate;
        this.contractNumber = contractNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.environmentalImpactStudy = environmentalImpactStudy;
        this.technicalStudy = technicalStudy;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MiningLicense)) return false;
        MiningLicense that = (MiningLicense) o;
        return contractNumber == that.contractNumber &&
                Objects.equals(abl, that.abl) &&
                Objects.equals(notary, that.notary) &&
                Objects.equals(contractDate, that.contractDate) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(environmentalImpactStudy, that.environmentalImpactStudy) &&
                Objects.equals(technicalStudy, that.technicalStudy) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(abl, notary, contractDate, contractNumber, startDate, endDate, environmentalImpactStudy, technicalStudy, status);
    }

    @Override
    public String toString() {
        return "MiningLicense{" +
                "id=" + id +
                ", abl=" + abl +
                ", notary=" + notary +
                ", contractDate=" + contractDate +
                ", contractNumber=" + contractNumber +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", environmentalImpactStudy=" + environmentalImpactStudy +
                ", technicalStudy=" + technicalStudy +
                ", status=" + status +
                '}';
    }
}
