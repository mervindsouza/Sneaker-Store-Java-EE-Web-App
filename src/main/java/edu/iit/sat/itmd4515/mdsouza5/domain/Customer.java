/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.domain;

import edu.iit.sat.itmd4515.mdsouza5.domain.security.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author mervin
 */
@Entity
@Table(name = "Customer")

//@NamedQuery(
//        name = "Customer.findEmail",
//        query = "select c from Customer c where c.email = :email")
@NamedQueries({
    @NamedQuery(
            name = "Customer.findEmail",
            query = "select c from Customer c where c.email = :email")
    ,
    @NamedQuery(
            name = "Customer.findAll",
            query = "select c from Customer c"
    )
    ,
    @NamedQuery(
            name = "Customer.findByUsername",
            query = "select c from Customer c where c.user.userName = :username"
    )

})

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "The Customer Name Cannot Be Null")
    private String custName;
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message = "The Email that you have entered is invalid.")
    private String email;
    


    @ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
    @JoinTable(name = "Customers_Orders",
            joinColumns = @JoinColumn(name = "cust_id"),
            inverseJoinColumns = @JoinColumn(name = "odr_id"))
    private List<Orders> orders = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdate;

    public Customer(String custName, String email, Date birthdate) {
        this.custName = custName;
        this.email = email;
        this.birthdate = birthdate;
    }

    /**
     *
     * @param o
     */
    public void addOrders(Orders o) {
        this.orders.add(o);
        o.getCustomers().add(this);
    }

    /**
     *
     */
    public Customer() {
    }

    /**
     *
     * @param custName
     * @param email
     */
    public Customer(String custName, String email) {
        this.custName = custName;
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
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of custName
     *
     * @return the value of custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * Set the value of custName
     *
     * @param custName new value of custName
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * Get the value of orders
     *
     * @return the value of orders
     */
    public List<Orders> getOrders() {
        return orders;
    }

    /**
     * Set the value of orders
     *
     * @param orders new value of orders
     */
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
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
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", custName=" + custName + ", email=" + email + ", birthdate=" + birthdate + '}';
    }

    
}
