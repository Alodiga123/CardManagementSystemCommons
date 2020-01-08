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
@Table(name = "collectionsRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CollectionsRequest.findAll", query = "SELECT c FROM CollectionsRequest c"), 
    @NamedQuery(name = "CollectionsRequest.findById", query = "SELECT c FROM CollectionsRequest c WHERE c.id = :id"),
    @NamedQuery(name = QueryConstants.REQUEST_BY_COLLECTIONS, query = "SELECT c FROM Request r, CollectionsRequest c WHERE r.countryId.id=c.countryId.id AND r.productTypeId.id=c.productTypeId.id AND r.personTypeId.id=c.personTypeId.id AND r.programId.id=c.programId.id")})

public class CollectionsRequest extends AbstractDistributionEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;
    @JoinColumn(name = "productTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductType productTypeId;
    @JoinColumn(name = "programId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Program programId;
    @JoinColumn(name = "personTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PersonType personTypeId;
    @JoinColumn(name = "collectionTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CollectionType collectionTypeId;

    public CollectionsRequest() {
    }

    public CollectionsRequest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public CollectionType getCollectionTypeId() {
        return collectionTypeId;
    }

    public void setCollectionTypeId(CollectionType collectionTypeId) {
        this.collectionTypeId = collectionTypeId;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public ProductType getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(ProductType productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
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
        if (!(object instanceof CollectionsRequest)) {
            return false;
        }
        CollectionsRequest other = (CollectionsRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CollectionsRequest[ id=" + id + " ]";
    }
    
    @Override
    public Object getPk() {
        return getId();
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
    }
    
}
