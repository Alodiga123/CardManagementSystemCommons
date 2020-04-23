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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "statusResultPlasticCustomizing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusResultPlasticCustomizing.findAll", query = "SELECT s FROM StatusResultPlasticCustomizing s"),
    @NamedQuery(name = "StatusResultPlasticCustomizing.findById", query = "SELECT s FROM StatusResultPlasticCustomizing s WHERE s.id = :id"),
    @NamedQuery(name = "StatusResultPlasticCustomizing.findByDescription", query = "SELECT s FROM StatusResultPlasticCustomizing s WHERE s.description = :description"),
    @NamedQuery(name = QueryConstants.STATUS_BY_DESCRIPTION, query = "SELECT s FROM StatusResultPlasticCustomizing s WHERE s.description LIKE :description"),
    @NamedQuery(name = QueryConstants.STATUS_BY_CARD_STATUS, query = "SELECT s FROM StatusResultPlasticCustomizing s WHERE s.id = :id"),
    @NamedQuery(name = QueryConstants.STATUS_BY_PLASTIC_MANUFACTURER, query = "SELECT s FROM StatusResultPlasticCustomizing s WHERE s.plasticManufacturerId.id=:plasticManufacturerId")})
public class StatusResultPlasticCustomizing extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "plasticManufacturerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlasticManufacturer plasticManufacturerId;
    @JoinColumn(name = "cardStatusId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CardStatus cardStatusId;

    public StatusResultPlasticCustomizing() {
    }

    public StatusResultPlasticCustomizing(Integer id) {
        this.id = id;
    }

    public StatusResultPlasticCustomizing(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PlasticManufacturer getPlasticManufacturerId() {
        return plasticManufacturerId;
    }

    public void setPlasticManufacturerId(PlasticManufacturer plasticManufacturerId) {
        this.plasticManufacturerId = plasticManufacturerId;
    }

    public CardStatus getCardStatusId() {
        return cardStatusId;
    }

    public void setCardStatusId(CardStatus cardStatusId) {
        this.cardStatusId = cardStatusId;
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
        if (!(object instanceof StatusResultPlasticCustomizing)) {
            return false;
        }
        StatusResultPlasticCustomizing other = (StatusResultPlasticCustomizing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.StatusResultPlasticCustomizing[ id=" + id + " ]";
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
