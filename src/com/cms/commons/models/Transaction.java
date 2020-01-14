/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")
    , @NamedQuery(name = "Transaction.findById", query = "SELECT t FROM Transaction t WHERE t.id = :id")
    , @NamedQuery(name = "Transaction.findByCode", query = "SELECT t FROM Transaction t WHERE t.code = :code")
    , @NamedQuery(name = "Transaction.findByDescription", query = "SELECT t FROM Transaction t WHERE t.description = :description")
    , @NamedQuery(name = "Transaction.findByIndMonetaryType", query = "SELECT t FROM Transaction t WHERE t.indMonetaryType = :indMonetaryType")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "code")
    private String code;
    @Size(max = 60)
    @Column(name = "description")
    private String description;
    @Column(name = "indMonetaryType")
    private Short indMonetaryType;
    @OneToMany(mappedBy = "transactionId")
    private Collection<ProductHasChannel> productHasChannelCollection;

    public Transaction() {
    }

    public Transaction(Integer id) {
        this.id = id;
    }

    public Transaction(Integer id, String code) {
        this.id = id;
        this.code = code;
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

    public Short getIndMonetaryType() {
        return indMonetaryType;
    }

    public void setIndMonetaryType(Short indMonetaryType) {
        this.indMonetaryType = indMonetaryType;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProductHasChannel> getProductHasChannelCollection() {
        return productHasChannelCollection;
    }

    public void setProductHasChannelCollection(Collection<ProductHasChannel> productHasChannelCollection) {
        this.productHasChannelCollection = productHasChannelCollection;
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
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.Transaction[ id=" + id + " ]";
    }
    
}