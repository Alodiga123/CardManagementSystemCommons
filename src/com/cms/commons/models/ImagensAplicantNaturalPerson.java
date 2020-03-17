package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import com.cms.commons.util.QueryConstants;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
 *
 * @author jose
 */
@Entity
@Table(name = "imagensaplicantnaturalperson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImagensAplicantNaturalPerson.findAll", query = "SELECT i FROM ImagensAplicantNaturalPerson i"),
    @NamedQuery(name = "ImagensAplicantNaturalPerson.findById", query = "SELECT i FROM ImagensAplicantNaturalPerson i WHERE i.id = :id"),
    @NamedQuery(name = "ImagensAplicantNaturalPerson.findByUrlImageFile", query = "SELECT i FROM ImagensAplicantNaturalPerson i WHERE i.urlImageFile = :urlImageFile"),
    @NamedQuery(name = QueryConstants.IMAGENS_BY_APPLICANT, query = "SELECT i FROM ImagensAplicantNaturalPerson i WHERE i.applicantNaturalPersonId.id=:applicantNaturalPersonId")})

public class ImagensAplicantNaturalPerson extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 250)
    @Column(name = "urlImageFile")
    private String urlImageFile;
    @JoinColumn(name = "applicantNaturalPersonId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ApplicantNaturalPerson applicantNaturalPersonId;
    @Size(max = 1500)
    @Column(name = "observations")
    private String observations;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public ImagensAplicantNaturalPerson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlImageFile() {
        return urlImageFile;
    }

    public void setUrlImageFile(String urlImageFile) {
        this.urlImageFile = urlImageFile;
    }

    public ApplicantNaturalPerson getApplicantNaturalPersonId() {
        return applicantNaturalPersonId;
    }

    public void setApplicantNaturalPersonId(ApplicantNaturalPerson applicantNaturalPersonId) {
        this.applicantNaturalPersonId = applicantNaturalPersonId;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
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
        if (!(object instanceof ImagensAplicantNaturalPerson)) {
            return false;
        }
        ImagensAplicantNaturalPerson other = (ImagensAplicantNaturalPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
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

    @Override
    public String toString() {
        return "com.cms.commons.models.ImagensAplicantNaturalPerson[ id=" + id + " ]";
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

