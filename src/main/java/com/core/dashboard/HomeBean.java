/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.dashboard;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * 
 * @author Gonzalo H. Mendoza
 * email: yogonza524@gmail.com
 * StackOverflow: http://stackoverflow.com/users/5079517/gonza
 */
@ManagedBean(name="home")
@ViewScoped
public class HomeBean implements Serializable{

    private User user;
    
    @PostConstruct
    public void init(){
        user = createUser();
    }
    
    @PreDestroy
    public void finish(){
        
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User createUser() {
        User result = new User();
        result.setAboutMe("I'm a Java developer who enjoy helping to people");
        result.setBirthDay("November 14, 1987");
        result.setCompany("Div ID Software - Argentina");
        result.setCompanyEmail("idsoft@dividsoft.com");
        result.setEmail("yogonza524@gmail.com");
        result.setFirstName("Gonzalo");
        result.setGender("Male");
        result.setPhone("+54 379 4267413");
        result.setPosition("CEO");
        result.setQualification("Semi Senior Advance");
        result.setSecondName("Humberto");
        result.setSkype("gonzalomendoza524");
        result.setUsername("yogonza524");
        
        return result;
    }
}
