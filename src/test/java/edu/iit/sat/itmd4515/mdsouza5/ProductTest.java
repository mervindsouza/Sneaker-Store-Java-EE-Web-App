/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Mervin
 */
public class ProductTest {

    private static EntityManagerFactory emf;
    private static Validator validator;
    private EntityManager em;
    private EntityTransaction tx;

    private static final Logger LOG = Logger.getLogger(Driver.class.getName());

    @BeforeClass
    public static void beforeClassTestFixture() {
        emf = Persistence.createEntityManagerFactory("itmd4515PU_TEST");
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @AfterClass
    public static void afterClassTestFixture() {
        emf.close();
    }

    @Before
    public void beforeTestFixture() {
        em = emf.createEntityManager();
        tx = em.getTransaction();

        Product seed = new Product("Mock MacBook Pro", new GregorianCalendar(2015, 5, 15).getTime(), 300);
        tx.begin();
        em.persist(seed);
        tx.commit();
    }

    @After
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
    
    @Test
    public void validateAddedDateSunnyDay()
    {
        Product p1 = new Product("Nike Airmax 2017", new GregorianCalendar(2016, 8, 18).getTime(), 500);
        Set<ConstraintViolation<Product>> violations = validator.validate(p1);
        assertTrue(violations.isEmpty());
    }
    
    @Test
    public void validateAddedDateAndNullNameRainyDay()
    {
        Product p1 = new Product(null, new GregorianCalendar(2020, 8, 18).getTime(), 500);
        Set<ConstraintViolation<Product>> violations = validator.validate(p1);
        
        for(ConstraintViolation<Product> violation : violations)
        {
            LOG.info(violation.toString());
        }
        
        assertFalse(violations.isEmpty());
        assertTrue(violations.size() == 2);
    }
    

    @Test
    public void verifySeedData() {
        List<Product> seeds
                = em.createNamedQuery("Product.findByName", Product.class)
                        .setParameter("name", "Mock Macbook Pro")
                        .getResultList();
        assertEquals(seeds.size(), 1);
        assertSame(seeds.get(0).getName(), "Mock MacBook Pro");
    }

    @Test
    public void updateNameData() {
        Product pr1 = new Product("Mock Lenovo Yoga", new GregorianCalendar(2011, 5, 11).getTime(), 200);
        tx.begin();
        em.persist(pr1);
        tx.commit();
        Long pr1Id = pr1.getId();
        LOG.log(Level.INFO, "PR1 Pre-Update Test:\t{0}", em.find(Product.class, pr1Id).toString());
        pr1.setName("Updated Mock Lenovo Yoga");
        assertSame(pr1.getName(), "Updated Mock Lenovo Yoga");
        LOG.log(Level.INFO, "PR1 Post-Update Test:\t{0}", em.find(Product.class, pr1Id).toString());
    }

    //@Test(expected = RollbackException.class)
    public void updateNameFailRainyDayTest() {
        Product seed = new Product(null, new GregorianCalendar(2008, 10, 8).getTime(), 220);
        tx.begin();
        em.persist(seed);
        tx.commit();
        assertNull("Check if the Name is null", seed.getId());
    }

    //@Test
    public void persistNewProductTest() {

        Product pr1 = new Product("Windows Surface Book", new GregorianCalendar(2017, 2, 12).getTime(), 500);
        tx.begin();
        assertNull("Product id should be null before persist.", pr1.getId());
        em.persist(pr1);
        assertNull("Product id should be null after persist but before commit.", pr1.getId());
        tx.commit();
        assertTrue("Product id should be greater than 0 afer commit.", pr1.getId() > 0);
        assertNotNull("Product id should not be null after persisit and commit.", pr1.getId());
    }

    //@Test(expected = RollbackException.class)
    public void persistNewProductShouldFailRainyDayTest() {
        Product seed = new Product("Mock MacBook Pro", new GregorianCalendar(2017, 7, 11).getTime(), 300);
        tx.begin();
        em.persist(seed);
        tx.commit();
    }
}
