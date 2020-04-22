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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "deliveryRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeliveryRequest.findAll", query = "SELECT d FROM DeliveryRequest d"),
    @NamedQuery(name = "DeliveryRequest.findById", query = "SELECT d FROM DeliveryRequest d WHERE d.id = :id"),
    @NamedQuery(name = "DeliveryRequest.findByRequestNumber", query = "SELECT d FROM DeliveryRequest d WHERE d.requestNumber = :requestNumber"),
    @NamedQuery(name = "DeliveryRequest.findByRequestDate", query = "SELECT d FROM DeliveryRequest d WHERE d.requestDate = :requestDate"),
    @NamedQuery(name = "DeliveryRequest.findByShippingGuideNumber", query = "SELECT d FROM DeliveryRequest d WHERE d.shippingGuideNumber = :shippingGuideNumber"),
    @NamedQuery(name = "DeliveryRequest.findByAmountCards", query = "SELECT d FROM DeliveryRequest d WHERE d.amountCards = :amountCards"),
    @NamedQuery(name = "DeliveryRequest.findByCreateDate", query = "SELECT d FROM DeliveryRequest d WHERE d.createDate = :createDate"),
    @NamedQuery(name = "DeliveryRequest.findByUpdateDate", query = "SELECT d FROM DeliveryRequest d WHERE d.updateDate = :updateDate")})
public class DeliveryRequest extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "requestNumber")
    private String requestNumber;
    @Column(name = "requestDate")
    @Temporal(TemporalType.DATE)
    private Date requestDate;
    @Size(max = 40)
    @Column(name = "shippingGuideNumber")
    private String shippingGuideNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amountCards")
    private int amountCards;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "deliveryRequestId")
    private DeliveryRequetsHasCard deliveryRequetsHasCard;
    @JoinColumn(name = "ShippingCompanyId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LegalPerson shippingCompanyId;
    @JoinColumn(name = "programId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Program programId;
    @JoinColumn(name = "statusDeliveryRequestId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusDeliveryRequest statusDeliveryRequestId;

    public DeliveryRequest() {
    }

    public DeliveryRequest(Long id) {
        this.id = id;
    }

    public DeliveryRequest(Long id, String requestNumber, int amountCards, Date createDate) {
        this.id = id;
        this.requestNumber = requestNumber;
        this.amountCards = amountCards;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getShippingGuideNumber() {
        return shippingGuideNumber;
    }

    public void setShippingGuideNumber(String shippingGuideNumber) {
        this.shippingGuideNumber = shippingGuideNumber;
    }

    public int getAmountCards() {
        return amountCards;
    }

    public void setAmountCards(int amountCards) {
        this.amountCards = amountCards;
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

    public DeliveryRequetsHasCard getDeliveryRequetsHasCard() {
        return deliveryRequetsHasCard;
    }

    public void setDeliveryRequetsHasCard(DeliveryRequetsHasCard deliveryRequetsHasCard) {
        this.deliveryRequetsHasCard = deliveryRequetsHasCard;
    }

    public LegalPerson getShippingCompanyId() {
        return shippingCompanyId;
    }

    public void setShippingCompanyId(LegalPerson shippingCompanyId) {
        this.shippingCompanyId = shippingCompanyId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public StatusDeliveryRequest getStatusDeliveryRequestId() {
        return statusDeliveryRequestId;
    }

    public void setStatusDeliveryRequestId(StatusDeliveryRequest statusDeliveryRequestId) {
        this.statusDeliveryRequestId = statusDeliveryRequestId;
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
        if (!(object instanceof DeliveryRequest)) {
            return false;
        }
        DeliveryRequest other = (DeliveryRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.DeliveryRequest[ id=" + id + " ]";
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
