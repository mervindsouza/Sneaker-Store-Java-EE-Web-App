/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.web;

import java.util.TimeZone;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author mervin
 */
@Named
@ApplicationScoped
public class ApplicationConfig {

    public ApplicationConfig() {
    }
    
    public TimeZone getTimeZone(){
        return TimeZone.getDefault();
        
    }
}
