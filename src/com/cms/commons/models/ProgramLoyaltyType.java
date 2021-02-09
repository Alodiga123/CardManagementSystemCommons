/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
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
@Table(name = "programLoyaltyType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramLoyaltyType.findAll", query = "SELECT p FROM ProgramLoyaltyType p"),
    @NamedQuery(name = "ProgramLoyaltyType.findById", query = "SELECT p FROM ProgramLoyaltyType p WHERE p.id = :id"),
    @NamedQuery(name = "ProgramLoyaltyType.findByName", query = "SELECT p FROM ProgramLoyaltyType p WHERE p.name = :name")})
public class ProgramLoyaltyType extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 40)
    @Column(name = "name")
    private String name;
    @Size(max = 5)
    @Column(name = "code")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programLoyaltyTypeId")
    private Collection<ProgramLoyalty> programLoyaltyCollection;

    public ProgramLoyaltyType() {
    }

    public ProgramLoyaltyType(Integer id) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProgramLoyalty> getProgramLoyaltyCollection() {
        return programLoyaltyCollection;
    }

    public void setProgramLoyaltyCollection(Collection<ProgramLoyalty> programLoyaltyCollection) {
        this.programLoyaltyCollection = programLoyaltyCollection;
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
        if (!(object instanceof ProgramLoyaltyType)) {
            return false;
        }
        ProgramLoyaltyType other = (ProgramLoyaltyType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ProgramLoyaltyType[ id=" + id + " ]";
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
