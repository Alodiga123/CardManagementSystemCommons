/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.cms.commons.util.QueryConstants;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yalmea
 */
@Entity
@Table(name = "accountTypeHasProductType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountTypeHasProductType.findAll", query = "SELECT a FROM AccountTypeHasProductType a"),
    @NamedQuery(name = "AccountTypeHasProductType.findById", query = "SELECT a FROM AccountTypeHasProductType a WHERE a.id = :id"),
    @NamedQuery(name = QueryConstants.ACCOUNT_TYPE_HAS_PRODUCT_TYPE_BY_PRODUCT_TYPE, query = "SELECT a FROM AccountTypeHasProductType a WHERE a.productTypeId.id=:productTypeId")})
public class AccountTypeHasProductType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "productTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductType productTypeId;
    @JoinColumn(name = "accountTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountType accountTypeId;

    public AccountTypeHasProductType() {
    }

    public AccountTypeHasProductType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductType getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(ProductType productTypeId) {
        this.productTypeId = productTypeId;
    }

    public AccountType getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountTypeId = accountTypeId;
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
        if (!(object instanceof AccountTypeHasProductType)) {
            return false;
        }
        AccountTypeHasProductType other = (AccountTypeHasProductType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.AccountTypeHasProductType[ id=" + id + " ]";
    }
    
}
