/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.ejb;

import edu.iit.sat.itmd4515.mdsouza5.domain.security.Group;
import java.util.List;
import javax.ejb.Stateless;

/**
 * 
 * @author mervin
 */
@Stateless
public class GroupService extends BaseService<Group> {

    public GroupService() {
        super(Group.class);
    }
    
    @Override
    public List<Group> findAll() {
        return getEntityManager().createNamedQuery("Group.findAll", Group.class).getResultList();
    }
    
}
