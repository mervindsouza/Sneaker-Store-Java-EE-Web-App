/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.web;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 *
 * @author mervin
 */
public abstract class BaseController {

    /**
     *
     */
    protected FacesContext context;
    
    protected BaseController() {
    }
    
    @PostConstruct
    public void postConstruct(){
        context = FacesContext.getCurrentInstance();
    }
    
}
