/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import com.cms.commons.util.QueryConstants;
import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "naturalCustomer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NaturalCustomer.findAll", query = "SELECT n FROM NaturalCustomer n"),
    @NamedQuery(name = "NaturalCustomer.findById", query = "SELECT n FROM NaturalCustomer n WHERE n.id = :id"),
    @NamedQuery(name = "NaturalCustomer.findByIdentificationNumber", query = "SELECT n FROM NaturalCustomer n WHERE n.identificationNumber = :identificationNumber"),
    @NamedQuery(name = "NaturalCustomer.findByDueDateDocumentIdentification", query = "SELECT n FROM NaturalCustomer n WHERE n.dueDateDocumentIdentification = :dueDateDocumentIdentification"),
    @NamedQuery(name = "NaturalCustomer.findByIndNaturalized", query = "SELECT n FROM NaturalCustomer n WHERE n.indNaturalized = :indNaturalized"),
    @NamedQuery(name = "NaturalCustomer.findByIdentificationNumberOld", query = "SELECT n FROM NaturalCustomer n WHERE n.identificationNumberOld = :identificationNumberOld"),
    @NamedQuery(name = "NaturalCustomer.findByIndForeign", query = "SELECT n FROM NaturalCustomer n WHERE n.indForeign = :indForeign"),
    @NamedQuery(name = "NaturalCustomer.findByCountryStayTime", query = "SELECT n FROM NaturalCustomer n WHERE n.countryStayTime = :countryStayTime"),
    @NamedQuery(name = "NaturalCustomer.findByFirstNames", query = "SELECT n FROM NaturalCustomer n WHERE n.firstNames = :firstNames"),
    @NamedQuery(name = "NaturalCustomer.findByLastNames", query = "SELECT n FROM NaturalCustomer n WHERE n.lastNames = :lastNames"),
    @NamedQuery(name = "NaturalCustomer.findByMarriedLastName", query = "SELECT n FROM NaturalCustomer n WHERE n.marriedLastName = :marriedLastName"),
    @NamedQuery(name = "NaturalCustomer.findByRifNumber", query = "SELECT n FROM NaturalCustomer n WHERE n.rifNumber = :rifNumber"),
    @NamedQuery(name = "NaturalCustomer.findByGender", query = "SELECT n FROM NaturalCustomer n WHERE n.gender = :gender"),
    @NamedQuery(name = "NaturalCustomer.findByPlaceBirth", query = "SELECT n FROM NaturalCustomer n WHERE n.placeBirth = :placeBirth"),
    @NamedQuery(name = "NaturalCustomer.findByDateBirth", query = "SELECT n FROM NaturalCustomer n WHERE n.dateBirth = :dateBirth"),
    @NamedQuery(name = "NaturalCustomer.findByFamilyResponsibilities", query = "SELECT n FROM NaturalCustomer n WHERE n.familyResponsibilities = :familyResponsibilities"),
    @NamedQuery(name = "NaturalCustomer.findByCreateDate", query = "SELECT n FROM NaturalCustomer n WHERE n.createDate = :createDate"),
    @NamedQuery(name = "NaturalCustomer.findByUpdatedate", query = "SELECT n FROM NaturalCustomer n WHERE n.updatedate = :updatedate"),
    @NamedQuery(name = QueryConstants.NATURAL_PERSON_BY_CUSTOMER, query = "SELECT n FROM NaturalCustomer n WHERE n.personId.id=:personId"),
    @NamedQuery(name = QueryConstants.NATURAL_CUSTOMER_BY_CARD_COMPLEMENTARIES, query = "SELECT n FROM NaturalCustomer n WHERE n.naturalCustomerId.id=:naturalCustomerId")})
