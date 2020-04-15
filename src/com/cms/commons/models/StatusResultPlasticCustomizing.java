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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "statusResultPlasticCustomizing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusResultPlasticCustomizing.findAll", query = "SELECT s FROM StatusResultPlasticCustomizing s")
    , @NamedQuery(name = "StatusResultPlasticCustomizing.findById", query = "SELECT s FROM StatusResultPlasticCustomizing s WHERE s.id = :id")
    , @NamedQuery(name = "StatusResultPlasticCustomizing.findByDescription", query = "SELECT s FROM StatusResultPlasticCustomizing s WHERE s.description = :description")})
public class StatusResultPlasticCustomizing implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "plasticManufacturerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlasticManufacturer plasticManufacturerId;
    @JoinColumn(name = "statusPlasticCustomizingRequestd", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusPlasticCustomizingRequest statusPlasticCustomizingRequestd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusResultPlasticCustomizingId")
    private Collection<ResultPlasticCustomizingRequest> resultPlasticCustomizingRequestCollection;

    public StatusResultPlasticCustomizing() {
    }

    public StatusResultPlasticCustomizing(Integer id) {
        this.id = id;
    }

    public StatusResultPlasticCustomizing(Integer id, String description) {
        this.id = id;
        this.description = description;
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

    public PlasticManufacturer getPlasticManufacturerId() {
        return plasticManufacturerId;
    }

    public void setPlasticManufacturerId(PlasticManufacturer plasticManufacturerId) {
        this.plasticManufacturerId = plasticManufacturerId;
    }

    public StatusPlasticCustomizingRequest getStatusPlasticCustomizingRequestd() {
        return statusPlasticCustomizingRequestd;
    }

    public void setStatusPlasticCustomizingRequestd(StatusPlasticCustomizingRequest statusPlasticCustomizingRequestd) {
        this.statusPlasticCustomizingRequestd = statusPlasticCustomizingRequestd;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ResultPlasticCustomizingRequest> getResultPlasticCustomizingRequestCollection() {
        return resultPlasticCustomizingRequestCollection;
    }

    public void setResultPlasticCustomizingRequestCollection(Collection<ResultPlasticCustomizingRequest> resultPlasticCustomizingRequestCollection) {
        this.resultPlasticCustomizingRequestCollection = resultPlasticCustomizingRequestCollection;
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
        if (!(object instanceof StatusResultPlasticCustomizing)) {
            return false;
        }
        StatusResultPlasticCustomizing other = (StatusResultPlasticCustomizing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.StatusResultPlasticCustomizing[ id=" + id + " ]";
    }
    
}
