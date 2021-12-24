/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 *Class:    Appuser
 *Author    Asim Jasarevic & Nathan Denyer
 *project:  Assignment 02
 */
package cst8218.jasa0008.entity;

import java.io.Serializable;
import java.util.HashMap;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ajasa
 */
@Entity
@Table(name = "APPUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appuser.findAll", query = "SELECT a FROM Appuser a"),
    @NamedQuery(name = "Appuser.findById", query = "SELECT a FROM Appuser a WHERE a.id = :id"),
    @NamedQuery(name = "Appuser.findByEmail", query = "SELECT a FROM Appuser a WHERE a.email = :email"),
    @NamedQuery(name = "Appuser.findByFirstname", query = "SELECT a FROM Appuser a WHERE a.firstname = :firstname"),
    @NamedQuery(name = "Appuser.findByLastname", query = "SELECT a FROM Appuser a WHERE a.lastname = :lastname"),
    @NamedQuery(name = "Appuser.findByPassword", query = "SELECT a FROM Appuser a WHERE a.password = :password"),
    @NamedQuery(name = "Appuser.findByGroupname", query = "SELECT a FROM Appuser a WHERE a.groupname = :groupname")})
public class Appuser implements Serializable {

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 255)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 255)
    @Column(name = "GROUPNAME")
    private String groupname;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name = "ID")
    private Long id;

    public Appuser() {
    }

    public Appuser(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Appuser)) {
            return false;
        }
        Appuser other = (Appuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "com.mycompany.appuser.Appuser[ id=" + id + " ]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
       // return password;
       return null;
    }

    public void setPassword(String password) {
        //initialize a PasswordHash object which will generate password hashes
        Instance<? extends PasswordHash> instance = CDI.current().select(Pbkdf2PasswordHash.class);
        PasswordHash passwordHash = instance.get();
        passwordHash.initialize(new HashMap<String,String>()); // todo: are the defaults good enough?
        // now we can generate a password entry for a given password
        String passwordEntry = password; //pretend the user has chosen a passwordmySecretPassword
        passwordEntry = passwordHash.generate(passwordEntry.toCharArray());
        //at this point, passwordEntry refers to a salted/hashed password entry corresponding tomySecretPasswor
        this.password = passwordEntry;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    
}
