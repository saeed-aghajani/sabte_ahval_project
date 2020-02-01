/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saeed
 */
@Entity
@Table(name = "birth_certificate", catalog = "sabte_ahval", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BirthCertificate.findAll", query = "SELECT b FROM BirthCertificate b")
    , @NamedQuery(name = "BirthCertificate.findById", query = "SELECT b FROM BirthCertificate b WHERE b.id = :id")
    , @NamedQuery(name = "BirthCertificate.findByFirstName", query = "SELECT b FROM BirthCertificate b WHERE b.firstName = :firstName")
    , @NamedQuery(name = "BirthCertificate.findByLastName", query = "SELECT b FROM BirthCertificate b WHERE b.lastName = :lastName")
    , @NamedQuery(name = "BirthCertificate.findByFatherName", query = "SELECT b FROM BirthCertificate b WHERE b.fatherName = :fatherName")
    , @NamedQuery(name = "BirthCertificate.findByMotherName", query = "SELECT b FROM BirthCertificate b WHERE b.motherName = :motherName")
    , @NamedQuery(name = "BirthCertificate.findByGender", query = "SELECT b FROM BirthCertificate b WHERE b.gender = :gender")
    , @NamedQuery(name = "BirthCertificate.findBySeri", query = "SELECT b FROM BirthCertificate b WHERE b.seri = :seri")
    , @NamedQuery(name = "BirthCertificate.findBySeryal", query = "SELECT b FROM BirthCertificate b WHERE b.seryal = :seryal")
    , @NamedQuery(name = "BirthCertificate.findByBirthdate", query = "SELECT b FROM BirthCertificate b WHERE b.birthdate = :birthdate")
    , @NamedQuery(name = "BirthCertificate.findByBirthLocation", query = "SELECT b FROM BirthCertificate b WHERE b.birthLocation = :birthLocation")
    , @NamedQuery(name = "BirthCertificate.findByCertificateNumber", query = "SELECT b FROM BirthCertificate b WHERE b.certificateNumber = :certificateNumber")
    , @NamedQuery(name = "BirthCertificate.findByIssueDate", query = "SELECT b FROM BirthCertificate b WHERE b.issueDate = :issueDate")
    , @NamedQuery(name = "BirthCertificate.findByIsReplica", query = "SELECT b FROM BirthCertificate b WHERE b.isReplica = :isReplica")
    , @NamedQuery(name = "BirthCertificate.findByIsIssued", query = "SELECT b FROM BirthCertificate b WHERE b.isIssued = :isIssued")
    , @NamedQuery(name = "BirthCertificate.findByRegisterDate", query = "SELECT b FROM BirthCertificate b WHERE b.registerDate = :registerDate")
    , @NamedQuery(name = "BirthCertificate.findByIsDelivered", query = "SELECT b FROM BirthCertificate b WHERE b.isDelivered = :isDelivered")
    , @NamedQuery(name = "BirthCertificate.findByDeliverDate", query = "SELECT b FROM BirthCertificate b WHERE b.deliverDate = :deliverDate")
    , @NamedQuery(name = "BirthCertificate.findByCertIdSeriSeryal", query = "SELECT b FROM BirthCertificate b WHERE b.certificateNumber = :certificateNumber AND b.seri = :seri AND b.seryal = :seryal")
    , @NamedQuery(name = "BirthCertificate.updateIssuance", query = "UPDATE BirthCertificate b SET b.isIssued = :isIssued, b.isReplica = :isReplica, b.issueDate = :issueDate WHERE b.certificateNumber = :certificateNumber AND b.seri = :seri AND b.seryal = :seryal")
    , @NamedQuery(name = "BirthCertificate.updateDelivery", query = "UPDATE BirthCertificate b SET b.isDelivered = :isDeliver, b.deliverDate = :deliverDate WHERE b.certificateNumber = :certificateNumber AND b.seri = :seri AND b.seryal = :seryal")
        
})
public class BirthCertificate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "father_name")
    private String fatherName;
    @Basic(optional = false)
    @Column(name = "mother_name")
    private String motherName;
    @Basic(optional = false)
    @Column(name = "gender")
    private Character gender;
    @Basic(optional = false)
    @Column(name = "seri")
    private String seri;
    @Basic(optional = false)
    @Column(name = "seryal")
    private String seryal;
    @Basic(optional = false)
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Basic(optional = false)
    @Column(name = "birth_location")
    private String birthLocation;
    @Basic(optional = false)
    @Column(name = "certificate_number")
    private String certificateNumber;
    @Column(name = "issue_date")
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Basic(optional = false)
    @Column(name = "is_replica")
    private boolean isReplica;
    @Basic(optional = false)
    @Column(name = "is_issued")
    private boolean isIssued;
    @Basic(optional = false)
    @Column(name = "register_date")
    @Temporal(TemporalType.DATE)
    private Date registerDate;
    @Basic(optional = false)
    @Column(name = "is_delivered")
    private boolean isDelivered;
    @Column(name = "deliver_date")
    @Temporal(TemporalType.DATE)
    private Date deliverDate;

    public BirthCertificate() {
    }

    public BirthCertificate(Integer id) {
        this.id = id;
    }

    public BirthCertificate(Integer id, String firstName, String lastName, String fatherName, String motherName, Character gender, String seri, String seryal, Date birthdate, String birthLocation, String certificateNumber, boolean isReplica, boolean isIssued, Date registerDate, boolean isDelivered) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.gender = gender;
        this.seri = seri;
        this.seryal = seryal;
        this.birthdate = birthdate;
        this.birthLocation = birthLocation;
        this.certificateNumber = certificateNumber;
        this.isReplica = isReplica;
        this.isIssued = isIssued;
        this.registerDate = registerDate;
        this.isDelivered = isDelivered;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getSeri() {
        return seri;
    }

    public void setSeri(String seri) {
        this.seri = seri;
    }

    public String getSeryal() {
        return seryal;
    }

    public void setSeryal(String seryal) {
        this.seryal = seryal;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthLocation() {
        return birthLocation;
    }

    public void setBirthLocation(String birthLocation) {
        this.birthLocation = birthLocation;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public boolean getIsReplica() {
        return isReplica;
    }

    public void setIsReplica(boolean isReplica) {
        this.isReplica = isReplica;
    }

    public boolean getIsIssued() {
        return isIssued;
    }

    public void setIsIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
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
        if (!(object instanceof BirthCertificate)) {
            return false;
        }
        BirthCertificate other = (BirthCertificate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BirthCertificate[ id=" + id + " ]";
    }
    
}
