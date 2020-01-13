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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id")
    , @NamedQuery(name = "Product.findByCreateDate", query = "SELECT p FROM Product p WHERE p.createDate = :createDate")
    , @NamedQuery(name = "Product.findByUpdatedate", query = "SELECT p FROM Product p WHERE p.updatedate = :updatedate")
    , @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")
    , @NamedQuery(name = "Product.findByBinNumber", query = "SELECT p FROM Product p WHERE p.binNumber = :binNumber")
    , @NamedQuery(name = "Product.findByValidityYears", query = "SELECT p FROM Product p WHERE p.validityYears = :validityYears")
    , @NamedQuery(name = "Product.findByDaysBeforeExpiration", query = "SELECT p FROM Product p WHERE p.daysBeforeExpiration = :daysBeforeExpiration")
    , @NamedQuery(name = "Product.findByDaysToInactivate", query = "SELECT p FROM Product p WHERE p.daysToInactivate = :daysToInactivate")
    , @NamedQuery(name = "Product.findByDaysToActivate", query = "SELECT p FROM Product p WHERE p.daysToActivate = :daysToActivate")
    , @NamedQuery(name = "Product.findByDaysToUse", query = "SELECT p FROM Product p WHERE p.daysToUse = :daysToUse")
    , @NamedQuery(name = "Product.findByDaysToWithdrawCard", query = "SELECT p FROM Product p WHERE p.daysToWithdrawCard = :daysToWithdrawCard")
    , @NamedQuery(name = "Product.findByBeginDateValidity", query = "SELECT p FROM Product p WHERE p.beginDateValidity = :beginDateValidity")
    , @NamedQuery(name = "Product.findByEndDateValidity", query = "SELECT p FROM Product p WHERE p.endDateValidity = :endDateValidity")})
