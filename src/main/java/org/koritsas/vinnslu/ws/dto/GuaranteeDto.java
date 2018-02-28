package org.koritsas.vinnslu.ws.dto;

import org.koritsas.vinnslu.models.Company;
import org.koritsas.vinnslu.models.Document;
import org.koritsas.vinnslu.models.Guarantee;
import org.koritsas.vinnslu.models.Topo;
import org.koritsas.vinnslu.models.types.GuaranteeLetterType;

public class GuaranteeDto {

    private Guarantee.GuaranteeLetter guaranteeLetter;

    private Company company;

    private boolean complementary;

    private GuaranteeLetterType guaranteeLetterType;

    private Topo topo;

    private Document document;

    public Guarantee.GuaranteeLetter getGuaranteeLetter() { return guaranteeLetter; }

    public void setGuaranteeLetter(
	Guarantee.GuaranteeLetter guaranteeLetter) { this.guaranteeLetter = guaranteeLetter; }

    public Company getCompany() { return company; }

    public void setCompany(Company company) { this.company = company; }

    public boolean getComplementary() { return complementary; }

    public void setComplementary(boolean complementary) { this.complementary = complementary; }

    public GuaranteeLetterType getGuaranteeLetterType() { return guaranteeLetterType; }

    public void setGuaranteeLetterType(
	GuaranteeLetterType guaranteeLetterType) { this.guaranteeLetterType = guaranteeLetterType; }

    public Topo getTopo() { return topo; }

    public void setTopo(Topo topo) { this.topo = topo; }

    public Document getDocument() { return document; }

    public void setDocument(Document document) { this.document = document; }
}
