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
@Table(name = "programLoyalty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramLoyalty.findAll", query = "SELECT p FROM ProgramLoyalty p")
    , @NamedQuery(name = "ProgramLoyalty.findById", query = "SELECT p FROM ProgramLoyalty p WHERE p.id = :id")
    , @NamedQuery(name = "ProgramLoyalty.findByDescription", query = "SELECT p FROM ProgramLoyalty p WHERE p.description = :description")
    , @NamedQuery(name = "ProgramLoyalty.findByStartDate", query = "SELECT p FROM ProgramLoyalty p WHERE p.startDate = :startDate")
    , @NamedQuery(name = "ProgramLoyalty.findByEndDate", query = "SELECT p FROM ProgramLoyalty p WHERE p.endDate = :endDate")
    , @NamedQuery(name = "ProgramLoyalty.findByConversionRatePoints", query = "SELECT p FROM ProgramLoyalty p WHERE p.conversionRatePoints = :conversionRatePoints")
    , @NamedQuery(name = "ProgramLoyalty.findByObservations", query = "SELECT p FROM ProgramLoyalty p WHERE p.observations = :observations")
    , @NamedQuery(name = "ProgramLoyalty.findByActivationDate", query = "SELECT p FROM ProgramLoyalty p WHERE p.activationDate = :activationDate")
    , @NamedQuery(name = "ProgramLoyalty.findByIndActivation", query = "SELECT p FROM ProgramLoyalty p WHERE p.indActivation = :indActivation")
    , @NamedQuery(name = "ProgramLoyalty.findByCreateDate", query = "SELECT p FROM ProgramLoyalty p WHERE p.createDate = :createDate")
    , @NamedQuery(name = "ProgramLoyalty.findByUpdateDate", query = "SELECT p FROM ProgramLoyalty p WHERE p.updateDate = :updateDate")
    , @NamedQuery(name = "ProgramLoyalty.findByActivationObservations", query = "SELECT p FROM ProgramLoyalty p WHERE p.activationObservations = :activationObservations")})

public class ProgramLoyalty extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 1500)
    @Column(name = "description")
    private String description;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "conversionRatePoints")
    private Float conversionRatePoints;
    @Size(max = 1500)
    @Column(name = "observations")
    private String observations;
    @Column(name = "activationDate")
    @Temporal(TemporalType.DATE)
    private Date activationDate;
    @Column(name = "indActivation")
    private Boolean indActivation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Size(max = 1500)
    @Column(name = "activationObservations")
    private String activationObservations;
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "programId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Program programId;
    @JoinColumn(name = "programLoyaltyTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProgramLoyaltyType programLoyaltyTypeId;
    @JoinColumn(name = "statusProgramLoyaltyId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusProgramLoyalty statusProgramLoyaltyId;
    @JoinColumn(name = "userActivationId", referencedColumnName = "id")
    @ManyToOne
    private User userActivationId;

    public ProgramLoyalty() {
    }

    public ProgramLoyalty(Long id) {
        this.id = id;
    }

    public ProgramLoyalty(Long id, Date createDate) {
        this.id = id;
        this.createDate = createDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getConversionRatePoints() {
        return conversionRatePoints;
    }

    public void setConversionRatePoints(Float conversionRatePoints) {
        this.conversionRatePoints = conversionRatePoints;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Boolean getIndActivation() {
        return indActivation;
    }

    public void setIndActivation(Boolean indActivation) {
        this.indActivation = indActivation;
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

    public String getActivationObservations() {
        return activationObservations;
    }

    public void setActivationObservations(String activationObservations) {
        this.activationObservations = activationObservations;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public ProgramLoyaltyType getProgramLoyaltyTypeId() {
        return programLoyaltyTypeId;
    }

    public void setProgramLoyaltyTypeId(ProgramLoyaltyType programLoyaltyTypeId) {
        this.programLoyaltyTypeId = programLoyaltyTypeId;
    }

    public StatusProgramLoyalty getStatusProgramLoyaltyId() {
        return statusProgramLoyaltyId;
    }

    public void setStatusProgramLoyaltyId(StatusProgramLoyalty statusProgramLoyaltyId) {
        this.statusProgramLoyaltyId = statusProgramLoyaltyId;
    }

    public User getUserActivationId() {
        return userActivationId;
    }

    public void setUserActivationId(User userActivationId) {
        this.userActivationId = userActivationId;
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
        if (!(object instanceof ProgramLoyalty)) {
            return false;
        }
        ProgramLoyalty other = (ProgramLoyalty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ProgramLoyalty[ id=" + id + " ]";
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
