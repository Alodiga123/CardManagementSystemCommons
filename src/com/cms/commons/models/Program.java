/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yalmea
 */
@Entity
@Table(name = "program")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p"),
    @NamedQuery(name = "Program.findById", query = "SELECT p FROM Program p WHERE p.id = :id"),
    @NamedQuery(name = "Program.findByName", query = "SELECT p FROM Program p WHERE p.name = :name"),
    @NamedQuery(name = "Program.findByDescription", query = "SELECT p FROM Program p WHERE p.description = :description"),
    @NamedQuery(name = "Program.findByContractDate", query = "SELECT p FROM Program p WHERE p.contractDate = :contractDate"),
    @NamedQuery(name = "Program.findByExpectedLaunchDate", query = "SELECT p FROM Program p WHERE p.expectedLaunchDate = :expectedLaunchDate"),
    @NamedQuery(name = "Program.findByReloadable", query = "SELECT p FROM Program p WHERE p.reloadable = :reloadable"),
    @NamedQuery(name = "Program.findByOtherSourceFunds", query = "SELECT p FROM Program p WHERE p.otherSourceFunds = :otherSourceFunds"),
    @NamedQuery(name = "Program.findBySharedBrand", query = "SELECT p FROM Program p WHERE p.sharedBrand = :sharedBrand"),
    @NamedQuery(name = "Program.findByWebSite", query = "SELECT p FROM Program p WHERE p.webSite = :webSite"),
    @NamedQuery(name = "Program.findByCashAccess", query = "SELECT p FROM Program p WHERE p.cashAccess = :cashAccess"),
    @NamedQuery(name = "Program.findByBiniinNumber", query = "SELECT p FROM Program p WHERE p.biniinNumber = :biniinNumber"),
    @NamedQuery(name = "Program.findByUseInternational", query = "SELECT p FROM Program p WHERE p.useInternational = :useInternational"),
    @NamedQuery(name = "Program.findByCreateDate", query = "SELECT p FROM Program p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Program.findByUpdateDate", query = "SELECT p FROM Program p WHERE p.updateDate = :updateDate"),
    @NamedQuery(name = "Program.findByOtherResponsibleNetworkReporting", query = "SELECT p FROM Program p WHERE p.otherResponsibleNetworkReporting = :otherResponsibleNetworkReporting")})
