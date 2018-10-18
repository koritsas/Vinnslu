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

	public Person(Long afm, String name, String address, String department, int phone, String fathername, String mothername, String idCardNumber, String job, String surname, Long phone1, Date birthDate) {
		super(afm, name, address, department, phone);
		this.fathername = fathername;
		this.mothername = mothername;
		this.idCardNumber = idCardNumber;
		this.job = job;
		this.surname = surname;
		this.phone = phone1;
		this.birthDate = birthDate;
	}
}
