/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.dashboard;

import com.core.hibernate.HibernateUtil;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
        
        //Here we must check with the database
        boolean isUserValid = validateUser(username, password);
        
        if (isUserValid) {
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

    private boolean validateUser(String username, String password) {
        System.out.println("Username entered: " + username + " and password " + password);
        Session s = HibernateUtil.getSessionFactory().openSession();
        //This user is a bean for dummy example, we need the user from entities package
        com.core.entities.User exist = (com.core.entities.User) s.createCriteria(com.core.entities.User.class)
                .add(Restrictions.eq("username", username))
                .add(Restrictions.eq("password", password)).uniqueResult();
                //My error, sorry, all classes must be consistent
        s.close(); //Always close the session please
        if (exist != null) {
            System.out.println("user found, username: " + exist.getUsername());
        }
        else{
            System.out.println("User not found");
        }
        return exist != null;
    }
    
    
}
