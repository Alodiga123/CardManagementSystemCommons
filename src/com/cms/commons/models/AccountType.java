/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

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
@Table(name = "accountType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountType.findAll", query = "SELECT a FROM AccountType a")
    , @NamedQuery(name = "AccountType.findById", query = "SELECT a FROM AccountType a WHERE a.id = :id")
    , @NamedQuery(name = "AccountType.findByDescription", query = "SELECT a FROM AccountType a WHERE a.description = :description")})
public class AccountType implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountTypeId")
    private Collection<AccountTypeHasProductType> accountTypeHasProductTypeCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 40)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountTypeId")
    private Collection<AccountProperties> accountPropertiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountTypeId")
    private Collection<SubAccountType> subAccountTypeCollection;

    public AccountType() {
    }

    public AccountType(Integer id) {
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

    @XmlTransient
    @JsonIgnore
    public Collection<AccountProperties> getAccountPropertiesCollection() {
        return accountPropertiesCollection;
    }

    public void setAccountPropertiesCollection(Collection<AccountProperties> accountPropertiesCollection) {
        this.accountPropertiesCollection = accountPropertiesCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<SubAccountType> getSubAccountTypeCollection() {
        return subAccountTypeCollection;
    }

    public void setSubAccountTypeCollection(Collection<SubAccountType> subAccountTypeCollection) {
        this.subAccountTypeCollection = subAccountTypeCollection;
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
        if (!(object instanceof AccountType)) {
            return false;
        }
        AccountType other = (AccountType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.AccountType[ id=" + id + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<AccountTypeHasProductType> getAccountTypeHasProductTypeCollection() {
        return accountTypeHasProductTypeCollection;
    }

    public void setAccountTypeHasProductTypeCollection(Collection<AccountTypeHasProductType> accountTypeHasProductTypeCollection) {
        this.accountTypeHasProductTypeCollection = accountTypeHasProductTypeCollection;
    }
    
}
