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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "kinShipApplicant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KinShipApplicant.findAll", query = "SELECT k FROM KinShipApplicant k")
    , @NamedQuery(name = "KinShipApplicant.findById", query = "SELECT k FROM KinShipApplicant k WHERE k.id = :id")
    , @NamedQuery(name = "KinShipApplicant.findByDescription", query = "SELECT k FROM KinShipApplicant k WHERE k.description = :description")})
public class KinShipApplicant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kinShipApplicantId")
    private Collection<ApplicantNaturalPerson> applicantNaturalPersonCollection;

    public KinShipApplicant() {
    }

    public KinShipApplicant(Integer id) {
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

    @XmlTransient
    @JsonIgnore
    public Collection<ApplicantNaturalPerson> getApplicantNaturalPersonCollection() {
        return applicantNaturalPersonCollection;
    }

    public void setApplicantNaturalPersonCollection(Collection<ApplicantNaturalPerson> applicantNaturalPersonCollection) {
        this.applicantNaturalPersonCollection = applicantNaturalPersonCollection;
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
        if (!(object instanceof KinShipApplicant)) {
            return false;
        }
        KinShipApplicant other = (KinShipApplicant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.KinShipApplicant[ id=" + id + " ]";
    }
    
}
