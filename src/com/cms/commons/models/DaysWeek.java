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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "daysWeek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DaysWeek.findAll", query = "SELECT d FROM DaysWeek d")
    , @NamedQuery(name = "DaysWeek.findById", query = "SELECT d FROM DaysWeek d WHERE d.id = :id")
    , @NamedQuery(name = "DaysWeek.findByDay", query = "SELECT d FROM DaysWeek d WHERE d.day = :day")})
public class DaysWeek extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "day")
    private String day;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "daysWeekId")
    private Collection<DaysWeekHasProgramLoyalty> daysWeekHasProgramLoyaltyCollection;

    public DaysWeek() {
    }

    public DaysWeek(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<DaysWeekHasProgramLoyalty> getDaysWeekHasProgramLoyaltyCollection() {
        return daysWeekHasProgramLoyaltyCollection;
    }

    public void setDaysWeekHasProgramLoyaltyCollection(Collection<DaysWeekHasProgramLoyalty> daysWeekHasProgramLoyaltyCollection) {
        this.daysWeekHasProgramLoyaltyCollection = daysWeekHasProgramLoyaltyCollection;
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
        if (!(object instanceof DaysWeek)) {
            return false;
        }
        DaysWeek other = (DaysWeek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.DaysWeek[ id=" + id + " ]";
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
