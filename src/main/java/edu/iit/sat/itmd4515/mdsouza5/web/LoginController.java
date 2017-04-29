/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.web;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mervin
 */
@Named
@RequestScoped
public class LoginController extends BaseController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    @NotNull(message = "Username cannot be blank.")
    private String username;
    @NotNull(message = "Password cannot be blank.")
    private String password;

    public LoginController() {

    }

    public String getRemoteUser() {
        return context.getExternalContext().getRemoteUser();
    }

    public Boolean isAdminstrator() {
        return context.getExternalContext().isUserInRole("ADMINISTRATOR_ROLE");
    }

    public Boolean isCustomer() {
        return context.getExternalContext().isUserInRole("CUSTOMER_ROLE");
    }
    
    public Boolean isSeller(){
        return context.getExternalContext().isUserInRole("SELLER_ROLE");
    }

    public String doLogin() {
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.login(username, password);
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed", "Username/Password is incorrect."));
            return "/login.xhtml";
        }
        return "/welcome.xhtml?faces-redirect=true";
    }

    public String doLogout() {
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Logout Failed", "Failed to Logout."));
            return "/login.xhtml";
        }
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "You have logged out with success.", "You have logged out successfully. Kindly close the browser."));
        return "/login.xhtml";
    }

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
