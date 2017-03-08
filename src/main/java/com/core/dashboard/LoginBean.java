/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.dashboard;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.RequestContext;

/**
 * 
 * @author Gonzalo H. Mendoza
 * email: yogonza524@gmail.com
 * StackOverflow: http://stackoverflow.com/users/5079517/gonza
 */
@ManagedBean(name="login")
@RequestScoped
public class LoginBean {

    private String username;
    private String password;
    
    @PostConstruct
    public void init(){
        username = "";
        password = "";
    }
    
    @PreDestroy
    public void finish(){
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public void login() throws IOException{
        if (username.isEmpty()) {
            toast("Username please...");
            message(FacesMessage.SEVERITY_ERROR,"Username please...");
            return;
        }
        if (password.isEmpty()) {
            toast("Password please...");
            message(FacesMessage.SEVERITY_ERROR,"Password please...");
            return;
        }
        
        if (username.equalsIgnoreCase("dummy") && password.equalsIgnoreCase("dummy")) {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            request.getSession().setAttribute("user", true);
            
            response.sendRedirect(request.getContextPath() + "/faces/index.xhtml");
        }
        else{
            toast("Username or password wrong");
            message(FacesMessage.SEVERITY_ERROR,"Username or password wrong");
        }
    }

    public void logout() throws IOException{
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        request.getSession().setAttribute("user", null);
        request.getSession().invalidate();

        response.sendRedirect(request.getContextPath() + "/faces/login.xhtml");
    }
    
    private void toast(String message) {
        RequestContext.getCurrentInstance().execute("Materialize.toast('" + message +"',4000);");
    }

    private void message(FacesMessage.Severity SEVERITY, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(SEVERITY, message, message));
    }
    
    
}
