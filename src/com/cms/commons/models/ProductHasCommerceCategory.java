/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "productHasCommerceCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductHasCommerceCategory.findAll", query = "SELECT p FROM ProductHasCommerceCategory p")
    , @NamedQuery(name = "ProductHasCommerceCategory.findById", query = "SELECT p FROM ProductHasCommerceCategory p WHERE p.id = :id")})
public class ProductHasCommerceCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "commerceClassificationId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CommerceCategory commerceClassificationId;
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Product productId;

    public ProductHasCommerceCategory() {
    }

    public ProductHasCommerceCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CommerceCategory getCommerceClassificationId() {
        return commerceClassificationId;
    }

    public void setCommerceClassificationId(CommerceCategory commerceClassificationId) {
        this.commerceClassificationId = commerceClassificationId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
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
        if (!(object instanceof ProductHasCommerceCategory)) {
            return false;
        }
        ProductHasCommerceCategory other = (ProductHasCommerceCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ProductHasCommerceCategory[ id=" + id + " ]";
    }
    
}
