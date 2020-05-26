/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "securityQuestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecurityQuestion.findAll", query = "SELECT s FROM SecurityQuestion s")
    , @NamedQuery(name = "SecurityQuestion.findById", query = "SELECT s FROM SecurityQuestion s WHERE s.id = :id")
    , @NamedQuery(name = "SecurityQuestion.findBySecurityQuestion", query = "SELECT s FROM SecurityQuestion s WHERE s.securityQuestion = :securityQuestion")
    , @NamedQuery(name = "SecurityQuestion.findByCreateDate", query = "SELECT s FROM SecurityQuestion s WHERE s.createDate = :createDate")
    , @NamedQuery(name = "SecurityQuestion.findByUpdateDate", query = "SELECT s FROM SecurityQuestion s WHERE s.updateDate = :updateDate")})
public class SecurityQuestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 250)
    @Column(name = "securityQuestion")
    private String securityQuestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "languageId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Language languageId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "securityQuestionId")
    private SystemFuncionalityHasSecurityQuestion systemFuncionalityHasSecurityQuestion;

    public SecurityQuestion() {
    }

    public SecurityQuestion(Long id) {
        this.id = id;
    }

    public SecurityQuestion(Long id, Date createDate) {
        this.id = id;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
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

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
    }

    public SystemFuncionalityHasSecurityQuestion getSystemFuncionalityHasSecurityQuestion() {
        return systemFuncionalityHasSecurityQuestion;
    }

    public void setSystemFuncionalityHasSecurityQuestion(SystemFuncionalityHasSecurityQuestion systemFuncionalityHasSecurityQuestion) {
        this.systemFuncionalityHasSecurityQuestion = systemFuncionalityHasSecurityQuestion;
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
        if (!(object instanceof SecurityQuestion)) {
            return false;
        }
        SecurityQuestion other = (SecurityQuestion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.SecurityQuestion[ id=" + id + " ]";
    }
    
}
