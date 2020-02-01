/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saeed
 */
@Entity
@Table(name = "responsible_information", catalog = "sabte_ahval", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResponsibleInformation.findAll", query = "SELECT r FROM ResponsibleInformation r")
    , @NamedQuery(name = "ResponsibleInformation.findById", query = "SELECT r FROM ResponsibleInformation r WHERE r.id = :id")
    , @NamedQuery(name = "ResponsibleInformation.findByUsername", query = "SELECT r FROM ResponsibleInformation r WHERE r.username = :username")
    , @NamedQuery(name = "ResponsibleInformation.findByPassword", query = "SELECT r FROM ResponsibleInformation r WHERE r.password = :password")
    , @NamedQuery(name = "ResponsibleInformation.findByNationalCode", query = "SELECT r FROM ResponsibleInformation r WHERE r.nationalCode = :nationalCode")
    , @NamedQuery(name = "ResponsibleInformation.findByFirstName", query = "SELECT r FROM ResponsibleInformation r WHERE r.firstName = :firstName")
    , @NamedQuery(name = "ResponsibleInformation.findByLastName", query = "SELECT r FROM ResponsibleInformation r WHERE r.lastName = :lastName")
    , @NamedQuery(name = "ResponsibleInformation.findByPhone", query = "SELECT r FROM ResponsibleInformation r WHERE r.phone = :phone")
    , @NamedQuery(name = "ResponsibleInformation.findByAddress", query = "SELECT r FROM ResponsibleInformation r WHERE r.address = :address")
    , @NamedQuery(name = "ResponsibleInformation.findByIsAdmin", query = "SELECT r FROM ResponsibleInformation r WHERE r.isAdmin = :isAdmin")
    , @NamedQuery(name = "ResponsibleInformation.findByEducation", query = "SELECT r FROM ResponsibleInformation r WHERE r.education = :education")})
public class ResponsibleInformation implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsibleId")
    private List<Documents> documentsList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "national_code")
    private String nationalCode;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "is_admin")
    private boolean isAdmin;
    @Basic(optional = false)
    @Column(name = "education")
    private String education;

    public ResponsibleInformation() {
    }

    public ResponsibleInformation(Integer id) {
        this.id = id;
    }

    public ResponsibleInformation(Integer id, String username, String password, String nationalCode, String firstName, String lastName, String phone, String address, boolean isAdmin, String education) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nationalCode = nationalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.isAdmin = isAdmin;
        this.education = education;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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
        if (!(object instanceof ResponsibleInformation)) {
            return false;
        }
        ResponsibleInformation other = (ResponsibleInformation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ResponsibleInformation[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Documents> getDocumentsList() {
        return documentsList;
    }

    public void setDocumentsList(List<Documents> documentsList) {
        this.documentsList = documentsList;
    }
    
}
