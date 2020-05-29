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
@Table(name = "systemFuncionalityHasSecurityQuestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemFuncionalityHasSecurityQuestion.findAll", query = "SELECT s FROM SystemFuncionalityHasSecurityQuestion s")
    , @NamedQuery(name = "SystemFuncionalityHasSecurityQuestion.findById", query = "SELECT s FROM SystemFuncionalityHasSecurityQuestion s WHERE s.id = :id")
    , @NamedQuery(name = "SystemFuncionalityHasSecurityQuestion.findByCreateDate", query = "SELECT s FROM SystemFuncionalityHasSecurityQuestion s WHERE s.createDate = :createDate")
    , @NamedQuery(name = "SystemFuncionalityHasSecurityQuestion.findByUpdateDate", query = "SELECT s FROM SystemFuncionalityHasSecurityQuestion s WHERE s.updateDate = :updateDate")})
public class SystemFuncionalityHasSecurityQuestion extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "systemFuncionalityId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SystemFuncionality systemFuncionalityId;
    @JoinColumn(name = "securityQuestionId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private SecurityQuestion securityQuestionId;

    public SystemFuncionalityHasSecurityQuestion() {
    }

    public SystemFuncionalityHasSecurityQuestion(Long id) {
        this.id = id;
    }

    public SystemFuncionalityHasSecurityQuestion(Long id, Date createDate) {
        this.id = id;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public SystemFuncionality getSystemFuncionalityId() {
        return systemFuncionalityId;
    }

    public void setSystemFuncionalityId(SystemFuncionality systemFuncionalityId) {
        this.systemFuncionalityId = systemFuncionalityId;
    }

    public SecurityQuestion getSecurityQuestionId() {
        return securityQuestionId;
    }

    public void setSecurityQuestionId(SecurityQuestion securityQuestionId) {
        this.securityQuestionId = securityQuestionId;
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
        if (!(object instanceof SystemFuncionalityHasSecurityQuestion)) {
            return false;
        }
        SystemFuncionalityHasSecurityQuestion other = (SystemFuncionalityHasSecurityQuestion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.SystemFuncionalityHasSecurityQuestion[ id=" + id + " ]";
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
