package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import com.cms.commons.util.QueryConstants;
import com.cms.commons.util.Constants;
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
@Table(name = "personType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonType.findAll", query = "SELECT p FROM PersonType p"),
    @NamedQuery(name = "PersonType.findById", query = "SELECT p FROM PersonType p WHERE p.id = :id"),
    @NamedQuery(name = "PersonType.findByDescription", query = "SELECT p FROM PersonType p WHERE p.description = :description"),
    @NamedQuery(name = QueryConstants.PERSON_TYPE_BY_COUNTRY_BY_IND_NATURAL_PERSON, query = "SELECT p FROM PersonType p WHERE p.countryId.id=:countryId AND p.originApplicationId.id=:originApplicationId AND p.indNaturalPerson=:indNaturalPerson"),
    @NamedQuery(name = QueryConstants.PERSON_TYPE_BY_COUNTRY, query = "SELECT p FROM PersonType p WHERE p.countryId.id=:countryId AND p.originApplicationId.id=:originApplicationId")})
public class PersonType extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;
    @JoinColumn(name = "originApplicationId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OriginApplication originApplicationId;
    @Column(name = "indNaturalPerson")
    private Boolean indNaturalPerson;

    public PersonType() {
    }

    public PersonType(Integer id) {
        this.id = id;
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

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public OriginApplication getOriginApplicationId() {
        return originApplicationId;
    }

    public void setOriginApplicationId(OriginApplication originApplicationId) {
        this.originApplicationId = originApplicationId;
    }

    public Boolean getIndNaturalPerson() {
        return indNaturalPerson;
    }

    public void setIndNaturalPerson(Boolean indNaturalPerson) {
        this.indNaturalPerson = indNaturalPerson;
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
        if (!(object instanceof PersonType)) {
            return false;
        }
        PersonType other = (PersonType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.PersonType[ id=" + id + " ]";
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
