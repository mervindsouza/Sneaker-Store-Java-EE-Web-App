/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.domain;

import java.util.Date;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author Mervin
 */
@Entity
@Table(name = "Product")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "select p from Product p ")
    ,
    @NamedQuery(name = "Product.findByName", query = "select p from Product p where p.productName = :productName")
})
public class Product {
    
    
    
    /**
     *
     */
    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    @NotNull(message = "Product Name cannot be null.")
    @Size(min = 5, max = 50, message = "Product Name Must be Greater Than 5 Characters")
    private String productName;

    @Past(message = "Date Should be in past.")
    @Temporal(TemporalType.TIMESTAMP)
    private Date productDateAdded;

    //@Transient
    private Integer productCount;
    private double productSize;
    private double productValue;
    private String productColor;

    public Product(String productName, Date productDateAdded, Integer productCount) {
        this.productName = productName;
        this.productDateAdded = productDateAdded;
        this.productCount = productCount;
    }

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "Category_Id")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "ADMIN_ID")
    private Administrator administrator;

    public Product(String productName, Date productDateAdded, Integer productCount, double productSize, double productValue, String productColor) {
        this.productName = productName;
        this.productDateAdded = productDateAdded;
        this.productCount = productCount;
        this.productSize = productSize;
        this.productValue = productValue;
        this.productColor = productColor;
    }

    /**
     *
     * @return
     */
    public Integer getProductCount() {
        return productCount;
    }

    /**
     * Set the value of price
     *
     * @param productCount
     */
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    /**
     * Get the value of productDateAdded
     *
     * @return the value of productDateAdded
     */
    public Date getProductDateAdded() {
        return productDateAdded;
    }

    /**
     * Set the value of productDateAdded
     *
     * @param productDateAdded new value of productDateAdded
     */
    public void setProductDateAdded(Date productDateAdded) {
        this.productDateAdded = productDateAdded;
    }

    /**
     * Get the value of productName
     *
     * @return the value of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Set the value of productName
     *
     * @param productName new value of productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return Id;
    }

    /**
     *
     * @param Id
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     * Get the value of category
     *
     * @return the value of category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Set the value of category
     *
     * @param category new value of category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "Id=" + Id + ", name=" + productName + ", dateAdded=" + productDateAdded + ", count=" + productCount + '}';
    }

    public double getProductSize() {
        return productSize;
    }

    public void setProductSize(double productSize) {
        this.productSize = productSize;
    }

    public double getProductValue() {
        return productValue;
    }

    public void setProductValue(double productValue) {
        this.productValue = productValue;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }
    public Orders getOrder() {
        return order;
    }
    public void setOrder(Orders order) {
        this.order = order;
    }
    public Administrator getAdministrator() {
        return administrator;
    }
    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

}
