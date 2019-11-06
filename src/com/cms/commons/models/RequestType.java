/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
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
@Table(name = "requestType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestType.findAll", query = "SELECT r FROM RequestType r"),
    @NamedQuery(name = "RequestType.findById", query = "SELECT r FROM RequestType r WHERE r.id = :id")})
public class RequestType extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "cardRequestTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CardRequestType cardRequestTypeId;

    public RequestType() {
    }

    public RequestType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CardRequestType getCardRequestTypeId() {
        return cardRequestTypeId;
    }

    public void setCardRequestTypeId(CardRequestType cardRequestTypeId) {
        this.cardRequestTypeId = cardRequestTypeId;
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
        if (!(object instanceof RequestType)) {
            return false;
        }
        RequestType other = (RequestType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.RequestType[ id=" + id + " ]";
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
