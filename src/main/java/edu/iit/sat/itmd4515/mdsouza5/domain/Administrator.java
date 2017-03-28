/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.domain;

import edu.iit.sat.itmd4515.mdsouza5.domain.security.User;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mervin
 */
@Entity
@Table(name = "Administrator")
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll",
            query = "select a from Administrator a")
    ,
    @NamedQuery(name = "Administrator.findAllByName",
            query = "select a from Administrator a where a.adminName = :adminName")
    ,
    @NamedQuery(name = "Administrator.findByUsername",
            query = "select a from Administrator a where a.user.userName = :username")
})
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adminName;
    private String email;

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    /**
     *
     */
    public Administrator() {
    }

    /**
     *
     * @param adminName
     * @param email
     */
    public Administrator(String adminName, String email) {
        this.adminName = adminName;
        this.email = email;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     *
     * @param adminName
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Administrator{" + "id=" + id + ", adminName=" + adminName + ", email=" + email + ", user=" + user + '}';
    }

}
