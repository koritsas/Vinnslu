package org.koritsas.vinnslu.models;

import org.koritsas.vinnslu.models.types.GuaranteeLetterType;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "guarantees")
@Embeddable
public class Guarantee implements Serializable {

    @EmbeddedId
    private GuaranteeLetter guaranteeLetter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "PERSONS_ID_FK"))
    private Company company;

    private boolean complementary;

    @Enumerated(EnumType.STRING)
    @Column(name = "guarantee_letter_type")
    private GuaranteeLetterType guaranteeLetterType;

    @ManyToOne
    @JoinColumn(name = "abl", foreignKey = @ForeignKey(name = "TOPOS_ABL_FK"))
    private Topo topo;

    @OneToOne
    @JoinColumn(name = "document", foreignKey = @ForeignKey(name = "DOCUMENTS_ID_FK"))
    private Document document;

    public Guarantee() {}

    public Guarantee(GuaranteeLetter guaranteeLetter, Company company, boolean complementary,
	GuaranteeLetterType guaranteeLetterType, Topo topo) {
	this.guaranteeLetter = guaranteeLetter;
	this.company = company;
	this.complementary = complementary;
	this.guaranteeLetterType = guaranteeLetterType;
	this.topo = topo;
    }

    public GuaranteeLetter getGuaranteeLetter() {
	return guaranteeLetter;
    }

    public void setGuaranteeLetter(GuaranteeLetter guaranteeLetter) {
	this.guaranteeLetter = guaranteeLetter;
    }

    public Company getCompany() {
	return company;
    }

    public void setCompany(Company company) {
	this.company = company;
    }

    public boolean isComplementary() {
	return complementary;
    }

    public void setComplementary(boolean complementary) {
	this.complementary = complementary;
    }

    public GuaranteeLetterType getGuaranteeLetterType() {
	return guaranteeLetterType;
    }

    public void setGuaranteeLetterType(GuaranteeLetterType guaranteeLetterType) {
	this.guaranteeLetterType = guaranteeLetterType;
    }

    public Topo getTopo() {
	return topo;
    }

    public void setTopo(Topo topo) {
	this.topo = topo;
    }

    public Document getDocument() {
	return document;
    }

    public void setDocument(Document document) {
	this.document = document;
    }

    @Embeddable
    public static class GuaranteeLetter implements Serializable {

	@Column(scale = 2, precision = 2)
	private Double money;

	private String organization;

	@Column(name = "letter_number")
	private String letterNumber;


	public GuaranteeLetter() {}

	public GuaranteeLetter(Double money, String organization, String letterNumber) {
	    this.money = money;
	    this.organization = organization;
	    this.letterNumber = letterNumber;
	}



	public Double getMoney() {
	    return money;
	}

	public void setMoney(Double money) {
	    this.money = money;
	}

	public String getOrganization() {
	    return organization;
	}

	public void setOrganization(String organization) {
	    this.organization = organization;
	}

	public String getLetterNumber() {
	    return letterNumber;
	}

	public void setLetterNumber(String letterNumber) {
	    this.letterNumber = letterNumber;
	}

	@Override
	public boolean equals(Object o){
	    if(this == o){
	        return true;
	    }
	    if (o == null || getClass() != o.getClass()){
	        return false;
	    }
	    if(super.equals(o)){
	        return false;
	    }
	    GuaranteeLetter letter = (GuaranteeLetter) o;
	    return money == letter.money &&
		Objects.equals(organization,letter.organization) &&
		Objects.equals(letterNumber,letter.letterNumber);


	}

	@Override
	public int hashCode() {
	    return Objects.hash(super.hashCode(),money,organization,letterNumber);
	}
    }
}
