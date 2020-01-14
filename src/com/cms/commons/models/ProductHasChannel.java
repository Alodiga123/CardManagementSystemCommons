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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "productHasChannel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductHasChannel.findAll", query = "SELECT p FROM ProductHasChannel p")
    , @NamedQuery(name = "ProductHasChannel.findById", query = "SELECT p FROM ProductHasChannel p WHERE p.id = :id")})
public class ProductHasChannel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "transactionId", referencedColumnName = "id")
    @ManyToOne
    private Transaction transactionId;
    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Channel channelId;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Product productId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productHasChannelId")
    private Collection<ParameterProductHasChannel> parameterProductHasChannelCollection;

    public ProductHasChannel() {
    }

    public ProductHasChannel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transaction transactionId) {
        this.transactionId = transactionId;
    }

    public Channel getChannelId() {
        return channelId;
    }

    public void setChannelId(Channel channelId) {
        this.channelId = channelId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ParameterProductHasChannel> getParameterProductHasChannelCollection() {
        return parameterProductHasChannelCollection;
    }

    public void setParameterProductHasChannelCollection(Collection<ParameterProductHasChannel> parameterProductHasChannelCollection) {
        this.parameterProductHasChannelCollection = parameterProductHasChannelCollection;
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
        if (!(object instanceof ProductHasChannel)) {
            return false;
        }
        ProductHasChannel other = (ProductHasChannel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ProductHasChannel[ id=" + id + " ]";
    }
    
}