public class Program extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 2000)
    @Column(name = "description")
    private String description;
    @Column(name = "contractDate")
    @Temporal(TemporalType.DATE)
    private Date contractDate;
    @Column(name = "expectedLaunchDate")
    @Temporal(TemporalType.DATE)
    private Date expectedLaunchDate;
    @Column(name = "reloadable")
    private Short reloadable;
    @Size(max = 255)
    @Column(name = "otherSourceFunds")
    private String otherSourceFunds;
    @Column(name = "sharedBrand")
    private Short sharedBrand;
    @Size(max = 50)
    @Column(name = "webSite")
    private String webSite;
    @Column(name = "cashAccess")
    private Short cashAccess;
    @Size(max = 15)
    @Column(name = "biniinNumber")
    private String biniinNumber;
    @Column(name = "useInternational")
    private Short useInternational;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Size(max = 50)
    @Column(name = "otherResponsibleNetworkReporting")
    private String otherResponsibleNetworkReporting;
    @JoinColumn(name = "sourceFundsId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SourceFunds sourceFundsId;
    @JoinColumn(name = "responsibleNetworkReportingId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ResponsibleNetworkReporting responsibleNetworkReportingId;
    @JoinColumn(name = "ProgramTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProgramType programTypeId;
    @JoinColumn(name = "productTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductType productTypeId;
    @JoinColumn(name = "cardProgramManagerId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person cardProgramManagerId;
    @JoinColumn(name = "programOwnerId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person programOwnerId;
    @JoinColumn(name = "IssuerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Issuer issuerId;
    @JoinColumn(name = "currencyId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currency currencyId;
    @JoinColumn(name = "cardIssuanceTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CardIssuanceType cardIssuanceTypeId;
    @JoinColumn(name = "BinSponsorId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BinSponsor binSponsorId;

    public Program() {
    }

    public Program(Long id) {
        this.id = id;
    }

    public Program(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Date getExpectedLaunchDate() {
        return expectedLaunchDate;
    }

    public void setExpectedLaunchDate(Date expectedLaunchDate) {
        this.expectedLaunchDate = expectedLaunchDate;
    }

    public Short getReloadable() {
        return reloadable;
    }

    public void setReloadable(Short reloadable) {
        this.reloadable = reloadable;
    }

    public String getOtherSourceFunds() {
        return otherSourceFunds;
    }

    public void setOtherSourceFunds(String otherSourceFunds) {
        this.otherSourceFunds = otherSourceFunds;
    }

    public Short getSharedBrand() {
        return sharedBrand;
    }

    public void setSharedBrand(Short sharedBrand) {
        this.sharedBrand = sharedBrand;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Short getCashAccess() {
        return cashAccess;
    }

    public void setCashAccess(Short cashAccess) {
        this.cashAccess = cashAccess;
    }

    public String getBiniinNumber() {
        return biniinNumber;
    }

    public void setBiniinNumber(String biniinNumber) {
        this.biniinNumber = biniinNumber;
    }

    public Short getUseInternational() {
        return useInternational;
    }

    public void setUseInternational(Short useInternational) {
        this.useInternational = useInternational;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getOtherResponsibleNetworkReporting() {
        return otherResponsibleNetworkReporting;
    }

    public void setOtherResponsibleNetworkReporting(String otherResponsibleNetworkReporting) {
        this.otherResponsibleNetworkReporting = otherResponsibleNetworkReporting;
    }

    public SourceFunds getSourceFundsId() {
        return sourceFundsId;
    }

    public void setSourceFundsId(SourceFunds sourceFundsId) {
        this.sourceFundsId = sourceFundsId;
    }

    public ResponsibleNetworkReporting getResponsibleNetworkReportingId() {
        return responsibleNetworkReportingId;
    }

    public void setResponsibleNetworkReportingId(ResponsibleNetworkReporting responsibleNetworkReportingId) {
        this.responsibleNetworkReportingId = responsibleNetworkReportingId;
    }

    public ProgramType getProgramTypeId() {
        return programTypeId;
    }

    public void setProgramTypeId(ProgramType programTypeId) {
        this.programTypeId = programTypeId;
    }

    public ProductType getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(ProductType productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Person getCardProgramManagerId() {
        return cardProgramManagerId;
    }

    public void setCardProgramManagerId(Person cardProgramManagerId) {
        this.cardProgramManagerId = cardProgramManagerId;
    }

    public Person getProgramOwnerId() {
        return programOwnerId;
    }

    public void setProgramOwnerId(Person programOwnerId) {
        this.programOwnerId = programOwnerId;
    }

    public Issuer getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(Issuer issuerId) {
        this.issuerId = issuerId;
    }

    public Currency getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Currency currencyId) {
        this.currencyId = currencyId;
    }

    public CardIssuanceType getCardIssuanceTypeId() {
        return cardIssuanceTypeId;
    }

    public void setCardIssuanceTypeId(CardIssuanceType cardIssuanceTypeId) {
        this.cardIssuanceTypeId = cardIssuanceTypeId;
    }

    public BinSponsor getBinSponsorId() {
        return binSponsorId;
    }

    public void setBinSponsorId(BinSponsor binSponsorId) {
        this.binSponsorId = binSponsorId;
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
        if (!(object instanceof Program)) {
            return false;
        }
        Program other = (Program) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.Program[ id=" + id + " ]";
    }

    @Override
    public Object getPk() {
        return getId();
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
    }

    public void getBiniinNumber(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getProgramOwnerId(NaturalPerson naturalPerson) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getNetWordId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

  
   
    
}
