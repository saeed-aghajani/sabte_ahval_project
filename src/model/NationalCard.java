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
@Table(name = "national_card", catalog = "sabte_ahval", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NationalCard.findAll", query = "SELECT n FROM NationalCard n")
    , @NamedQuery(name = "NationalCard.findById", query = "SELECT n FROM NationalCard n WHERE n.id = :id")
    , @NamedQuery(name = "NationalCard.findByFirstName", query = "SELECT n FROM NationalCard n WHERE n.firstName = :firstName")
    , @NamedQuery(name = "NationalCard.findByLastName", query = "SELECT n FROM NationalCard n WHERE n.lastName = :lastName")
    , @NamedQuery(name = "NationalCard.findByFatherName", query = "SELECT n FROM NationalCard n WHERE n.fatherName = :fatherName")
    , @NamedQuery(name = "NationalCard.findByBirthdate", query = "SELECT n FROM NationalCard n WHERE n.birthdate = :birthdate")
    , @NamedQuery(name = "NationalCard.findByNid", query = "SELECT n FROM NationalCard n WHERE n.nid = :nid")
    , @NamedQuery(name = "NationalCard.findByExpireDate", query = "SELECT n FROM NationalCard n WHERE n.expireDate = :expireDate")
    , @NamedQuery(name = "NationalCard.findByIsReplica", query = "SELECT n FROM NationalCard n WHERE n.isReplica = :isReplica")
    , @NamedQuery(name = "NationalCard.findByIsIssued", query = "SELECT n FROM NationalCard n WHERE n.isIssued = :isIssued")
    , @NamedQuery(name = "NationalCard.findByIssueDate", query = "SELECT n FROM NationalCard n WHERE n.issueDate = :issueDate")
    , @NamedQuery(name = "NationalCard.findByIsDelivered", query = "SELECT n FROM NationalCard n WHERE n.isDelivered = :isDelivered")
    , @NamedQuery(name = "NationalCard.findByDeliverDate", query = "SELECT n FROM NationalCard n WHERE n.deliverDate = :deliverDate")
    , @NamedQuery(name = "NationalCard.updateIssuance", query = "UPDATE NationalCard b SET b.isIssued = :isIssued, b.isReplica = :isReplica, b.issueDate = :issueDate WHERE b.nid = :nid ")
    , @NamedQuery(name = "NationalCard.updateDelivery", query = "UPDATE NationalCard b SET b.isDelivered = :isDeliver, b.deliverDate = :deliverDate WHERE b.nid = :nid")})
public class NationalCard implements Serializable {

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
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Basic(optional = false)
    @Column(name = "nid")
    private String nid;
    @Basic(optional = false)
    @Column(name = "expire_date")
    @Temporal(TemporalType.DATE)
    private Date expireDate;
    @Basic(optional = false)
    @Column(name = "is_replica")
    private boolean isReplica;
    @Basic(optional = false)
    @Column(name = "is_issued")
    private boolean isIssued;
    @Column(name = "issue_date")
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Basic(optional = false)
    @Column(name = "is_delivered")
    private boolean isDelivered;
    @Column(name = "deliver_date")
    @Temporal(TemporalType.DATE)
    private Date deliverDate;

    public NationalCard() {
    }

    public NationalCard(Integer id) {
        this.id = id;
    }

    public NationalCard(Integer id, String firstName, String lastName, String fatherName, Date birthdate, String nid, Date expireDate, boolean isReplica, boolean isIssued, boolean isDelivered) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.birthdate = birthdate;
        this.nid = nid;
        this.expireDate = expireDate;
        this.isReplica = isReplica;
        this.isIssued = isIssued;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
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
        if (!(object instanceof NationalCard)) {
            return false;
        }
        NationalCard other = (NationalCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.NationalCard[ id=" + id + " ]";
    }
    
}
