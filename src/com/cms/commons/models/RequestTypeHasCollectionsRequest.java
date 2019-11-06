/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "requestTypeHasCollectionsRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestTypeHasCollectionsRequest.findAll", query = "SELECT r FROM RequestTypeHasCollectionsRequest r")
    , @NamedQuery(name = "RequestTypeHasCollectionsRequest.findById", query = "SELECT r FROM RequestTypeHasCollectionsRequest r WHERE r.id = :id")})
public class RequestTypeHasCollectionsRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "collectionsRequest_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CollectionsRequest collectionsRequestid;
    @JoinColumn(name = "requestType_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RequestType requestTypeid;

    public RequestTypeHasCollectionsRequest() {
    }

    public RequestTypeHasCollectionsRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CollectionsRequest getCollectionsRequestid() {
        return collectionsRequestid;
    }

    public void setCollectionsRequestid(CollectionsRequest collectionsRequestid) {
        this.collectionsRequestid = collectionsRequestid;
    }

    public RequestType getRequestTypeid() {
        return requestTypeid;
    }

    public void setRequestTypeid(RequestType requestTypeid) {
        this.requestTypeid = requestTypeid;
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
        if (!(object instanceof RequestTypeHasCollectionsRequest)) {
            return false;
        }
        RequestTypeHasCollectionsRequest other = (RequestTypeHasCollectionsRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.RequestTypeHasCollectionsRequest[ id=" + id + " ]";
    }
    
}
