/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "reasonRejectionRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReasonRejectionRequest.findAll", query = "SELECT r FROM ReasonRejectionRequest r")
    , @NamedQuery(name = "ReasonRejectionRequest.findById", query = "SELECT r FROM ReasonRejectionRequest r WHERE r.id = :id")
    , @NamedQuery(name = "ReasonRejectionRequest.findByCode", query = "SELECT r FROM ReasonRejectionRequest r WHERE r.code = :code")
    , @NamedQuery(name = "ReasonRejectionRequest.findByDescription", query = "SELECT r FROM ReasonRejectionRequest r WHERE r.description = :description")})
public class ReasonRejectionRequest implements Serializable {

    @OneToMany(mappedBy = "reasonRejectionRequestId")
    private Collection<Request> requestCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "description")
    private String description;

    public ReasonRejectionRequest() {
    }

    public ReasonRejectionRequest(Integer id) {
        this.id = id;
    }

    public ReasonRejectionRequest(Integer id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof ReasonRejectionRequest)) {
            return false;
        }
        ReasonRejectionRequest other = (ReasonRejectionRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ReasonRejectionRequest[ id=" + id + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }
    
}
