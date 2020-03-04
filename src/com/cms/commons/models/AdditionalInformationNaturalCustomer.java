/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "additionalInformationNaturalCustomer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdditionalInformationNaturalCustomer.findAll", query = "SELECT a FROM AdditionalInformationNaturalCustomer a")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findById", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.id = :id")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByFirstNamesHusband", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.firstNamesHusband = :firstNamesHusband")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByLastNamesHusband", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.lastNamesHusband = :lastNamesHusband")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByIdentificationNumberHusband", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.identificationNumberHusband = :identificationNumberHusband")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByPhoneHusband", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.phoneHusband = :phoneHusband")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByEmailHusband", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.emailHusband = :emailHusband")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByCarBrand", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.carBrand = :carBrand")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByCarModel", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.carModel = :carModel")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByCarYear", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.carYear = :carYear")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByCarPlate", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.carPlate = :carPlate")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findBySalary", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.salary = :salary")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByFreeProfessionalExercise", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.freeProfessionalExercise = :freeProfessionalExercise")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByBonusesCommissionsFee", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.bonusesCommissionsFee = :bonusesCommissionsFee")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByRentsIncome", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.rentsIncome = :rentsIncome")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByOtherIncome", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.otherIncome = :otherIncome")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByTotalIncome", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.totalIncome = :totalIncome")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByHousingExpenses", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.housingExpenses = :housingExpenses")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByMonthlyRentMortgage", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.monthlyRentMortgage = :monthlyRentMortgage")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByMonthlyPaymentCreditCard", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.monthlyPaymentCreditCard = :monthlyPaymentCreditCard")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByMonthlyPaymentOtherCredit", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.monthlyPaymentOtherCredit = :monthlyPaymentOtherCredit")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByEducationExpenses", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.educationExpenses = :educationExpenses")
    , @NamedQuery(name = "AdditionalInformationNaturalCustomer.findByTotalExpenses", query = "SELECT a FROM AdditionalInformationNaturalCustomer a WHERE a.totalExpenses = :totalExpenses")})

