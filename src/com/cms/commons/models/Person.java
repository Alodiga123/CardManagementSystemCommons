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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByCreateDate", query = "SELECT p FROM Person p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Person.findByUpdateDate", query = "SELECT p FROM Person p WHERE p.updateDate = :updateDate"),
    @NamedQuery(name = "Person.lastPerson", query = "SELECT p FROM Person p ORDER BY p.id DESC"),
    @NamedQuery(name = QueryConstants.PERSON_BY_CLASIFICATION, query = "SELECT p FROM Person p WHERE p.personClassificationId.id=:personClassificationId")})
public class Person extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private ApplicantNaturalPerson applicantNaturalPerson;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "programOwnerId")
    private Program program;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cardProgramManagerId")
    private Program program1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private PhonePerson phonePerson;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "issuerPersonId")
    private Issuer issuer;
    @JoinColumn(name = "countryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country countryId;
    @JoinColumn(name = "personTypeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PersonType personTypeId;
    @JoinColumn(name = "personClassificationId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PersonClassification personClassificationId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private CardRequestNaturalPerson cardRequestNaturalPerson;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private LegalRepresentatives legalRepresentatives;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private LegalPerson legalPerson;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private NaturalPerson naturalPerson;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private PersonHasAddress personHasAddress;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private Request request;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private Employee employee;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private User user;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private ReviewOFAC reviewOFAC;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personId")
    private PlasticManufacturer plasticManufacturer;

    public Person() {
    }

    public Person(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public ApplicantNaturalPerson getApplicantNaturalPerson() {
        return applicantNaturalPerson;
    }

    public void setApplicantNaturalPerson(ApplicantNaturalPerson applicantNaturalPerson) {
        this.applicantNaturalPerson = applicantNaturalPerson;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Program getProgram1() {
        return program1;
    }

    public void setProgram1(Program program1) {
        this.program1 = program1;
    }

    public PhonePerson getPhonePerson() {
        return phonePerson;
    }

    public void setPhonePerson(PhonePerson phonePerson) {
        this.phonePerson = phonePerson;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public PersonType getPersonTypeId() {
        return personTypeId;
    }

    public void setPersonTypeId(PersonType personTypeId) {
        this.personTypeId = personTypeId;
    }

    public PersonClassification getPersonClassificationId() {
        return personClassificationId;
    }

    public void setPersonClassificationId(PersonClassification personClassificationId) {
        this.personClassificationId = personClassificationId;
    }

    public CardRequestNaturalPerson getCardRequestNaturalPerson() {
        return cardRequestNaturalPerson;
    }

    public void setCardRequestNaturalPerson(CardRequestNaturalPerson cardRequestNaturalPerson) {
        this.cardRequestNaturalPerson = cardRequestNaturalPerson;
    }

    public LegalRepresentatives getLegalRepresentatives() {
        return legalRepresentatives;
    }

    public void setLegalRepresentatives(LegalRepresentatives legalRepresentatives) {
        this.legalRepresentatives = legalRepresentatives;
    }

    public LegalPerson getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(LegalPerson legalPerson) {
        this.legalPerson = legalPerson;
    }

    public NaturalPerson getNaturalPerson() {
        return naturalPerson;
    }

    public void setNaturalPerson(NaturalPerson naturalPerson) {
        this.naturalPerson = naturalPerson;
    }

    public PersonHasAddress getPersonHasAddress() {
        return personHasAddress;
    }

    public void setPersonHasAddress(PersonHasAddress personHasAddress) {
        this.personHasAddress = personHasAddress;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.Person[ id=" + id + " ]";
    }

    @Override
    public Object getPk() {
        return getId();
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReviewOFAC getReviewOFAC() {
        return reviewOFAC;
    }

    public void setReviewOFAC(ReviewOFAC reviewOFAC) {
        this.reviewOFAC = reviewOFAC;
    }

    public PlasticManufacturer getPlasticManufacturer() {
        return plasticManufacturer;
    }

    public void setPlasticManufacturer(PlasticManufacturer plasticManufacturer) {
        this.plasticManufacturer = plasticManufacturer;
    }

}
