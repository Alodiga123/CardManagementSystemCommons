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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "accountSegment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountSegment.findAll", query = "SELECT a FROM AccountSegment a"),
    @NamedQuery(name = "AccountSegment.findById", query = "SELECT a FROM AccountSegment a WHERE a.id = :id"),
    @NamedQuery(name = "AccountSegment.findByDescription", query = "SELECT a FROM AccountSegment a WHERE a.description = :description"),
    @NamedQuery(name = "AccountSegment.findByLenghtSegment", query = "SELECT a FROM AccountSegment a WHERE a.lenghtSegment = :lenghtSegment"),
    @NamedQuery(name = QueryConstants.ACCOUNT_SEGMENT_BY_ACCOUNT_PROPERTIES, query = "SELECT a FROM AccountSegment a WHERE a.accountPropertiesId.id = :accountPropertiesId")})

public class AccountSegment extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 50)
    @Column(name = "description")
    private String description;
    @Column(name = "lenghtSegment")
    private Integer lenghtSegment;
    @JoinColumn(name = "accountPropertiesId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountProperties accountPropertiesId;

    public AccountSegment() {
    }

    public AccountSegment(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLenghtSegment() {
        return lenghtSegment;
    }

    public void setLenghtSegment(Integer lenghtSegment) {
        this.lenghtSegment = lenghtSegment;
    }

    public AccountProperties getAccountPropertiesId() {
        return accountPropertiesId;
    }

    public void setAccountPropertiesId(AccountProperties accountPropertiesId) {
        this.accountPropertiesId = accountPropertiesId;
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
        if (!(object instanceof AccountSegment)) {
            return false;
        }
        AccountSegment other = (AccountSegment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.AccountSegment[ id=" + id + " ]";
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
