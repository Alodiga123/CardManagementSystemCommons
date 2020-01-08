/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.cms.commons.util.QueryConstants;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "commerceCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommerceCategory.findAll", query = "SELECT c FROM CommerceCategory c"),
    @NamedQuery(name = "CommerceCategory.findById", query = "SELECT c FROM CommerceCategory c WHERE c.id = :id"),
    @NamedQuery(name = "CommerceCategory.findByMccCode", query = "SELECT c FROM CommerceCategory c WHERE c.mccCode = :mccCode"),
    @NamedQuery(name = QueryConstants.COMMERCE_CATEGORY_BY_SEGMENT_COMMERCE, query = "SELECT c FROM CommerceCategory c WHERE c.segmentCommerceId.id = :segmentCommerceId")})
public class CommerceCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "mccCode")
    private String mccCode;
    @Size(max = 1000)
    @Column(name = "economicActivity")
    private String economicActivity;
    @Size(max = 1500)
    @Column(name = "descriptionEconomicActivity")
    private String descriptionEconomicActivity;
    @JoinColumn(name = "segmentCommerceId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SegmentCommerce segmentCommerceId;

    public CommerceCategory() {
    }

    public CommerceCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMccCode() {
        return mccCode;
    }

    public void setMccCode(String mccCode) {
        this.mccCode = mccCode;
    }
    
    public String getEconomicActivity() {
        return economicActivity;
    }

    public void setEconomicActivity(String economicActivity) {
        this.economicActivity = economicActivity;
    }

    public String getDescriptionEconomicActivity() {
        return descriptionEconomicActivity;
    }

    public void setDescriptionEconomicActivity(String descriptionEconomicActivity) {
        this.descriptionEconomicActivity = descriptionEconomicActivity;
    }

    public SegmentCommerce getsegmentCommerceId() {
        return segmentCommerceId;
    }

    public void setsegmentCommerceId(SegmentCommerce segmentCommerceId) {
        this.segmentCommerceId = segmentCommerceId;
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
        if (!(object instanceof CommerceCategory)) {
            return false;
        }
        CommerceCategory other = (CommerceCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.CommerceCategory[ id=" + id + " ]";
    }
    
}