public class NaturalCustomer extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 40)
    @Column(name = "identificationNumber")
    private String identificationNumber;
    @Column(name = "dueDateDocumentIdentification")
    @Temporal(TemporalType.DATE)
    private Date dueDateDocumentIdentification;
    @Column(name = "indNaturalized")
    private Boolean indNaturalized;
    @Size(max = 40)
    @Column(name = "identificationNumberOld")
    private String identificationNumberOld;
    @Column(name = "indForeign")
    private Boolean indForeign;
    @Column(name = "countryStayTime")
    private Integer countryStayTime;
    @Size(max = 40)
    @Column(name = "firstNames")
    private String firstNames;
    @Size(max = 40)
    @Column(name = "lastNames")
    private String lastNames;
    @Size(max = 40)
    @Column(name = "marriedLastName")
    private String marriedLastName;
    @Size(max = 10)
    @Column(name = "rifNumber")
    private String rifNumber;
    @Size(max = 1)
    @Column(name = "gender")
    private String gender;
    @Size(max = 45)
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
    @Column(name = "updatedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedate;
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "documentsPersonTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentsPersonType documentsPersonTypeId;
    @JoinColumn(name = "statusCustomerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusCustomer statusCustomerId;
    @JoinColumn(name = "civilStatusId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CivilStatus civilStatusId;
    @JoinColumn(name = "professionId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profession professionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "naturalCustomerId")
    private Collection<NaturalCustomer> naturalCustomerCollection;
    @JoinColumn(name = "naturalCustomerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NaturalCustomer naturalCustomerId;
    @JoinColumn(name = "kinShipApplicantId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private KinShipApplicant kinShipApplicantId;

    public NaturalCustomer() {
    }

    public NaturalCustomer(Long id) {
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

    public Boolean getIndNaturalized() {
        return indNaturalized;
    }

    public void setIndNaturalized(Boolean indNaturalized) {
        this.indNaturalized = indNaturalized;
    }

    public String getIdentificationNumberOld() {
        return identificationNumberOld;
    }

    public void setIdentificationNumberOld(String identificationNumberOld) {
        this.identificationNumberOld = identificationNumberOld;
    }

    public Boolean getIndForeign() {
        return indForeign;
    }

    public void setIndForeign(Boolean indForeign) {
        this.indForeign = indForeign;
    }

    public Integer getCountryStayTime() {
        return countryStayTime;
    }

    public void setCountryStayTime(Integer countryStayTime) {
        this.countryStayTime = countryStayTime;
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

    public String getRifNumber() {
        return rifNumber;
    }

    public void setRifNumber(String rifNumber) {
        this.rifNumber = rifNumber;
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

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public DocumentsPersonType getDocumentsPersonTypeId() {
        return documentsPersonTypeId;
    }

    public void setDocumentsPersonTypeId(DocumentsPersonType documentsPersonTypeId) {
        this.documentsPersonTypeId = documentsPersonTypeId;
    }

    public StatusCustomer getStatusCustomerId() {
        return statusCustomerId;
    }

    public void setStatusCustomerId(StatusCustomer statusCustomerId) {
        this.statusCustomerId = statusCustomerId;
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

    @XmlTransient
    @JsonIgnore
    public Collection<NaturalCustomer> getNaturalCustomerCollection() {
        return naturalCustomerCollection;
    }

    public void setNaturalCustomerCollection(Collection<NaturalCustomer> naturalCustomerCollection) {
        this.naturalCustomerCollection = naturalCustomerCollection;
    }

    public NaturalCustomer getNaturalCustomerId() {
        return naturalCustomerId;
    }

    public void setNaturalCustomerId(NaturalCustomer naturalCustomerId) {
        this.naturalCustomerId = naturalCustomerId;
    }

    public KinShipApplicant getKinShipApplicantId() {
        return kinShipApplicantId;
    }

    public void setKinShipApplicantId(KinShipApplicant kinShipApplicantId) {
        this.kinShipApplicantId = kinShipApplicantId;
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
        if (!(object instanceof NaturalCustomer)) {
            return false;
        }
        NaturalCustomer other = (NaturalCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.NaturalCustomer[ id=" + id + " ]";
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
