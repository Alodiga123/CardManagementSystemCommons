package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import com.cms.commons.util.QueryConstants;
import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Card.findAll", query = "SELECT c FROM Card c"),
    @NamedQuery(name = "Card.findById", query = "SELECT c FROM Card c WHERE c.id = :id"),
    @NamedQuery(name = "Card.findByCardNumber", query = "SELECT c FROM Card c WHERE c.cardNumber = :cardNumber"),
    @NamedQuery(name = "Card.findBySequentialNumber", query = "SELECT c FROM Card c WHERE c.sequentialNumber = :sequentialNumber"),
    @NamedQuery(name = "Card.findByIssueDate", query = "SELECT c FROM Card c WHERE c.issueDate = :issueDate"),
    @NamedQuery(name = "Card.findByExpirationDate", query = "SELECT c FROM Card c WHERE c.expirationDate = :expirationDate"),
    @NamedQuery(name = "Card.findBySecurityCodeCard", query = "SELECT c FROM Card c WHERE c.securityCodeCard = :securityCodeCard"),
    @NamedQuery(name = "Card.findBySecurityCodeMagneticStrip", query = "SELECT c FROM Card c WHERE c.securityCodeMagneticStrip = :securityCodeMagneticStrip"),
    @NamedQuery(name = "Card.findByICVVMagneticStrip", query = "SELECT c FROM Card c WHERE c.ICVVMagneticStrip = :ICVVMagneticStrip"),
    @NamedQuery(name = "Card.findByPinOffset", query = "SELECT c FROM Card c WHERE c.pinOffset = :pinOffset"),
    @NamedQuery(name = "Card.findByValidationData", query = "SELECT c FROM Card c WHERE c.validationData = :validationData"),
    @NamedQuery(name = "Card.findByPinLenght", query = "SELECT c FROM Card c WHERE c.pinLenght = :pinLenght"),
    @NamedQuery(name = QueryConstants.CARD_BY_PROGRAM, query = "SELECT c FROM Card c WHERE c.programId.id = :programId"),
    @NamedQuery(name = QueryConstants.CARD_BY_PROGRAM_BY_STATUS, query = "SELECT c FROM Card c WHERE c.programId.id = :programId AND c.productId.id = :productId AND c.cardStatusId.id = :cardStatusId"),
    @NamedQuery(name = QueryConstants.CARD_BY_STATUS, query = "SELECT c FROM Card c WHERE c.cardStatusId.id = :cardStatusId"),
    @NamedQuery(name = QueryConstants.CARD_BY_CARDNUMBER, query = "SELECT c FROM Card c WHERE c.cardNumber = :cardNumber AND c.cardStatusId.id = :cardStatusId"),
    @NamedQuery(name = QueryConstants.CARD_BY_IND_RENEWAL, query = "SELECT c FROM Card c WHERE c.indRenewal = :indRenewal AND c.cardStatusId.id = :cardStatusId"),
    @NamedQuery(name = QueryConstants.CARD_BY_CARDHOLDER, query = "SELECT c FROM Card c WHERE c.cardHolder = :cardHolder")})

