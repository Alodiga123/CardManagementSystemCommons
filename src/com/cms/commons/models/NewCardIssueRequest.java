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
@Table(name = "newCardIssueRequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewCardIssueRequest.findAll", query = "SELECT n FROM NewCardIssueRequest n"),
    @NamedQuery(name = "NewCardIssueRequest.findById", query = "SELECT n FROM NewCardIssueRequest n WHERE n.id = :id"),
    @NamedQuery(name = "NewCardIssueRequest.findByRequestNumber", query = "SELECT n FROM NewCardIssueRequest n WHERE n.requestNumber = :requestNumber"),
    @NamedQuery(name = "NewCardIssueRequest.findByRequestDate", query = "SELECT n FROM NewCardIssueRequest n WHERE n.requestDate = :requestDate"),
    @NamedQuery(name = "NewCardIssueRequest.findByObservations", query = "SELECT n FROM NewCardIssueRequest n WHERE n.observations = :observations"),
    @NamedQuery(name = "NewCardIssueRequest.findByIndConfirmation", query = "SELECT n FROM NewCardIssueRequest n WHERE n.indConfirmation = :indConfirmation"),
    @NamedQuery(name = "NewCardIssueRequest.findByNewCardIssueDate", query = "SELECT n FROM NewCardIssueRequest n WHERE n.newCardIssueDate = :newCardIssueDate"),
    @NamedQuery(name = "NewCardIssueRequest.findByCreateDate", query = "SELECT n FROM NewCardIssueRequest n WHERE n.createDate = :createDate"),
    @NamedQuery(name = "NewCardIssueRequest.findByUpdateDate", query = "SELECT n FROM NewCardIssueRequest n WHERE n.updateDate = :updateDate"),
    @NamedQuery(name = QueryConstants.NEW_CARD_ISSUE_BY_CARD, query = "SELECT n FROM NewCardIssueRequest n WHERE n.cardId.id = :cardId")})
public class NewCardIssueRequest extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 40)
    @Column(name = "requestNumber")
    private String requestNumber;
    @Column(name = "requestDate")
    @Temporal(TemporalType.DATE)
    private Date requestDate;
    @Size(max = 1500)
    @Column(name = "observations")
    private String observations;
    @Column(name = "indConfirmation")
    private Boolean indConfirmation;
    @Column(name = "newCardIssueDate")
    @Temporal(TemporalType.DATE)
    private Date newCardIssueDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @JoinColumn(name = "cardId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Card cardId;
    @JoinColumn(name = "statusNewCardIssueRequestId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StatusNewCardIssueRequest statusNewCardIssueRequestId;

    public NewCardIssueRequest() {
    }

    public NewCardIssueRequest(Long id) {
        this.id = id;
    }

    public NewCardIssueRequest(Long id, Date createDate) {
        this.id = id;
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

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Boolean getIndConfirmation() {
        return indConfirmation;
    }

    public void setIndConfirmation(Boolean indConfirmation) {
        this.indConfirmation = indConfirmation;
    }

    public Date getNewCardIssueDate() {
        return newCardIssueDate;
    }

    public void setNewCardIssueDate(Date newCardIssueDate) {
        this.newCardIssueDate = newCardIssueDate;
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

    public Card getCardId() {
        return cardId;
    }

    public void setCardId(Card cardId) {
        this.cardId = cardId;
    }

    public StatusNewCardIssueRequest getStatusNewCardIssueRequestId() {
        return statusNewCardIssueRequestId;
    }

    public void setStatusNewCardIssueRequestId(StatusNewCardIssueRequest statusNewCardIssueRequestId) {
        this.statusNewCardIssueRequestId = statusNewCardIssueRequestId;
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
        if (!(object instanceof NewCardIssueRequest)) {
            return false;
        }
        NewCardIssueRequest other = (NewCardIssueRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.NewCardIssueRequest[ id=" + id + " ]";
    }

    @Override
    public Object getPk() {
        return this.getId();
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
    }
}
