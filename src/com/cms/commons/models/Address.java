/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id")
    , @NamedQuery(name = "Address.findByNameEdification", query = "SELECT a FROM Address a WHERE a.nameEdification = :nameEdification")
    , @NamedQuery(name = "Address.findByTower", query = "SELECT a FROM Address a WHERE a.tower = :tower")
    , @NamedQuery(name = "Address.findByFloor", query = "SELECT a FROM Address a WHERE a.floor = :floor")
    , @NamedQuery(name = "Address.findByNameStreet", query = "SELECT a FROM Address a WHERE a.nameStreet = :nameStreet")
    , @NamedQuery(name = "Address.findByUrbanization", query = "SELECT a FROM Address a WHERE a.urbanization = :urbanization")})
public class Address extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nameEdification")
    private String nameEdification;
    @Column(name = "tower")
    private String tower;
    @Column(name = "floor")
    private Integer floor;
    @Column(name = "nameStreet")
    private String nameStreet;
    @Column(name = "urbanization")
    private String urbanization;
    @Column(name = "indAddressDelivery")
    private Boolean indAddressDelivery;
    @JoinColumn(name = "addressTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AddressType addressTypeId;
    @JoinColumn(name = "edificationTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EdificationType edificationTypeId;
    @JoinColumn(name = "streetTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StreetType streetTypeId;
    @JoinColumn(name = "cityId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private City cityId;
    @JoinColumn(name = "zipZoneId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ZipZone zipZoneId;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;
    @Column(name = "number")
    private String number;

    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameEdification() {
        return nameEdification;
    }

    public void setNameEdification(String nameEdification) {
        this.nameEdification = nameEdification;
    }

    public String getTower() {
        return tower;
    }

    public void setTower(String tower) {
        this.tower = tower;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getNameStreet() {
        return nameStreet;
    }

    public void setNameStreet(String nameStreet) {
        this.nameStreet = nameStreet;
    }

    public String getUrbanization() {
        return urbanization;
    }

    public void setUrbanization(String urbanization) {
        this.urbanization = urbanization;
    }

    public EdificationType getEdificationTypeId() {
        return edificationTypeId;
    }

    public void setEdificationTypeId(EdificationType edificationTypeId) {
        this.edificationTypeId = edificationTypeId;
    }

    public StreetType getStreetTypeId() {
        return streetTypeId;
    }

    public void setStreetTypeId(StreetType streetTypeId) {
        this.streetTypeId = streetTypeId;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public ZipZone getZipZoneId() {
        return zipZoneId;
    }

    public void setZipZoneId(ZipZone zipZoneId) {
        this.zipZoneId = zipZoneId;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }
    
    public Boolean getIndAddressDelivery() {
        return indAddressDelivery;
    }

    public void setIndAddressDelivery(Boolean indAddressDelivery) {
        this.indAddressDelivery = indAddressDelivery;
    }
    
    public AddressType getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(AddressType addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.Address[ id=" + id + " ]";
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
