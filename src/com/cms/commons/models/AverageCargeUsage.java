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
 * @author jose
 */
@Entity
@Table(name = "averageCargeUsage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AverageCargeUsage.findAll", query = "SELECT a FROM AverageCargeUsage a")
    , @NamedQuery(name = "AverageCargeUsage.findById", query = "SELECT a FROM AverageCargeUsage a WHERE a.id = :id")
    , @NamedQuery(name = "AverageCargeUsage.findByYear", query = "SELECT a FROM AverageCargeUsage a WHERE a.year = :year")
    , @NamedQuery(name = "AverageCargeUsage.findByAverageSpendMonth", query = "SELECT a FROM AverageCargeUsage a WHERE a.averageSpendMonth = :averageSpendMonth")
    , @NamedQuery(name = "AverageCargeUsage.findByAverageLoadMonth", query = "SELECT a FROM AverageCargeUsage a WHERE a.averageLoadMonth = :averageLoadMonth")
    , @NamedQuery(name = QueryConstants.AVERAGE_CARGE_USAGE_BY_PROGRAM, query = "SELECT a FROM AverageCargeUsage a WHERE a.programId.id=:programId")})
public class AverageCargeUsage extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "averageSpendMonth")
    private Float averageSpendMonth;
    @Column(name = "averageLoadMonth")
    private Float averageLoadMonth;
    @JoinColumn(name = "programId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Program programId;

    public AverageCargeUsage() {
    }

    public AverageCargeUsage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Float getAverageSpendMonth() {
        return averageSpendMonth;
    }

    public void setAverageSpendMonth(Float averageSpendMonth) {
        this.averageSpendMonth = averageSpendMonth;
    }

    public Float getAverageLoadMonth() {
        return averageLoadMonth;
    }

    public void setAverageLoadMonth(Float averageLoadMonth) {
        this.averageLoadMonth = averageLoadMonth;
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
        if (!(object instanceof AverageCargeUsage)) {
            return false;
        }
        AverageCargeUsage other = (AverageCargeUsage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.AverageCargeUsage[ id=" + id + " ]";
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
