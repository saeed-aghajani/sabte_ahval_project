/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saeed
 */
@Entity
@Table(name = "documents", catalog = "sabte_ahval", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documents.findAll", query = "SELECT d FROM Documents d")
    , @NamedQuery(name = "Documents.findById", query = "SELECT d FROM Documents d WHERE d.id = :id")
    , @NamedQuery(name = "Documents.findByLogDate", query = "SELECT d FROM Documents d WHERE d.logDate = :logDate")
    , @NamedQuery(name = "Documents.findByDescription", query = "SELECT d FROM Documents d WHERE d.description = :description")
    , @NamedQuery(name = "Documents.findByCosts", query = "SELECT d FROM Documents d WHERE d.costs = :costs")
    , @NamedQuery(name = "Documents.findByDiscriminatorColumn", query = "SELECT d FROM Documents d WHERE d.discriminatorColumn = :discriminatorColumn")
    , @NamedQuery(name = "Documents.findByDiscriminatorColumnId", query = "SELECT d FROM Documents d WHERE d.discriminatorColumnId = :discriminatorColumnId")})
public class Documents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "log_date")
    @Temporal(TemporalType.DATE)
    private Date logDate;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "costs")
    private BigInteger costs;
    @Basic(optional = false)
    @Column(name = "discriminator_column")
    private Character discriminatorColumn;
    @Basic(optional = false)
    @Column(name = "discriminator_column_id")
    private int discriminatorColumnId;
    @JoinColumn(name = "responsible_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ResponsibleInformation responsibleId;

    public Documents() {
    }

    public Documents(Integer id) {
        this.id = id;
    }

    public Documents(Integer id, Date logDate, String description, BigInteger costs, Character discriminatorColumn, int discriminatorColumnId) {
        this.id = id;
        this.logDate = logDate;
        this.description = description;
        this.costs = costs;
        this.discriminatorColumn = discriminatorColumn;
        this.discriminatorColumnId = discriminatorColumnId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getCosts() {
        return costs;
    }

    public void setCosts(BigInteger costs) {
        this.costs = costs;
    }

    public Character getDiscriminatorColumn() {
        return discriminatorColumn;
    }

    public void setDiscriminatorColumn(Character discriminatorColumn) {
        this.discriminatorColumn = discriminatorColumn;
    }

    public int getDiscriminatorColumnId() {
        return discriminatorColumnId;
    }

    public void setDiscriminatorColumnId(int discriminatorColumnId) {
        this.discriminatorColumnId = discriminatorColumnId;
    }

    public ResponsibleInformation getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(ResponsibleInformation responsibleId) {
        this.responsibleId = responsibleId;
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
        if (!(object instanceof Documents)) {
            return false;
        }
        Documents other = (Documents) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Documents[ id=" + id + " ]";
    }
    
}
