package org.koritsas.vinnslu.models;

import org.hibernate.annotations.GenericGenerator;
import org.koritsas.vinnslu.models.common.OwnerBuilder;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Embeddable
public class Company implements Serializable{

    @Id
    @GenericGenerator(
	name = "company_generator",
	strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	parameters = {
	    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "company_seq"),
	    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
	    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
	}
    )
    @GeneratedValue(generator = "company_generator")
    private Long id;


    @Column(unique = true)
    private Long afm;

    @Column(nullable = false)
    private String name;

    private String address;

    public Company() {}

    public Company(Long afm, String name, String address) {
	this.afm = afm;
	this.name = name;
	this.address = address;
    }

    private Company(CompanyBuilder companyBuilder){
        this.afm=companyBuilder.getAfm();
        this.address=companyBuilder.getAddress();
        this.name=companyBuilder.getName();
    }

    public Long getId() { return id; }

    public Long getAfm() { return afm; }

    public void setAfm(Long afm) { this.afm = afm; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
	return "Company{" +
	    "id=" + id +
	    ", afm=" + afm +
	    ", name='" + name + '\'' +
	    ", address='" + address + '\'' +
	    '}';
    }

    public static class CompanyBuilder extends OwnerBuilder<CompanyBuilder,Company>{

	public CompanyBuilder(String name) {
	    super(name);
	}

	@Override
	public Company build() {
	    return new Company(this);
	}


    }
}
