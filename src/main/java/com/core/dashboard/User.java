/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.dashboard;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * @author Gonzalo H. Mendoza
 * email: yogonza524@gmail.com
 * StackOverflow: http://stackoverflow.com/users/5079517/gonza
 */
public class User implements Serializable{

    private String username;
    private String firstName;
    private String secondName;
    private String birthDay;
    private String gender;
    private String company;
    private String companyEmail;
    private String position;
    private String qualification;
    private String email;
    private String skype;
    private String phone;
    
    private String aboutMe;

    public User() {
    }

    public User(String username, String firstName, String secondName, String birthDay, String gender, String company, String companyEmail, String position, String qualification, String email, String skype, String phone, String aboutMe) {
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.company = company;
        this.companyEmail = companyEmail;
        this.position = position;
        this.qualification = qualification;
        this.email = email;
        this.skype = skype;
        this.phone = phone;
        this.aboutMe = aboutMe;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.secondName);
        hash = 97 * hash + Objects.hashCode(this.birthDay);
        hash = 97 * hash + Objects.hashCode(this.gender);
        hash = 97 * hash + Objects.hashCode(this.company);
        hash = 97 * hash + Objects.hashCode(this.companyEmail);
        hash = 97 * hash + Objects.hashCode(this.position);
        hash = 97 * hash + Objects.hashCode(this.qualification);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.skype);
        hash = 97 * hash + Objects.hashCode(this.phone);
        hash = 97 * hash + Objects.hashCode(this.aboutMe);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
    
    
}
