package org.koritsas.vinnslu.models;

import org.koritsas.vinnslu.models.common.LicenceBuilder;
import org.koritsas.vinnslu.models.types.Contract;

import javax.persistence.Entity;

import java.util.Calendar;
import java.util.Date;

@Entity
public class MiningLicense extends ResearchLicense {
    public MiningLicense(){
    }

    private MiningLicense(Builder builder){
	setActive(builder.getActive());
	setArea(builder.getArea());
	setContract(builder.getContract());
	setEndDate(builder.getEndDate());
	setRenewalDate(builder.getRenewalDate());
	setTopo(builder.getTopo());
    }
    public static class Builder extends LicenceBuilder<LicenceBuilder,MiningLicense>{

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

	    calendar.add(Calendar.YEAR,20);

	    return calendar.getTime();
	}

	@Override
	protected Date calculateRenewalDate() {

	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(calculateEndDate());

	    calendar.add(Calendar.YEAR,-2);
	    calendar.add(Calendar.MONTH,-3);
	    return calendar.getTime();
	}

	@Override
	public MiningLicense build() {
	    return new MiningLicense(this);
	}
    }

}
