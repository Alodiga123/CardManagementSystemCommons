/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

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
@Table(name = "plasticCustomizingRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlasticCustomizingRequest.findAll", query = "SELECT p FROM PlasticCustomizingRequest p")
    , @NamedQuery(name = "PlasticCustomizingRequest.findById", query = "SELECT p FROM PlasticCustomizingRequest p WHERE p.id = :id")
    , @NamedQuery(name = "PlasticCustomizingRequest.findByRequestNumber", query = "SELECT p FROM PlasticCustomizingRequest p WHERE p.requestNumber = :requestNumber")
    , @NamedQuery(name = "PlasticCustomizingRequest.findByRequestDate", query = "SELECT p FROM PlasticCustomizingRequest p WHERE p.requestDate = :requestDate")
    , @NamedQuery(name = "PlasticCustomizingRequest.findByCreateDate", query = "SELECT p FROM PlasticCustomizingRequest p WHERE p.createDate = :createDate")
    , @NamedQuery(name = "PlasticCustomizingRequest.findByUpdateDate", query = "SELECT p FROM PlasticCustomizingRequest p WHERE p.updateDate = :updateDate")})
public class PlasticCustomizingRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 40)
    @Column(name = "requestNumber")
    private String requestNumber;
    @Column(name = "requestDate")
    @Temporal(TemporalType.DATE)
    private Date requestDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "plasticManufacturerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlasticManufacturer plasticManufacturerId;
    @JoinColumn(name = "statusPlasticCustomizingRequestId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusPlasticCustomizingRequest statusPlasticCustomizingRequestId;
    @JoinColumn(name = "programId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Program programId;

    public PlasticCustomizingRequest() {
    }

    public PlasticCustomizingRequest(Long id) {
        this.id = id;
    }

    public PlasticCustomizingRequest(Long id, Date createDate) {
        this.id = id;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
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

    public PlasticManufacturer getPlasticManufacturerId() {
        return plasticManufacturerId;
    }

    public void setPlasticManufacturerId(PlasticManufacturer plasticManufacturerId) {
        this.plasticManufacturerId = plasticManufacturerId;
    }

    public StatusPlasticCustomizingRequest getStatusPlasticCustomizingRequestId() {
        return statusPlasticCustomizingRequestId;
    }

    public void setStatusPlasticCustomizingRequestId(StatusPlasticCustomizingRequest statusPlasticCustomizingRequestId) {
        this.statusPlasticCustomizingRequestId = statusPlasticCustomizingRequestId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
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
        if (!(object instanceof PlasticCustomizingRequest)) {
            return false;
        }
        PlasticCustomizingRequest other = (PlasticCustomizingRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.PlasticCustomizingRequest[ id=" + id + " ]";
    }
    
}
