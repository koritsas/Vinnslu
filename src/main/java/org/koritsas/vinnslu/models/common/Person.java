package org.koritsas.vinnslu.models.common;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
public class Person extends Company{

    private String fathername;

    private String mothername;

    @Column(name = "id_card_number")
    private String idCardNumber;

    private String job;

    private String surname;

    private Long phone;


    @Temporal(TemporalType.DATE)
    @Column(name="birth_date")
    private Date birthDate;

    public Person(){}


    private Person(PersonBuilder personBuilder){
	this.setName(personBuilder.getName());
	this.setAfm(personBuilder.getAfm());
	this.setAddress(personBuilder.getAddress());
	this.surname= personBuilder.nestedSurname;
	this.birthDate= personBuilder.nestedBirthDate;
	this.phone= personBuilder.nestedPhone;
        this.fathername= personBuilder.nestedFathername;
        this.mothername= personBuilder.nestedMothername;
        this.job = personBuilder.nestedJob;
        this.idCardNumber= personBuilder.nestedIdCardNumber;
    }

    public String getFathername() { return fathername; }

    public void setFathername(String fathername) { this.fathername = fathername; }

    public String getMothername() { return mothername; }

    public void setMothername(String mothername) { this.mothername = mothername; }

    public String getIdCardNumber() { return idCardNumber; }

    public void setIdCardNumber(String idCardNumber) { this.idCardNumber = idCardNumber; }

    public String getJob() { return job; }

    public void setJob(String job) { this.job = job; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public Long getPhone() { return phone; }

    public void setPhone(Long phone) { this.phone = phone; }

    public Date getBirthDate() { return birthDate; }

    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    @Override
    public String toString() {
	return "Person{" +
	    "name'" + getName() + '\'' +
	    "afm'" + getAfm() + '\'' +
	    "address'" + getAddress() + '\'' +
	    "fathername='" + fathername + '\'' +
	    ", mothername='" + mothername + '\'' +
	    ", idCardNumber='" + idCardNumber + '\'' +
	    ", job='" + job + '\'' +
	    ", surname='" + surname + '\'' +
	    ", phone=" + phone +
	    ", birthDate=" + birthDate +
	    '}';
    }

    public static class PersonBuilder extends OwnerBuilder<PersonBuilder,Person>{

        private String nestedFathername;

        private String nestedMothername;

        private String nestedIdCardNumber;

        private String nestedJob;

	private String nestedSurname;

	private Long nestedPhone;

	private Date nestedBirthDate;


	public PersonBuilder(String name,String surname) {
	    super(name);
	    this.nestedSurname=surname;
	}

	public PersonBuilder setSurname(String surname){
	    this.nestedSurname=surname;
	    return this;
	}

	public PersonBuilder setPhone(Long phone){
	    this.nestedPhone=phone;
	    return this;
	}

	public PersonBuilder setBirthDate(Date birthDate){
	    this.nestedBirthDate=birthDate;
	    return this;
	}

	public PersonBuilder setFathername(String fathername){
	    this.nestedFathername=fathername;
	    return this;
	}

	public PersonBuilder setMothername(String mothername){
	    this.nestedMothername = mothername;
	    return this;
	}

	public PersonBuilder setIdCardNumber(String idCardNumber){
	    this.nestedIdCardNumber=idCardNumber;
	    return this;
	}

	public PersonBuilder setDepartment(String department){
	    this.nestedJob = department;
	    return this;
	}


	@Override
	public Person build() {
	    return new Person(this);
	}
    }







}
