/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5;

import edu.iit.sat.itmd4515.mdsouza5.domain.Orders;
import edu.iit.sat.itmd4515.mdsouza5.domain.Product;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Mervin FP
 */
public class Driver {

    public Driver() {
    }

    private static final Logger LOG = Logger.getLogger(Driver.class.getName());

    public static void main(String[] args) {
        LOG.info("This is main class.");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Product p1 = new Product("Mock Driver Nike Roshe", new GregorianCalendar(2014, 7, 11).getTime(), 300);
        Orders o1 = new Orders(new GregorianCalendar(2015, 8, 11).getTime(), 1122, 100.50f);
        
        //1. setting-reverse side relationship
        //p1.setOrders(o1);
        
        //2. setting from owning side
        //o1.setProduct(p1);
        
        tx.begin();

        em.persist(p1);
        em.persist(o1);
        tx.commit();

        em.close();
        emf.close();
    }
}
