/*
040922815
 */
package cst8218.asim.buisness;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ajasa
 */
@Entity
@Table(name = "EXAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e"),
    @NamedQuery(name = "Exam.findById", query = "SELECT e FROM Exam e WHERE e.id = :id"),
    @NamedQuery(name = "Exam.findByNamess21jasa", query = "SELECT e FROM Exam e WHERE e.namesS21Jasa = :namesS21Jasa"),
    @NamedQuery(name = "Exam.findByQuantitys21jasa", query = "SELECT e FROM Exam e WHERE e.quantityS21Jasa = :quantityS21Jasa")})
public class WidgetSummer815 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "NAMESS21JASA")
    private String namesS21Jasa;
    @Column(name = "QUANTITYS21JASA")
    private Integer quantityS21Jasa;

    public WidgetSummer815() {
    }

    public WidgetSummer815(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamess21jasa() {
        return namesS21Jasa;
    }

    public void setNamess21jasa(String namesS21Jasa) {
        this.namesS21Jasa = namesS21Jasa;
    }

    public Integer getQuantitys21jasa() {
        return quantityS21Jasa;
    }

    public void setQuantitys21jasa(Integer quantityS21Jasa) {
        this.quantityS21Jasa = quantityS21Jasa;
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
        if (!(object instanceof WidgetSummer815)) {
            return false;
        }
        WidgetSummer815 other = (WidgetSummer815) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.widgetappjasarevic.Exam[ id=" + id + " ]";
    }
    
}
