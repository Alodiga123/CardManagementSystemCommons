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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "reviewOFAC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReviewOFAC.findAll", query = "SELECT r FROM ReviewOFAC r"),
    @NamedQuery(name = "ReviewOFAC.findById", query = "SELECT r FROM ReviewOFAC r WHERE r.id = :id"),
    @NamedQuery(name = "ReviewOFAC.findByResultReview", query = "SELECT r FROM ReviewOFAC r WHERE r.resultReview = :resultReview"),
    @NamedQuery(name = QueryConstants.REVIEW_OFAC_BY_APPLICANT_BY_REQUEST, query = "SELECT r FROM ReviewOFAC r WHERE r.personId.id = :personId AND r.requestId.id = :requestId")})
public class ReviewOFAC extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "resultReview")
    private Float resultReview;
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "requestId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Request requestId;

    public ReviewOFAC() {
    }

    public ReviewOFAC(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getResultReview() {
        return resultReview;
    }

    public void setResultReview(Float resultReview) {
        this.resultReview = resultReview;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
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
        if (!(object instanceof ReviewOFAC)) {
            return false;
        }
        ReviewOFAC other = (ReviewOFAC) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ReviewOFAC[ id=" + id + " ]";
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
