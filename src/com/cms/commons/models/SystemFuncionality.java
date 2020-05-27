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
@Table(name = "systemFuncionality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemFuncionality.findAll", query = "SELECT s FROM SystemFuncionality s")
    , @NamedQuery(name = "SystemFuncionality.findById", query = "SELECT s FROM SystemFuncionality s WHERE s.id = :id")
    , @NamedQuery(name = "SystemFuncionality.findByName", query = "SELECT s FROM SystemFuncionality s WHERE s.name = :name")})
public class SystemFuncionality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "languageId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Language languageId;
    @JoinColumn(name = "originApplicationId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OriginApplication originApplicationId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "systemFuncionalityId")
    private Collection<SystemFuncionalityHasSecurityQuestion> systemFuncionalityHasSecurityQuestionCollection;

    public SystemFuncionality() {
    }

    public SystemFuncionality(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
    }

    public OriginApplication getOriginApplicationId() {
        return originApplicationId;
    }

    public void setOriginApplicationId(OriginApplication originApplicationId) {
        this.originApplicationId = originApplicationId;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<SystemFuncionalityHasSecurityQuestion> getSystemFuncionalityHasSecurityQuestionCollection() {
        return systemFuncionalityHasSecurityQuestionCollection;
    }

    public void setSystemFuncionalityHasSecurityQuestionCollection(Collection<SystemFuncionalityHasSecurityQuestion> systemFuncionalityHasSecurityQuestionCollection) {
        this.systemFuncionalityHasSecurityQuestionCollection = systemFuncionalityHasSecurityQuestionCollection;
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
        if (!(object instanceof SystemFuncionality)) {
            return false;
        }
        SystemFuncionality other = (SystemFuncionality) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.SystemFuncionality[ id=" + id + " ]";
    }
    
}
