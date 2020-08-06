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
@Table(name = "phonePerson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhonePerson.findAll", query = "SELECT p FROM PhonePerson p"),
    @NamedQuery(name = "PhonePerson.findById", query = "SELECT p FROM PhonePerson p WHERE p.id = :id"),
    @NamedQuery(name = "PhonePerson.findByNumberPhone", query = "SELECT p FROM PhonePerson p WHERE p.numberPhone = :numberPhone"),
    @NamedQuery(name = QueryConstants.PHONES_BY_MAIN, query = "SELECT p FROM PhonePerson p WHERE p.personId.id=:personId AND p.indMainPhone=true"),
    @NamedQuery(name = QueryConstants.PHONES_BY_PERSON, query = "SELECT p FROM PhonePerson p WHERE p.personId.id = :personId")})
public class PhonePerson extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "numberPhone")
    private String numberPhone;
    @Column(name = "extensionPhoneNumber")
    private String extensionPhoneNumber;
    @JoinColumn(name = "personId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "phoneTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PhoneType phoneTypeId;
    @Size(max = 4)
    @Column(name = "countryCode")
    private String countryCode;
    @Size(max = 10)
    @Column(name = "areaCode")
    private String areaCode;
    @Column(name = "indMainPhone")
    private Boolean indMainPhone;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;

    public PhonePerson() {
    }

    public PhonePerson(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getExtensionPhoneNumber() {
        return extensionPhoneNumber;
    }

    public void setExtensionPhoneNumber(String extensionPhoneNumber) {
        this.extensionPhoneNumber = extensionPhoneNumber;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public PhoneType getPhoneTypeId() {
        return phoneTypeId;
    }

    public void setPhoneTypeId(PhoneType phoneTypeId) {
        this.phoneTypeId = phoneTypeId;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
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
        if (!(object instanceof PhonePerson)) {
            return false;
        }
        PhonePerson other = (PhonePerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.PhonePerson[ id=" + id + " ]";
    }
    
    @Override
    public Object getPk() {
        return getId();
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Boolean getIndMainPhone() {
        return indMainPhone;
    }

    public void setIndMainPhone(Boolean indMainPhone) {
        this.indMainPhone = indMainPhone;
    }
    
}
