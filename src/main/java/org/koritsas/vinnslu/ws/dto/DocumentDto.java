package org.koritsas.vinnslu.ws.dto;

import java.io.File;
import java.util.Date;

public class DocumentDto {

    private Long id;

    private String reductor;

    private String organization;

    private String protocolNumber;

    private Date documentDate;

    private File file;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getReductor() { return reductor; }

    public void setReductor(String reductor) { this.reductor = reductor; }

    public String getOrganization() { return organization; }

    public void setOrganization(String organization) { this.organization = organization; }

    public String getProtocolNumber() { return protocolNumber; }

    public void setProtocolNumber(String protocolNumber) { this.protocolNumber = protocolNumber; }

    public Date getDocumentDate() { return documentDate; }

    public void setDocumentDate(Date documentDate) { this.documentDate = documentDate; }

    public File getFile() { return file; }

    public void setFile(File file) { this.file = file; }
}
