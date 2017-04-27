/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.ejb;

import edu.iit.sat.itmd4515.mdsouza5.domain.Seller;
import java.util.List;

/**
 *
 * @author Dethrone
 */
public class SellerService extends BaseService<Seller>{

    public SellerService() {
        super(Seller.class);
    }

    @Override
    public List<Seller> findAll() {
        return getEntityManager().createNamedQuery("Seller.findAll", Seller.class).getResultList();
    }
    
    public Seller findByUsername(String username){
        return getEntityManager().createNamedQuery("Seller.findByUsername", Seller.class).setParameter("username", "username").getSingleResult();
    }
    
}
