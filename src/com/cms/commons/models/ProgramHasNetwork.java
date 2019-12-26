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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yalmea
 */
@Entity
@Table(name = "programHasNetwork")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramHasNetwork.findAll", query = "SELECT p FROM ProgramHasNetwork p"),
    @NamedQuery(name = "ProgramHasNetwork.findById", query = "SELECT p FROM ProgramHasNetwork p WHERE p.id = :id"),
    @NamedQuery(name = QueryConstants.NETWORK_BY_PROGRAM, query = "SELECT p FROM ProgramHasNetwork p WHERE p.programId.id=:programId")})

public class ProgramHasNetwork extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "networkId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Network networkId;
    @JoinColumn(name = "programId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Program programId;

    public ProgramHasNetwork() {
    }

    public ProgramHasNetwork(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Network getNetworkId() {
        return networkId;
    }

    public void setNetworkId(Network networkId) {
        this.networkId = networkId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
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
        if (!(object instanceof ProgramHasNetwork)) {
            return false;
        }
        ProgramHasNetwork other = (ProgramHasNetwork) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

   
   @Override
    public String toString() {
        return super.toString();
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
