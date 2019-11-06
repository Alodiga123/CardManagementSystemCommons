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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r")
    , @NamedQuery(name = "Request.findById", query = "SELECT r FROM Request r WHERE r.id = :id")
    , @NamedQuery(name = "Request.findByRequestNumber", query = "SELECT r FROM Request r WHERE r.requestNumber = :requestNumber")
    , @NamedQuery(name = "Request.findByRequestDate", query = "SELECT r FROM Request r WHERE r.requestDate = :requestDate")})
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
    @JoinColumn(name = "statusRequestId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusRequest statusRequestId;
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "requestTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RequestType requestTypeId;

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

    public StatusRequest getStatusRequestId() {
        return statusRequestId;
    }

    public void setStatusRequestId(StatusRequest statusRequestid) {
        this.statusRequestId = statusRequestid;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public RequestType getRequestTypeId() {
        return requestTypeId;
    }

    public void setRequestTypeId(RequestType requestTypeid) {
        this.requestTypeId = requestTypeid;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}