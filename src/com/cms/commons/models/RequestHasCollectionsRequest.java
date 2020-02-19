package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import com.cms.commons.util.QueryConstants;
import java.io.Serializable;
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

/*
 *
 * @author jose
 */
@Entity
@Table(name = "requestHasCollectionsRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestHasCollectionsRequest.findAll", query = "SELECT r FROM RequestHasCollectionsRequest r"),
    @NamedQuery(name = "RequestHasCollectionsRequest.findById", query = "SELECT r FROM RequestHasCollectionsRequest r WHERE r.id = :id"),
    @NamedQuery(name = "RequestHasCollectionsRequest.findByIndApproved", query = "SELECT r FROM RequestHasCollectionsRequest r WHERE r.indApproved = :indApproved"),
    @NamedQuery(name = "RequestHasCollectionsRequest.findByObservations", query = "SELECT r FROM RequestHasCollectionsRequest r WHERE r.observations = :observations"),
    @NamedQuery(name = "RequestHasCollectionsRequest.findByUrlImageFile", query = "SELECT r FROM RequestHasCollectionsRequest r WHERE r.urlImageFile = :urlImageFile"),
    @NamedQuery(name = QueryConstants.REQUEST_HAS_COLLECTION_REQUEST_BY_REQUEST_BY_COLLECTION_REQUEST, query = "SELECT r FROM RequestHasCollectionsRequest r WHERE r.requestId.id=:requestId AND r.collectionsRequestid.id=:collectionsRequestId")})

public class RequestHasCollectionsRequest extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "indApproved")
    private Short indApproved;
    @Size(max = 1500)
    @Column(name = "observations")
    private String observations;
    @Size(max = 250)
    @Column(name = "urlImageFile")
    private String urlImageFile;
    @JoinColumn(name = "collectionsRequest_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CollectionsRequest collectionsRequestid;
    @JoinColumn(name = "request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Request requestId;

    public RequestHasCollectionsRequest() {
    }

    public RequestHasCollectionsRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getIndApproved() {
        return indApproved;
    }

    public void setIndApproved(Short indApproved) {
        this.indApproved = indApproved;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getUrlImageFile() {
        return urlImageFile;
    }

    public void setUrlImageFile(String urlImageFile) {
        this.urlImageFile = urlImageFile;
    }

    public CollectionsRequest getCollectionsRequestid() {
        return collectionsRequestid;
    }

    public void setCollectionsRequestid(CollectionsRequest collectionsRequestid) {
        this.collectionsRequestid = collectionsRequestid;
    }

    public Request getRequestId() {
        return requestId;
    }

    public void setRequestId(Request requestId) {
        this.requestId = requestId;
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
        if (!(object instanceof RequestHasCollectionsRequest)) {
            return false;
        }
        RequestHasCollectionsRequest other = (RequestHasCollectionsRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.RequestHasCollectionsRequest[ id=" + id + " ]";
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

