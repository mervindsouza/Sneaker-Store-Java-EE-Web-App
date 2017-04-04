/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.domain;

import edu.iit.sat.itmd4515.mdsouza5.Driver;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Mervin FP
 */
public class ProductTest {

    private static EntityManagerFactory emf;
    private static Validator validator;
    private EntityManager em;
    private EntityTransaction tx;

    private static final Logger LOG = Logger.getLogger(Driver.class.getName());

    /**
     *
     */
    @BeforeClass
    public static void beforeClassTestFixture() {
        emf = Persistence.createEntityManagerFactory("itmd4515PU_TEST");
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     *
     */
    @AfterClass
    public static void afterClassTestFixture() {
        emf.close();
    }

    /**
     *
     */
    @Before
    public void beforeTestFixture() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        //Product seed = new Product("Mock MacBook Pro", new GregorianCalendar(2015, 5, 15).getTime(), 300);
        //Product p4 = new Product("Mock MacBook", new GregorianCalendar(2015, 5, 15).getTime(), 300);

        //Administrator a1 = new Administrator("Harvey Specter", "harveyspecter@gmail.com");
        //Administrator a2 = new Administrator("Mike Ross", "mikeross@gmail.com");
        Product p1 = new Product("Mock Driver Nike Roshe", new GregorianCalendar(2014, 7, 11).getTime(), 300);
        Orders o1 = new Orders(new GregorianCalendar(2015, 8, 11).getTime(), 1122, 100.50f);

        tx.begin();
        //em.persist(seed);
        //em.persist(p4);

        //em.persist(a1);
        //em.persist(a2);
        em.persist(p1);
        em.persist(o1);

        tx.commit();

        Product p2 = new Product("Mock Driver Nike HyperVenom", new GregorianCalendar(2013, 2, 23).getTime(), 400);
        Product p3 = new Product("Mock Driver Nike Air Force One", new GregorianCalendar(1991, 2, 2).getTime(), 50);
        Category ca1 = new Category("Soccer");
        Category ca2 = new Category("Running");
        Category ca3 = new Category("Lifestyle");

        ca1.addProduct(p1);
        ca2.addProduct(p2);
        ca3.addProduct(p3);

        Orders o2 = new Orders(new GregorianCalendar(2015, 8, 11).getTime(), 1122, 100.50f);
        Orders o3 = new Orders(new GregorianCalendar(2016, 3, 20).getTime(), 1123, 120.50f);
        Orders o4 = new Orders(new GregorianCalendar(2011, 2, 24).getTime(), 1124, 130.50f);
        o2.addProduct(p2);
        o3.addProduct(p3);

        Customer c1 = new Customer("John Smith", "josmith@gmail.com");
        Customer c2 = new Customer("Jack Smith", "jasmith@gmail.com");
        Customer c3 = new Customer("Alan Smith", "alsmith@gmail.com");

        c1.addOrders(o1);
        c2.addOrders(o2);
        c3.addOrders(o3);
        c3.addOrders(o4);

        tx.begin();

        em.persist(p2);
        em.persist(p3);
        em.persist(ca1);
        em.persist(ca2);
        em.persist(ca3);
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(o2);
        em.persist(o3);
        em.persist(o4);

        tx.commit();
    }

    //@After
    /**
     *
     */
    public void afterTestFixture() {
        Product seed
                = em.createNamedQuery("Product.findByName", Product.class)
                        .setParameter("name", "Mock Macbook Pro")
                        .getSingleResult();

        tx.begin();
        em.remove(seed);
        tx.commit();

        em.close();
    }

    /**
     *
     */
    @Test
    public void validateAddedDateSunnyDay() {
        Product p1 = new Product("Nike Airmax 2017", new GregorianCalendar(2016, 8, 18).getTime(), 500);
        Set<ConstraintViolation<Product>> violations = validator.validate(p1);
        assertTrue(violations.isEmpty());
    }

    /**
     *
     */
    @Test
    public void validateAddedDateAndNullNameRainyDay() {
        Product p1 = new Product(null, new GregorianCalendar(2020, 8, 18).getTime(), 500);
        Set<ConstraintViolation<Product>> violations = validator.validate(p1);

        for (ConstraintViolation<Product> violation : violations) {
            LOG.info(violation.toString());
        }

        assertFalse(violations.isEmpty());
        assertTrue(violations.size() == 2);
    }

    /**
     *
     */
    @Test
    public void validateEmailSunnyDay() {
        Customer c1 = new Customer("Mark Smith", "msmith@gmail.com");
        Set<ConstraintViolation<Customer>> violations = validator.validate(c1);
        assertTrue(violations.isEmpty());
    }

    /**
     *
     */
    @Test
    public void validateEmailRainyDay() {
        Customer c1 = new Customer(null, "jsmith@gmail");
        Set<ConstraintViolation<Customer>> violations = validator.validate(c1);
        assertTrue(violations.size() == 2);
        assertFalse(violations.isEmpty());
    }

    /**
     *
     */
    @Test
    public void validateRelationshipsSunnyDay() {
        Orders o2 = new Orders(new GregorianCalendar(2015, 8, 11).getTime(), 1000, 100.50f);
        Customer c1 = new Customer("Sunny John Smith", "sunjsmith@gmail.com");
        tx.begin();
        c1.addOrders(o2);
        em.persist(c1);
        tx.commit();

        Customer c2 = em.createNamedQuery("Customer.findEmail", Customer.class)
                .setParameter("email", "sunjsmith@gmail.com")
                .getSingleResult();

        LOG.info(c2.getEmail());
        em.close();
    }
}
