/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "keyProperties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KeyProperties.findAll", query = "SELECT k FROM KeyProperties k")
    , @NamedQuery(name = "KeyProperties.findById", query = "SELECT k FROM KeyProperties k WHERE k.id = :id")
    , @NamedQuery(name = "KeyProperties.findByKeyLength", query = "SELECT k FROM KeyProperties k WHERE k.keyLength = :keyLength")
    , @NamedQuery(name = "KeyProperties.findByExpirationDays", query = "SELECT k FROM KeyProperties k WHERE k.expirationDays = :expirationDays")
    , @NamedQuery(name = "KeyProperties.findByTotalPreviousKeys", query = "SELECT k FROM KeyProperties k WHERE k.totalPreviousKeys = :totalPreviousKeys")
    , @NamedQuery(name = "KeyProperties.findByTotalNumericCharacters", query = "SELECT k FROM KeyProperties k WHERE k.totalNumericCharacters = :totalNumericCharacters")
    , @NamedQuery(name = "KeyProperties.findByIndConsecutiveEqualCharacters", query = "SELECT k FROM KeyProperties k WHERE k.indConsecutiveEqualCharacters = :indConsecutiveEqualCharacters")
    , @NamedQuery(name = "KeyProperties.findByIndContinuousCharacters", query = "SELECT k FROM KeyProperties k WHERE k.indContinuousCharacters = :indContinuousCharacters")
    , @NamedQuery(name = "KeyProperties.findByCreateDate", query = "SELECT k FROM KeyProperties k WHERE k.createDate = :createDate")
    , @NamedQuery(name = "KeyProperties.findByUpdateDate", query = "SELECT k FROM KeyProperties k WHERE k.updateDate = :updateDate")})
public class KeyProperties extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "keyLength")
    private Integer keyLength;
    @Column(name = "expirationDays")
    private Integer expirationDays;
    @Column(name = "totalPreviousKeys")
    private Integer totalPreviousKeys;
    @Column(name = "totalNumericCharacters")
    private Integer totalNumericCharacters;
    @Column(name = "indConsecutiveEqualCharacters")
    private Boolean indConsecutiveEqualCharacters;
    @Column(name = "indContinuousCharacters")
    private Boolean indContinuousCharacters;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "channelId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Channel channelId;
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Product productId;

    public KeyProperties() {
    }

    public KeyProperties(Long id) {
        this.id = id;
    }

    public KeyProperties(Long id, Date createDate) {
        this.id = id;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKeyLength() {
        return keyLength;
    }

    public void setKeyLength(Integer keyLength) {
        this.keyLength = keyLength;
    }

    public Integer getExpirationDays() {
        return expirationDays;
    }

    public void setExpirationDays(Integer expirationDays) {
        this.expirationDays = expirationDays;
    }

    public Integer getTotalPreviousKeys() {
        return totalPreviousKeys;
    }

    public void setTotalPreviousKeys(Integer totalPreviousKeys) {
        this.totalPreviousKeys = totalPreviousKeys;
    }

    public Integer getTotalNumericCharacters() {
        return totalNumericCharacters;
    }

    public void setTotalNumericCharacters(Integer totalNumericCharacters) {
        this.totalNumericCharacters = totalNumericCharacters;
    }

    public Boolean getIndConsecutiveEqualCharacters() {
        return indConsecutiveEqualCharacters;
    }

    public void setIndConsecutiveEqualCharacters(Boolean indConsecutiveEqualCharacters) {
        this.indConsecutiveEqualCharacters = indConsecutiveEqualCharacters;
    }

    public Boolean getIndContinuousCharacters() {
        return indContinuousCharacters;
    }

    public void setIndContinuousCharacters(Boolean indContinuousCharacters) {
        this.indContinuousCharacters = indContinuousCharacters;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KeyProperties)) {
            return false;
        }
        KeyProperties other = (KeyProperties) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.KeyProperties[ id=" + id + " ]";
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
