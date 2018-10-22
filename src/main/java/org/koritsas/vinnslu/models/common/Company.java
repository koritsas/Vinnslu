package org.koritsas.vinnslu.models.common;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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

    @NaturalId
    @Column(unique = true)
    private int afm;

    @Column(nullable = false)
    private String name;

    private String address;

    private String department;

    private int phone;

    public Company() {}

    public Company(int afm, String name, String address, String department, int phone) {
        this.afm = afm;
        this.name = name;
        this.address = address;
        this.department = department;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAfm() {
        return afm;
    }

    public void setAfm(int afm) {
        this.afm = afm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return phone == company.phone &&
                Objects.equals(id, company.id) &&
                Objects.equals(afm, company.afm) &&
                Objects.equals(name, company.name) &&
                Objects.equals(address, company.address) &&
                Objects.equals(department, company.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, afm, name, address, department, phone);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", afm=" + afm +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                ", phone=" + phone +
                '}';
    }
}
