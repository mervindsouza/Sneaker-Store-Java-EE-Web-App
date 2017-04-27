/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.ejb;

import edu.iit.sat.itmd4515.mdsouza5.domain.Orders;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Dethrone
 */
@Stateless
public class OrdersService extends BaseService<Orders>{

    public OrdersService() {
        super(Orders.class);
    }

    @Override
    public List<Orders> findAll() {
        return getEntityManager().createNamedQuery("Orders.findAll", Orders.class).getResultList();
    }
    
}