public class AdditionalInformationNaturalCustomer extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 40)
    @Column(name = "firstNamesHusband")
    private String firstNamesHusband;
    @Size(max = 40)
    @Column(name = "lastNamesHusband")
    private String lastNamesHusband;
    @Size(max = 40)
    @Column(name = "identificationNumberHusband")
    private String identificationNumberHusband;
    @Size(max = 30)
    @Column(name = "phoneHusband")
    private String phoneHusband;
    @Size(max = 60)
    @Column(name = "emailHusband")
    private String emailHusband;
    @Size(max = 40)
    @Column(name = "carBrand")
    private String carBrand;
    @Size(max = 40)
    @Column(name = "carModel")
    private String carModel;
    @Column(name = "carYear")
    private Integer carYear;
    @Size(max = 20)
    @Column(name = "carPlate")
    private String carPlate;
    @Column(name = "salary")
    private Float salary;
    @Column(name = "freeProfessionalExercise")
    private Float freeProfessionalExercise;
    @Column(name = "bonusesCommissionsFee")
    private Float bonusesCommissionsFee;
    @Column(name = "rentsIncome")
    private Float rentsIncome;
    @Column(name = "otherIncome")
    private Float otherIncome;
    @Column(name = "totalIncome")
    private Float totalIncome;
    @Column(name = "housingExpenses")
    private Float housingExpenses;
    @Column(name = "monthlyRentMortgage")
    private Float monthlyRentMortgage;
    @Column(name = "monthlyPaymentCreditCard")
    private Float monthlyPaymentCreditCard;
    @Column(name = "monthlyPaymentOtherCredit")
    private Float monthlyPaymentOtherCredit;
    @Column(name = "educationExpenses")
    private Float educationExpenses;
    @Column(name = "totalExpenses")
    private Float totalExpenses;
    @JoinColumn(name = "naturalCustomerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NaturalCustomer naturalCustomerId;
    @JoinColumn(name = "documentsPersonTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentsPersonType documentsPersonTypeId;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;

    public AdditionalInformationNaturalCustomer() {
    }

    public AdditionalInformationNaturalCustomer(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstNamesHusband() {
        return firstNamesHusband;
    }

    public void setFirstNamesHusband(String firstNamesHusband) {
        this.firstNamesHusband = firstNamesHusband;
    }

    public String getLastNamesHusband() {
        return lastNamesHusband;
    }

    public void setLastNamesHusband(String lastNamesHusband) {
        this.lastNamesHusband = lastNamesHusband;
    }

    public String getIdentificationNumberHusband() {
        return identificationNumberHusband;
    }

    public void setIdentificationNumberHusband(String identificationNumberHusband) {
        this.identificationNumberHusband = identificationNumberHusband;
    }

    public String getPhoneHusband() {
        return phoneHusband;
    }

    public void setPhoneHusband(String phoneHusband) {
        this.phoneHusband = phoneHusband;
    }

    public String getEmailHusband() {
        return emailHusband;
    }

    public void setEmailHusband(String emailHusband) {
        this.emailHusband = emailHusband;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getCarYear() {
        return carYear;
    }

    public void setCarYear(Integer carYear) {
        this.carYear = carYear;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Float getFreeProfessionalExercise() {
        return freeProfessionalExercise;
    }

    public void setFreeProfessionalExercise(Float freeProfessionalExercise) {
        this.freeProfessionalExercise = freeProfessionalExercise;
    }

    public Float getBonusesCommissionsFee() {
        return bonusesCommissionsFee;
    }

    public void setBonusesCommissionsFee(Float bonusesCommissionsFee) {
        this.bonusesCommissionsFee = bonusesCommissionsFee;
    }

    public Float getRentsIncome() {
        return rentsIncome;
    }

    public void setRentsIncome(Float rentsIncome) {
        this.rentsIncome = rentsIncome;
    }

    public Float getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(Float otherIncome) {
        this.otherIncome = otherIncome;
    }

    public Float getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Float totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Float getHousingExpenses() {
        return housingExpenses;
    }

    public void setHousingExpenses(Float housingExpenses) {
        this.housingExpenses = housingExpenses;
    }

    public Float getMonthlyRentMortgage() {
        return monthlyRentMortgage;
    }

    public void setMonthlyRentMortgage(Float monthlyRentMortgage) {
        this.monthlyRentMortgage = monthlyRentMortgage;
    }

    public Float getMonthlyPaymentCreditCard() {
        return monthlyPaymentCreditCard;
    }

    public void setMonthlyPaymentCreditCard(Float monthlyPaymentCreditCard) {
        this.monthlyPaymentCreditCard = monthlyPaymentCreditCard;
    }

    public Float getMonthlyPaymentOtherCredit() {
        return monthlyPaymentOtherCredit;
    }

    public void setMonthlyPaymentOtherCredit(Float monthlyPaymentOtherCredit) {
        this.monthlyPaymentOtherCredit = monthlyPaymentOtherCredit;
    }

    public Float getEducationExpenses() {
        return educationExpenses;
    }

    public void setEducationExpenses(Float educationExpenses) {
        this.educationExpenses = educationExpenses;
    }

    public Float getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(Float totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public NaturalCustomer getNaturalCustomerId() {
        return naturalCustomerId;
    }

    public void setNaturalCustomerId(NaturalCustomer naturalCustomerId) {
        this.naturalCustomerId = naturalCustomerId;
    }

    public DocumentsPersonType getDocumentsPersonTypeId() {
        return documentsPersonTypeId;
    }

    public void setDocumentsPersonTypeId(DocumentsPersonType documentsPersonTypeId) {
        this.documentsPersonTypeId = documentsPersonTypeId;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
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
        if (!(object instanceof AdditionalInformationNaturalCustomer)) {
            return false;
        }
        AdditionalInformationNaturalCustomer other = (AdditionalInformationNaturalCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.AdditionalInformationNaturalCustomer[ id=" + id + " ]";
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
