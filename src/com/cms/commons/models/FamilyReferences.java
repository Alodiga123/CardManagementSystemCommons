package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import java.io.Serializable;
import com.cms.commons.util.QueryConstants;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "familyReferences")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamilyReferences.findAll", query = "SELECT f FROM FamilyReferences f"),
    @NamedQuery(name = "FamilyReferences.findById", query = "SELECT f FROM FamilyReferences f WHERE f.id = :id"),
    @NamedQuery(name = QueryConstants.FAMILY_REFERENCES_BY_APPLICANT, query = "SELECT f FROM FamilyReferences f WHERE f.applicantNaturalPersonId.id=:applicantNaturalPersonId"),
    @NamedQuery(name = QueryConstants.FAMILY_REFERENCES_BY_CUSTOMER, query = "SELECT f FROM FamilyReferences f WHERE f.naturalCustomerId.id=:naturalCustomerId")})
public class FamilyReferences extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstNames")
    private String firstNames;
    @Size(max = 40)
    @Column(name = "lastNames")
    private String lastNames;
    @Size(max = 40)
    @Column(name = "city")
    private String city;
    @Size(max = 30)
    @Column(name = "localPhone")
    private String localPhone;
    @Size(max = 30)
    @Column(name = "cellPhone")
    private String cellPhone;
    @JoinColumn(name = "applicantNaturalPersonId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ApplicantNaturalPerson applicantNaturalPersonId;
    @JoinColumn(name = "naturalCustomerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NaturalCustomer naturalCustomerId;

    public FamilyReferences() {
    }

    public FamilyReferences(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalPhone() {
        return localPhone;
    }

    public void setLocalPhone(String localPhone) {
        this.localPhone = localPhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public ApplicantNaturalPerson getApplicantNaturalPersonId() {
        return applicantNaturalPersonId;
    }

    public void setApplicantNaturalPersonId(ApplicantNaturalPerson applicantNaturalPersonId) {
        this.applicantNaturalPersonId = applicantNaturalPersonId;
    }

    public NaturalCustomer getNaturalCustomerId() {
        return naturalCustomerId;
    }

    public void setNaturalCustomerId(NaturalCustomer naturalCustomerId) {
        this.naturalCustomerId = naturalCustomerId;
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
        if (!(object instanceof FamilyReferences)) {
            return false;
        }
        FamilyReferences other = (FamilyReferences) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.FamilyReferences[ id=" + id + " ]";
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
