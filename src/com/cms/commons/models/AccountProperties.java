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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "accountProperties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountProperties.findAll", query = "SELECT a FROM AccountProperties a")
    , @NamedQuery(name = "AccountProperties.findById", query = "SELECT a FROM AccountProperties a WHERE a.id = :id")
    , @NamedQuery(name = "AccountProperties.findByIdentifier", query = "SELECT a FROM AccountProperties a WHERE a.identifier = :identifier")
    , @NamedQuery(name = "AccountProperties.findByLenghtAccount", query = "SELECT a FROM AccountProperties a WHERE a.lenghtAccount = :lenghtAccount")
    , @NamedQuery(name = "AccountProperties.findByMaximumAmount", query = "SELECT a FROM AccountProperties a WHERE a.maximumAmount = :maximumAmount")
    , @NamedQuery(name = "AccountProperties.findByMinimunAmount", query = "SELECT a FROM AccountProperties a WHERE a.minimunAmount = :minimunAmount")
    , @NamedQuery(name = "AccountProperties.findByIndOverDraft", query = "SELECT a FROM AccountProperties a WHERE a.indOverDraft = :indOverDraft")})
public class AccountProperties extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 40)
    @Column(name = "identifier")
    private String identifier;
    @Column(name = "lenghtAccount")
    private Integer lenghtAccount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "maximumAmount")
    private Float maximumAmount;
    @Column(name = "minimunAmount")
    private Float minimunAmount;
    @Column(name = "indOverDraft")
    private Boolean indOverDraft;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;
    @JoinColumn(name = "programId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Program programId;
    @JoinColumn(name = "accountTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountType accountTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountPropertiesId")
    private Collection<AccountSegment> accountSegmentCollection;

    public AccountProperties() {
    }

    public AccountProperties(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Integer getLenghtAccount() {
        return lenghtAccount;
    }

    public void setLenghtAccount(Integer lenghtAccount) {
        this.lenghtAccount = lenghtAccount;
    }

    public Float getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(Float maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public Float getMinimunAmount() {
        return minimunAmount;
    }

    public void setMinimunAmount(Float minimunAmount) {
        this.minimunAmount = minimunAmount;
    }

    public Boolean getIndOverDraft() {
        return indOverDraft;
    }

    public void setIndOverDraft(Boolean indOverDraft) {
        this.indOverDraft = indOverDraft;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public AccountType getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(AccountType accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<AccountSegment> getAccountSegmentCollection() {
        return accountSegmentCollection;
    }

    public void setAccountSegmentCollection(Collection<AccountSegment> accountSegmentCollection) {
        this.accountSegmentCollection = accountSegmentCollection;
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
        if (!(object instanceof AccountProperties)) {
            return false;
        }
        AccountProperties other = (AccountProperties) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.AccountProperties[ id=" + id + " ]";
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
