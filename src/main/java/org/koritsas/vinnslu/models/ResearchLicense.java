package org.koritsas.vinnslu.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.koritsas.vinnslu.models.types.Contract;
import org.koritsas.vinnslu.utils.LicenceBuilder;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ResearchLicense {

    @Id
    @GenericGenerator(
        name = "license_generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "license_seq"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
    )
    @GeneratedValue(generator = "license_generator")
    private Long licenseId;

    @Column(nullable = false)
    private boolean active;

    @OneToOne
    @JoinColumn(name="abl",foreignKey = @ForeignKey(name="TOPOS_ABL_FK"))
    @NaturalId
    private Topo topo;

    @Embedded
    @Column(nullable = false,unique = true)
    private Contract contract;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Temporal(TemporalType.DATE)
    private Date renewalDate;

    @Column(nullable = false)
    private Double area;

    public ResearchLicense(){ }

    private ResearchLicense(Builder builder){
        setActive(builder.getActive());
        setArea(builder.getArea());
        setContract(builder.getContract());
        setEndDate(builder.getEndDate());
        setRenewalDate(builder.getRenewalDate());
        setTopo(builder.getTopo());
    }


    public Date getStartDate(){
        return  this.getContract().getContractDate();
    }

    public boolean getActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

    public Topo getTopo() { return topo; }

    public void setTopo(Topo topo) { this.topo = topo; }

    public Contract getContract() { return contract; }

    public void setContract(Contract contract) { this.contract = contract; }

    public Date getEndDate() { return endDate; }

    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public Date getRenewalDate() { return renewalDate; }

    public void setRenewalDate(Date renewalDate) { this.renewalDate = renewalDate; }

    public Double getArea() { return area; }

    public void setArea(Double area) { this.area = area; }

    public static class Builder extends LicenceBuilder<Builder,ResearchLicense>{

        public Builder(boolean active, Contract contract,
            Topo topo, double area) {
            super(active, contract, topo, area);
        }

        @Override
        protected Date calculateEndDate() {
            Contract contract=this.getContract();
            Date start_date = contract.getContractDate();

            Calendar calendar =Calendar.getInstance();

            calendar.setTime(start_date);

            calendar.add(Calendar.MONTH,6);

            return calendar.getTime();
        }

        @Override
        protected Date calculateRenewalDate() {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(calculateEndDate());


            calendar.add(Calendar.MONTH,-1);
            return calendar.getTime();
        }

        @Override
        public ResearchLicense build() {
            return new ResearchLicense(this);
        }
    }

}
