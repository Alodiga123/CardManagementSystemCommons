/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import com.cms.commons.util.QueryConstants;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "documentsPersonType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentsPersonType.findAll", query = "SELECT d FROM DocumentsPersonType d"),
    @NamedQuery(name = "DocumentsPersonType.findById", query = "SELECT d FROM DocumentsPersonType d WHERE d.id = :id"),
    @NamedQuery(name = "DocumentsPersonType.findByDescription", query = "SELECT d FROM DocumentsPersonType d WHERE d.description = :description"),
    @NamedQuery(name = QueryConstants.DOCUMENTS_BY_COUNTRY, query = "SELECT d FROM DocumentsPersonType d INNER JOIN personType e ON d.personTypeId = e.personType.id INNER JOIN country f ON f.country.id = e.personType.countryId WHERE e.countryId.id=:countryId")})
public class DocumentsPersonType extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 80)
    @Column(name = "description")
    private String description;
    @Size(max = 10)
    @Column(name = "codeIdentificationNumber")
    private String codeIdentificationNumber;
    @JoinColumn(name = "personTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PersonType personTypeId;

    public DocumentsPersonType() {
    }

    public DocumentsPersonType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCodeIdentificationNumber() {
        return codeIdentificationNumber;
    }

    public void setCodeIdentificationNumber(String codeIdentificationNumber) {
        this.codeIdentificationNumber = codeIdentificationNumber;
    }

    public PersonType getPersonTypeId() {
        return personTypeId;
    }

    public void setPersonTypeId(PersonType personTypeId) {
        this.personTypeId = personTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentsPersonType)) {
            return false;
        }
        DocumentsPersonType other = (DocumentsPersonType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.DocumentsPersonType[ id=" + id + " ]";
    }

    @Override
    public Object getPk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