public class Card extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 40)
    @Column(name = "cardNumber")
    private String cardNumber;
    @Column(name = "sequentialNumber")
    private Integer sequentialNumber;
    @Size(max = 50)
    @Column(name = "cardHolder")
    private String cardHolder;
    @Column(name = "issueDate")
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Column(name = "expirationDate")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @Size(max = 10)
    @Column(name = "securityCodeCard")
    private String securityCodeCard;
    @Size(max = 10)
    @Column(name = "securityCodeMagneticStrip")
    private String securityCodeMagneticStrip;
    @Size(max = 1500)
    @Column(name = "ICVVMagneticStrip")
    private String ICVVMagneticStrip;
    @Size(max = 40)
    @Column(name = "pinOffset")
    private String pinOffset;
    @Size(max = 40)
    @Column(name = "validationData")
    private String validationData;
    @Column(name = "pinLenght")
    private Integer pinLenght;
    @JoinColumn(name = "programId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Program programId;
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "cardStatusId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CardStatus cardStatusId;
    @JoinColumn(name = "personCustomerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person personCustomerId;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "indDeliveryRequest")
    private Boolean indDeliveryRequest;
    @Column(name = "automaticRenewalDate")
    @Temporal(TemporalType.DATE)
    private Date automaticRenewalDate;
    @Column(name = "indRenewal")
    private Boolean indRenewal;
    @Size(max = 1500)
    @Column(name = "observations")
    private String observations;
    @Column(name = "statusUpdateReasonDate")
    @Temporal(TemporalType.DATE)
    private Date statusUpdateReasonDate;
    @JoinColumn(name = "userResponsibleStatusUpdateId", referencedColumnName = "id")
    @ManyToOne
    private User userResponsibleStatusUpdateId;
    @JoinColumn(name = "statusUpdateReasonId", referencedColumnName = "id")
    @ManyToOne
    private StatusUpdateReason statusUpdateReasonId;

    public Card() {
    }

    public Card(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getSequentialNumber() {
        return sequentialNumber;
    }

    public void setSequentialNumber(Integer sequentialNumber) {
        this.sequentialNumber = sequentialNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecurityCodeCard() {
        return securityCodeCard;
    }

    public void setSecurityCodeCard(String securityCodeCard) {
        this.securityCodeCard = securityCodeCard;
    }

    public String getSecurityCodeMagneticStrip() {
        return securityCodeMagneticStrip;
    }

    public void setSecurityCodeMagneticStrip(String securityCodeMagneticStrip) {
        this.securityCodeMagneticStrip = securityCodeMagneticStrip;
    }

    public String getICVVMagneticStrip() {
        return ICVVMagneticStrip;
    }

    public void setICVVMagneticStrip(String ICVVMagneticStrip) {
        this.ICVVMagneticStrip = ICVVMagneticStrip;
    }

    public String getPinOffset() {
        return pinOffset;
    }

    public void setPinOffset(String pinOffset) {
        this.pinOffset = pinOffset;
    }

    public String getValidationData() {
        return validationData;
    }

    public void setValidationData(String validationData) {
        this.validationData = validationData;
    }

    public Integer getPinLenght() {
        return pinLenght;
    }

    public void setPinLenght(Integer pinLenght) {
        this.pinLenght = pinLenght;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public CardStatus getCardStatusId() {
        return cardStatusId;
    }

    public void setCardStatusId(CardStatus cardStatusId) {
        this.cardStatusId = cardStatusId;
    }

    public Person getPersonCustomerId() {
        return personCustomerId;
    }

    public void setPersonCustomerId(Person personCustomerId) {
        this.personCustomerId = personCustomerId;
    }

    public Boolean getIndDeliveryRequest() {
        return indDeliveryRequest;
    }

    public void setIndDeliveryRequest(Boolean indDeliveryRequest) {
        this.indDeliveryRequest = indDeliveryRequest;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Card)) {
            return false;
        }
        Card other = (Card) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.Card[ id=" + id + " ]";
    }

    @Override
    public Object getPk() {
        return getId();
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
    }

    public Date getAutomaticRenewalDate() {
        return automaticRenewalDate;
    }

    public void setAutomaticRenewalDate(Date automaticRenewalDate) {
        this.automaticRenewalDate = automaticRenewalDate;
    }

    public Boolean getIndRenewal() {
        return indRenewal;
    }

    public void setIndRenewal(Boolean indRenewal) {
        this.indRenewal = indRenewal;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Date getStatusUpdateReasonDate() {
        return statusUpdateReasonDate;
    }

    public void setStatusUpdateReasonDate(Date statusUpdateReasonDate) {
        this.statusUpdateReasonDate = statusUpdateReasonDate;
    }

    public User getUserResponsibleStatusUpdateId() {
        return userResponsibleStatusUpdateId;
    }

    public void setUserResponsibleStatusUpdateId(User userResponsibleStatusUpdateId) {
        this.userResponsibleStatusUpdateId = userResponsibleStatusUpdateId;
    }

    public StatusUpdateReason getStatusUpdateReasonId() {
        return statusUpdateReasonId;
    }

    public void setStatusUpdateReasonId(StatusUpdateReason statusUpdateReasonId) {
        this.statusUpdateReasonId = statusUpdateReasonId;
    }

}
