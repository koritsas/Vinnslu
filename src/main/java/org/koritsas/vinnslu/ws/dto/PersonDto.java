package org.koritsas.vinnslu.ws.dto;

import org.koritsas.vinnslu.models.Person;
import org.koritsas.vinnslu.utils.AbstractDto;

import java.util.Date;

public class PersonDto implements AbstractDto<Long> {

    private Long id;

    private String name;

    private String address;

    private String afm;

    private String fathername;

    private String mothername;

    private String idCardNumber;

    private String job;

    private String surname;

    private Long phone;

    private Date birthDate;

    public Long getId() { return id; }

    @Override
    public Class getClaZZ() {
        return Person.class;
    }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getAfm() { return afm; }

    public void setAfm(String afm) { this.afm = afm; }

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
}
