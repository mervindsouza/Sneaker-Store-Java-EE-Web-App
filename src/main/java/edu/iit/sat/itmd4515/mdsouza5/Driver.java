/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5;

import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Mervin
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
        em.close();
        emf.close();
    }
}
