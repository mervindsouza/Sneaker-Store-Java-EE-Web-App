/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.ejb;

import edu.iit.sat.itmd4515.mdsouza5.domain.security.Group;
import edu.iit.sat.itmd4515.mdsouza5.domain.security.User;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author mervin
 */
@Startup
@Singleton
public class StartupBean {

    @EJB
    private UserService userService;

    @EJB
    private GroupService groupService;
    
    public StartupBean() {
    }
        
    @PostConstruct
    public void postConstruct(){
        Group adminGroup = new Group("ADMINISTRATORS", "System Administrator Group");
        User adminUser =  new User("admin","admin");
        adminUser.addGroups(adminGroup);
        
        groupService.create(adminGroup);
        userService.create(adminUser);
    }

}
