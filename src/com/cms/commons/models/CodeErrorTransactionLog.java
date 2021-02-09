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
@Table(name = "codeErrorTransactionLog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodeErrorTransactionLog.findAll", query = "SELECT c FROM CodeErrorTransactionLog c")
    , @NamedQuery(name = "CodeErrorTransactionLog.findById", query = "SELECT c FROM CodeErrorTransactionLog c WHERE c.id = :id")
    , @NamedQuery(name = "CodeErrorTransactionLog.findByDescription", query = "SELECT c FROM CodeErrorTransactionLog c WHERE c.description = :description")
    , @NamedQuery(name = "CodeErrorTransactionLog.findByCode", query = "SELECT c FROM CodeErrorTransactionLog c WHERE c.code = :code")})
public class CodeErrorTransactionLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "description")
    private String description;
    @Size(max = 50)
    @Column(name = "code")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeErrorTransactionLogId")
    private Collection<TransactionLog> transactionLogCollection;

    public CodeErrorTransactionLog() {
    }

    public CodeErrorTransactionLog(Integer id) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<TransactionLog> getTransactionLogCollection() {
        return transactionLogCollection;
    }

    public void setTransactionLogCollection(Collection<TransactionLog> transactionLogCollection) {
        this.transactionLogCollection = transactionLogCollection;
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
        if (!(object instanceof CodeErrorTransactionLog)) {
            return false;
        }
        CodeErrorTransactionLog other = (CodeErrorTransactionLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CodeErrorTransactionLog[ id=" + id + " ]";
    }
    
}
