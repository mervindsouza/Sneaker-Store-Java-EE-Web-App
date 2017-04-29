/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.domain;

import edu.iit.sat.itmd4515.mdsouza5.domain.security.User;
import java.util.Date;
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

/**
 *
 * @author Dethrone
 */
@Entity
@Table(name = "seller")
@SuppressWarnings("SerializableClass")
@NamedQueries({
    @NamedQuery(name = "Seller.findAll", query = "select s from Seller s")
    ,
    @NamedQuery(name = "Seller.findByUsername", query = "select s from Seller s where s.user.userName =:username")
    ,
    @NamedQuery(name = "Seller.findByName", query = "select s from Seller s where s.sellerName = :sellerName")})
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sellerName;
    private String sellerEmail;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    private String sellerLocation;

    @ManyToOne
    @JoinColumn(name = "ADMIN_ID")
    private Administrator administrator;

    public Seller() {
    }

    public Seller(String sellerName, String sellerEmail, Date dateCreated, String sellerLocation) {
        this.sellerName = sellerName;
        this.sellerEmail = sellerEmail;
        this.dateCreated = dateCreated;
        this.sellerLocation = sellerLocation;
    }

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getSellerLocation() {
        return sellerLocation;
    }

    public void setSellerLocation(String sellerLocation) {
        this.sellerLocation = sellerLocation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

}
