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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "applicantNaturalPerson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApplicantNaturalPerson.findAll", query = "SELECT a FROM ApplicantNaturalPerson a"),
    @NamedQuery(name = "ApplicantNaturalPerson.findById", query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.id = :id"),
    @NamedQuery(name = "ApplicantNaturalPerson.findByIdentificationNumber", query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.identificationNumber = :identificationNumber"),
    @NamedQuery(name = "ApplicantNaturalPerson.findByDueDateDocumentIdentification", query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.dueDateDocumentIdentification = :dueDateDocumentIdentification"),
    @NamedQuery(name = "ApplicantNaturalPerson.findByIdentificationNumberOld", query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.identificationNumberOld = :identificationNumberOld"),
    @NamedQuery(name = "ApplicantNaturalPerson.findByFirstNames", query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.firstNames = :firstNames"),
    @NamedQuery(name = "ApplicantNaturalPerson.findByLastNames", query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.lastNames = :lastNames"),
    @NamedQuery(name = "ApplicantNaturalPerson.findByMarriedLastName", query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.marriedLastName = :marriedLastName"),
    @NamedQuery(name = "ApplicantNaturalPerson.findByGender", query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.gender = :gender"),
    @NamedQuery(name = "ApplicantNaturalPerson.findByPlaceBirth", query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.placeBirth = :placeBirth"),
    @NamedQuery(name = "ApplicantNaturalPerson.findByDateBirth", query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.dateBirth = :dateBirth"),
    @NamedQuery(name = "ApplicantNaturalPerson.findByFamilyResponsibilities", query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.familyResponsibilities = :familyResponsibilities"),
    @NamedQuery(name = "ApplicantNaturalPerson.findByCreateDate", query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.createDate = :createDate"),
    @NamedQuery(name = "ApplicantNaturalPerson.findByUpdateDate", query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.updateDate = :updateDate"),
    @NamedQuery(name = QueryConstants.CARD_COMPLEMENTARY_BY_APPLICANT, query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.applicantParentId.id=:applicantNaturalPersonId"),
    @NamedQuery(name = QueryConstants.APPLICANT_BY_REQUEST, query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.applicantParentId.id=:requestId AND a.statusApplicantId.id = :statusApplicantId"),
    @NamedQuery(name = QueryConstants.APPLICANT_BY_PERSON, query = "SELECT a FROM ApplicantNaturalPerson a WHERE a.personId.id=:personId")})

public class ApplicantNaturalPerson extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "identificationNumber")
    private String identificationNumber;
    @Column(name = "dueDateDocumentIdentification")
    @Temporal(TemporalType.DATE)
    private Date dueDateDocumentIdentification;
    @Column(name = "identificationNumberOld")
    private String identificationNumberOld;
    @Column(name = "firstNames")
    private String firstNames;
    @Column(name = "lastNames")
    private String lastNames;
    @Column(name = "marriedLastName")
    private String marriedLastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "placeBirth")
    private String placeBirth;
    @Column(name = "dateBirth")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;
    @Column(name = "familyResponsibilities")
    private Integer familyResponsibilities;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "civilStatusId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CivilStatus civilStatusId;
    @JoinColumn(name = "professionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profession professionId;
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personId;
    @OneToOne(mappedBy = "applicantParentId")
    private ApplicantNaturalPerson applicantNaturalPerson;
    @JoinColumn(name = "applicantParentId", referencedColumnName = "id")
    @OneToOne
    private ApplicantNaturalPerson applicantParentId;
    @JoinColumn(name = "kinShipApplicantId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private KinShipApplicant kinShipApplicantId;
    @JoinColumn(name = "documentsPersonTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentsPersonType documentsPersonTypeId;
    @JoinColumn(name = "statusApplicantId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusApplicant statusApplicantId;
    @Column(name = "recommendation")
    private Boolean recommendation;
    @Column(name = "promotion")
    private Boolean promotion;
    @Column(name = "citizen")
    private Boolean citizen;
    @Transient
    private Request request;

    public ApplicantNaturalPerson() {
    }

    public ApplicantNaturalPerson(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Date getDueDateDocumentIdentification() {
        return dueDateDocumentIdentification;
    }

    public void setDueDateDocumentIdentification(Date dueDateDocumentIdentification) {
        this.dueDateDocumentIdentification = dueDateDocumentIdentification;
    }

    public String getIdentificationNumberOld() {
        return identificationNumberOld;
    }

    public void setIdentificationNumberOld(String identificationNumberOld) {
        this.identificationNumberOld = identificationNumberOld;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getMarriedLastName() {
        return marriedLastName;
    }

    public void setMarriedLastName(String marriedLastName) {
        this.marriedLastName = marriedLastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlaceBirth() {
        return placeBirth;
    }

    public void setPlaceBirth(String placeBirth) {
        this.placeBirth = placeBirth;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Integer getFamilyResponsibilities() {
        return familyResponsibilities;
    }

    public void setFamilyResponsibilities(Integer familyResponsibilities) {
        this.familyResponsibilities = familyResponsibilities;
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

    public CivilStatus getCivilStatusId() {
        return civilStatusId;
    }

    public void setCivilStatusId(CivilStatus civilStatusId) {
        this.civilStatusId = civilStatusId;
    }

    public Profession getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Profession professionId) {
        this.professionId = professionId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public ApplicantNaturalPerson getApplicantNaturalPerson() {
        return applicantNaturalPerson;
    }

    public void setApplicantNaturalPerson(ApplicantNaturalPerson applicantNaturalPerson) {
        this.applicantNaturalPerson = applicantNaturalPerson;
    }

    public ApplicantNaturalPerson getApplicantParentId() {
        return applicantParentId;
    }

    public void setApplicantParentId(ApplicantNaturalPerson applicantParentId) {
        this.applicantParentId = applicantParentId;
    }

    public KinShipApplicant getKinShipApplicantId() {
        return kinShipApplicantId;
    }

    public void setKinShipApplicantId(KinShipApplicant kinShipApplicantId) {
        this.kinShipApplicantId = kinShipApplicantId;
    }

    public DocumentsPersonType getDocumentsPersonTypeId() {
        return documentsPersonTypeId;
    }

    public void setDocumentsPersonTypeId(DocumentsPersonType documentsPersonTypeId) {
        this.documentsPersonTypeId = documentsPersonTypeId;
    }

    public StatusApplicant getStatusApplicantId() {
        return statusApplicantId;
    }

    public void setStatusApplicantId(StatusApplicant statusApplicantId) {
        this.statusApplicantId = statusApplicantId;
    }

    public boolean isRecommendation() {
        return recommendation;
    }

    public void setRecommendation(boolean recommendation) {
        this.recommendation = recommendation;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public boolean isCitizen() {
        return citizen;
    }

    public void setCitizen(boolean citizen) {
        this.citizen = citizen;
    }
    
    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
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
        if (!(object instanceof ApplicantNaturalPerson)) {
            return false;
        }
        ApplicantNaturalPerson other = (ApplicantNaturalPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ApplicantNaturalPerson[ id=" + id + " ]";
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
