package org.koritsas.vinnslu.models.common;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Opinions implements Serializable {

    @Id
    @GenericGenerator(
           name = "opinions_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "opinions_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }

    )
    @GeneratedValue(generator = "opinions_generator")
    private Long id;

    private boolean cityPlanningCommission;

    private boolean archeology;

    private boolean speleology;

    private boolean forestry;

    private boolean miningInspection;


    public Opinions() {
    }

    public Opinions(boolean cityPlanningCommission, boolean archeology, boolean speleology, boolean forestry, boolean miningInspection) {
        this.cityPlanningCommission = cityPlanningCommission;
        this.archeology = archeology;
        this.speleology = speleology;
        this.forestry = forestry;
        this.miningInspection = miningInspection;
    }



    public boolean isCityPlanningCommissionPositive() {
        return cityPlanningCommission;
    }

    public void setCityPlanningCommissionOpinion(boolean cityPlanningCommission) {
        this.cityPlanningCommission = cityPlanningCommission;
    }

    public boolean isArcheologyPositive() {
        return archeology;
    }

    public void setArcheologyOpinion(boolean archeology) {
        this.archeology = archeology;
    }

    public boolean isSpeleologyPositive() {
        return speleology;
    }

    public void setSpeleologyOpinion(boolean speleology) {
        this.speleology = speleology;
    }

    public boolean isForestryPositive() {
        return forestry;
    }

    public void setForestryOpinion(boolean forestry) {
        this.forestry = forestry;
    }

    public boolean isMiningInspectionPositive() {
        return miningInspection;
    }

    public void setMiningInspectionOpinion(boolean miningInspection) {
        this.miningInspection = miningInspection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Opinions)) return false;
        Opinions opinions = (Opinions) o;
        return cityPlanningCommission == opinions.cityPlanningCommission &&
                archeology == opinions.archeology &&
                speleology == opinions.speleology &&
                forestry == opinions.forestry &&
                miningInspection == opinions.miningInspection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityPlanningCommission, archeology, speleology, forestry, miningInspection);
    }

    @Override
    public String toString() {
        return "Opinions{" +
                ", cityPlanningCommission=" + cityPlanningCommission +
                ", archeology=" + archeology +
                ", speleology=" + speleology +
                ", forestry=" + forestry +
                ", miningInspection=" + miningInspection +
                '}';
    }
}