public class Product extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updatedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedate;
    @Column(name = "name")
    private String name;
    @Column(name = "binNumber")
    private String binNumber;
    @Column(name = "validityYears")
    private Integer validityYears;
    @Column(name = "daysBeforeExpiration")
    private Integer daysBeforeExpiration;
    @Column(name = "daysToInactivate")
    private Integer daysToInactivate;
    @Column(name = "daysToActivate")
    private Integer daysToActivate;
    @Column(name = "daysToUse")
    private Integer daysToUse;
    @Column(name = "daysToWithdrawCard")
    private Integer daysToWithdrawCard;
    @Column(name = "beginDateValidity")
    @Temporal(TemporalType.DATE)
    private Date beginDateValidity;
    @Column(name = "endDateValidity")
    @Temporal(TemporalType.DATE)
    private Date endDateValidity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productId")
    private ProductHasCommerceCategory productHasCommerceCategory;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productId")
    private AllowedChannels allowedChannels;
    @JoinColumn(name = "issuerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Issuer issuerId;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;
    @JoinColumn(name = "cardTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CardType cardTypeId;
    @JoinColumn(name = "program_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Program programId;
    @JoinColumn(name = "kindCardId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private KindCard kindCardId;
    @JoinColumn(name = "programTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProgramType programTypeId;
    @JoinColumn(name = "binSponsorId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BinSponsor binSponsorId;
    @JoinColumn(name = "levelProductId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LevelProduct levelProductId;
    @JoinColumn(name = "segmentMarketingId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SegmentMarketing segmentMarketingId;
    @JoinColumn(name = "productUseId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductUse productUseId;
    @JoinColumn(name = "domesticCurrencyId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currency domesticCurrencyId;
    @JoinColumn(name = "internationalCurrencyId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Currency internationalCurrencyId;
    @JoinColumn(name = "storageMedio_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StorageMedio storageMedioid;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productId")
    private CardRequest cardRequest;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "minimumBalance")
    private Float minimumBalance;
    @Column(name = "maximumBalance")
    private Float maximumBalance;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productId")
    private ProductHasChannel productHasChannel;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productId")
    private ReviewCollectionsRequest reviewCollectionsRequest;

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public Integer getValidityYears() {
        return validityYears;
    }

    public void setValidityYears(Integer validityYears) {
        this.validityYears = validityYears;
    }

    public Integer getDaysBeforeExpiration() {
        return daysBeforeExpiration;
    }

    public void setDaysBeforeExpiration(Integer daysBeforeExpiration) {
        this.daysBeforeExpiration = daysBeforeExpiration;
    }

    public Integer getDaysToInactivate() {
        return daysToInactivate;
    }

    public void setDaysToInactivate(Integer daysToInactivate) {
        this.daysToInactivate = daysToInactivate;
    }

    public Integer getDaysToActivate() {
        return daysToActivate;
    }

    public void setDaysToActivate(Integer daysToActivate) {
        this.daysToActivate = daysToActivate;
    }

    public Integer getDaysToUse() {
        return daysToUse;
    }

    public void setDaysToUse(Integer daysToUse) {
        this.daysToUse = daysToUse;
    }

    public Integer getDaysToWithdrawCard() {
        return daysToWithdrawCard;
    }

    public void setDaysToWithdrawCard(Integer daysToWithdrawCard) {
        this.daysToWithdrawCard = daysToWithdrawCard;
    }

    public Date getBeginDateValidity() {
        return beginDateValidity;
    }

    public void setBeginDateValidity(Date beginDateValidity) {
        this.beginDateValidity = beginDateValidity;
    }

    public Date getEndDateValidity() {
        return endDateValidity;
    }

    public void setEndDateValidity(Date endDateValidity) {
        this.endDateValidity = endDateValidity;
    }

    public ProductHasCommerceCategory getProductHasCommerceCategory() {
        return productHasCommerceCategory;
    }

    public void setProductHasCommerceCategory(ProductHasCommerceCategory productHasCommerceCategory) {
        this.productHasCommerceCategory = productHasCommerceCategory;
    }

    public AllowedChannels getAllowedChannels() {
        return allowedChannels;
    }

    public void setAllowedChannels(AllowedChannels allowedChannels) {
        this.allowedChannels = allowedChannels;
    }

    public Issuer getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(Issuer issuerId) {
        this.issuerId = issuerId;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public CardType getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(CardType cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public KindCard getKindCardId() {
        return kindCardId;
    }

    public void setKindCardId(KindCard kindCardId) {
        this.kindCardId = kindCardId;
    }

    public ProgramType getProgramTypeId() {
        return programTypeId;
    }

    public void setProgramTypeId(ProgramType programTypeId) {
        this.programTypeId = programTypeId;
    }

    public BinSponsor getBinSponsorId() {
        return binSponsorId;
    }

    public void setBinSponsorId(BinSponsor binSponsorId) {
        this.binSponsorId = binSponsorId;
    }

    public LevelProduct getLevelProductId() {
        return levelProductId;
    }

    public void setLevelProductId(LevelProduct levelProductId) {
        this.levelProductId = levelProductId;
    }

    public SegmentMarketing getsegmentMarketingId() {
        return segmentMarketingId;
    }

    public void setsegmentMarketingId(SegmentMarketing segmentMarketingId) {
        this.segmentMarketingId = segmentMarketingId;
    }

    public ProductUse getProductUseId() {
        return productUseId;
    }

    public void setProductUseId(ProductUse productUseId) {
        this.productUseId = productUseId;
    }

    public Currency getDomesticCurrencyId() {
        return domesticCurrencyId;
    }

    public void setDomesticCurrencyId(Currency domesticCurrencyId) {
        this.domesticCurrencyId = domesticCurrencyId;
    }

    public Currency getInternationalCurrencyId() {
        return internationalCurrencyId;
    }

    public void setInternationalCurrencyId(Currency internationalCurrencyId) {
        this.internationalCurrencyId = internationalCurrencyId;
    }

    public StorageMedio getStorageMedioid() {
        return storageMedioid;
    }

    public void setStorageMedioid(StorageMedio storageMedioid) {
        this.storageMedioid = storageMedioid;
    }

    public CardRequest getCardRequest() {
        return cardRequest;
    }

    public void setCardRequest(CardRequest cardRequest) {
        this.cardRequest = cardRequest;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
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

    public Float getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Float minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Float getMaximumBalance() {
        return maximumBalance;
    }

    public void setMaximumBalance(Float maximumBalance) {
        this.maximumBalance = maximumBalance;
    }

    public ReviewCollectionsRequest getReviewCollectionsRequest() {
        return reviewCollectionsRequest;
    }

    public void setReviewCollectionsRequest(ReviewCollectionsRequest reviewCollectionsRequest) {
        this.reviewCollectionsRequest = reviewCollectionsRequest;
    }

    public ProductHasChannel getProductHasChannel() {
        return productHasChannel;
    }

    public void setProductHasChannel(ProductHasChannel productHasChannel) {
        this.productHasChannel = productHasChannel;
    }
    
}
