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
import javax.persistence.OneToOne;
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
@Table(name = "request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r"),
    @NamedQuery(name = "Request.findById", query = "SELECT r FROM Request r WHERE r.id = :id"),
    @NamedQuery(name = "Request.findByRequestNumber", query = "SELECT r FROM Request r WHERE r.requestNumber = :requestNumber"),
    @NamedQuery(name = "Request.findByRequestDate", query = "SELECT r FROM Request r WHERE r.requestDate = :requestDate"),
    @NamedQuery(name = QueryConstants.STATUS_REQUEST, query = "SELECT r FROM Request r WHERE r.statusRequestId.id=:statusRequestId")})
public class Request extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 20)
    @Column(name = "requestNumber")
    private String requestNumber;
    @Column(name = "requestDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @JoinColumn(name = "personTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PersonType personTypeId;
    @JoinColumn(name = "statusRequestId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusRequest statusRequestId;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "productTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductType productTypeId;
    @JoinColumn(name = "programId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Program programId;
    @JoinColumn(name = "requestTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RequestType requestTypeId;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne
    private User userId;
    @JoinColumn(name = "reasonRejectionRequestId", referencedColumnName = "id")
    @ManyToOne
    private ReasonRejectionRequest reasonRejectionRequestId;
    @JoinColumn(name = "personCustomerId", referencedColumnName = "id")
    @ManyToOne
    private Person personCustomerId;
    @Column(name = "indPersonNaturalRequest")
    private Boolean indPersonNaturalRequest;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Request() {
    }

    public Request(Long id) {
        this.id = id;
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

    public PersonType getPersonTypeId() {
        return personTypeId;
    }

    public void setPersonTypeId(PersonType personTypeId) {
        this.personTypeId = personTypeId;
    }

    public StatusRequest getStatusRequestId() {
        return statusRequestId;
    }

    public void setStatusRequestId(StatusRequest statusRequestId) {
        this.statusRequestId = statusRequestId;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public ProductType getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(ProductType productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public RequestType getRequestTypeId() {
        return requestTypeId;
    }

    public void setRequestTypeId(RequestType requestTypeId) {
        this.requestTypeId = requestTypeId;
    }

    public Person getPersonCustomerId() {
        return personCustomerId;
    }

    public void setPersonCustomerId(Person personCustomerId) {
        this.personCustomerId = personCustomerId;
    }

    public ReasonRejectionRequest getReasonRejectionRequestId() {
        return reasonRejectionRequestId;
    }

    public void setReasonRejectionRequestId(ReasonRejectionRequest reasonRejectionRequestId) {
        this.reasonRejectionRequestId = reasonRejectionRequestId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Boolean getIndPersonNaturalRequest() {
        return indPersonNaturalRequest;
    }

    public void setIndPersonNaturalRequest(Boolean indPersonNaturalRequest) {
        this.indPersonNaturalRequest = indPersonNaturalRequest;
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.Request[ id=" + id + " ]";
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
