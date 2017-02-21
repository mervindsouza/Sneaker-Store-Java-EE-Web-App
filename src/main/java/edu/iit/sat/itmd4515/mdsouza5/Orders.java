/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mervin
 */
@Entity
@Table(name = "Orders")
public class Orders {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Temporal(TemporalType.DATE)    
    private Date dateOrdered;    
    private Integer confirmationNumber;
    private Float amount;

    @OneToOne
    private Product product;

    public Orders() {
    }

    public Orders(Date dateOrdered, Integer confirmationNumber, Float amount) {
        this.dateOrdered = dateOrdered;
        this.confirmationNumber = confirmationNumber;
        this.amount = amount;
    }
       
    /**
     * Get the value of product
     *
     * @return the value of product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set the value of product
     *
     * @param product new value of product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    

    /**
     * Get the value of confirmationNumber
     *
     * @return the value of confirmationNumber
     */
    public Integer getConfirmationNumber() {
        return confirmationNumber;
    }

    /**
     * Set the value of confirmationNumber
     *
     * @param confirmationNumber new value of confirmationNumber
     */
    public void setConfirmationNumber(Integer confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }


    /**
     * Get the value of dateOrdered
     *
     * @return the value of dateOrdered
     */
    public Date getDateOrdered() {
        return dateOrdered;
    }

    /**
     * Set the value of dateOrdered
     *
     * @param dateOrdered new value of dateOrdered
     */
    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    
     /**
     * Get the value of amount
     *
     * @return the value of amount
     */
    public Float getAmount() {
        return amount;
    }

    /**
     * Set the value of amount
     *
     * @param amount new value of amount
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }
   
    
}
