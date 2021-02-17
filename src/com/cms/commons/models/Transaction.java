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
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "transaction")
@XmlType(name = "cms_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t"),
    @NamedQuery(name = "Transaction.findById", query = "SELECT t FROM Transaction t WHERE t.id = :id"),
    @NamedQuery(name = "Transaction.findByCode", query = "SELECT t FROM Transaction t WHERE t.code = :code"),
    @NamedQuery(name = "Transaction.findByDescription", query = "SELECT t FROM Transaction t WHERE t.description = :description"),
    @NamedQuery(name = "Transaction.findByIndMonetaryType", query = "SELECT t FROM Transaction t WHERE t.indMonetaryType = :indMonetaryType"),
    @NamedQuery(name = "Transaction.findByIndTransactionPurchase", query = "SELECT t FROM Transaction t WHERE t.indTransactionPurchase = :indTransactionPurchase"),
    @NamedQuery(name = "Transaction.findByIndVariationRateChannel", query = "SELECT t FROM Transaction t WHERE t.indVariationRateChannel = :indVariationRateChannel"),
    @NamedQuery(name = QueryConstants.TRANSACTION_BY_CODE, query = "SELECT t FROM Transaction t WHERE t.code = :code"),})
public class Transaction extends AbstractDistributionEntity implements Serializable {

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
    private Boolean indMonetaryType;
    @Column(name = "indTransactionPurchase")
    private Boolean indTransactionPurchase;
    @Column(name = "indVariationRateChannel")
    private Boolean indVariationRateChannel;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "subTypeTransactionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubTypeTransaction subTypeTransactionId;

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

    public Boolean getIndMonetaryType() {
        return indMonetaryType;
    }

    public void setIndMonetaryType(Boolean indMonetaryType) {
        this.indMonetaryType = indMonetaryType;
    }

    public Boolean getIndTransactionPurchase() {
        return indTransactionPurchase;
    }

    public void setIndTransactionPurchase(Boolean indTransactionPurchase) {
        this.indTransactionPurchase = indTransactionPurchase;
    }

    public Boolean getIndVariationRateChannel() {
        return indVariationRateChannel;
    }

    public void setIndVariationRateChannel(Boolean indVariationRateChannel) {
        this.indVariationRateChannel = indVariationRateChannel;
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

    @Override
    public Object getPk() {
        return getId();
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
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

    public SubTypeTransaction getSubTypeTransactionId() {
        return subTypeTransactionId;
    }

    public void setSubTypeTransactionId(SubTypeTransaction subTypeTransactionId) {
        this.subTypeTransactionId = subTypeTransactionId;
    }

}
