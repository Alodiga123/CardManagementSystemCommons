/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "cardRequestType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardRequestType.findAll", query = "SELECT c FROM CardRequestType c"), 
    @NamedQuery(name = "CardRequestType.findById", query = "SELECT c FROM CardRequestType c WHERE c.id = :id"),
    @NamedQuery(name = "CardRequestType.findByCode", query = "SELECT c FROM CardRequestType c WHERE c.code = :code"),
    @NamedQuery(name = "CardRequestType.findByDescription", query = "SELECT c FROM CardRequestType c WHERE c.description = :description")})
public class CardRequestType extends AbstractDistributionEntity implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardRequestTypeId")
    private Collection<RequestType> requestTypeCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "code")
    private String code;
    @Size(max = 50)
    @Column(name = "description")
    private String description;

    public CardRequestType() {
    }

    public CardRequestType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof CardRequestType)) {
            return false;
        }
        CardRequestType other = (CardRequestType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CardRequestType[ id=" + id + " ]";
    }

    @Override
    public Object getPk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @XmlTransient
    @JsonIgnore
    public Collection<RequestType> getRequestTypeCollection() {
        return requestTypeCollection;
    }

    public void setRequestTypeCollection(Collection<RequestType> requestTypeCollection) {
        this.requestTypeCollection = requestTypeCollection;
    }

}
