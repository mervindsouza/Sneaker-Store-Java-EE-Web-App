/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.web;

import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Dethrone
 */
@FacesConverter(value = "testFacesConverter")
public class TestFacesConvertor implements Converter {

    private static final Logger LOG = Logger.getLogger(TestFacesConvertor.class.getName());

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LOG.info(value);
        //since we need to get the value of id, make a constructor for id
        //parse it and set it in the object return
        //Long id = Long.parseLong(value); //here value is string
        //Orders o = new Orders(id);
        //return id;
        return null;
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        //return String.valueOf(((Orders)value).getId());
        return null;
    }

}
