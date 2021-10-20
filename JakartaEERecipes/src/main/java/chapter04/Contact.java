package com.jakartaee10recipes.chapter04;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Map;

/**
 * Chapter 4
 *
 * @author juneau, ttelang
 */

public class Contact implements Serializable {

    private String first;
    private String last;
    private String password;
    private String gender;
    private String description;
    private String occupation;
    private Map<String, String> newsletterList;
    private boolean receiveNotifications;
    private Map<String, String> notificationType;

    //    @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "Email format is invalid.")
    @Size(min=2, max=30)
    @Email
    private String email;

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the newsletterList
     */
    public Map<String,String> getNewsletterList() {
        return newsletterList;
    }
    /**
     * @param newsletterList the newsletterList to set
     */
    public void setNewsletterList(Map<String,String> newsletterList) {
        this.newsletterList = newsletterList;
    }

    /**
     * @return the receiveNotifications
     */
    public boolean isReceiveNotifications() {
        return receiveNotifications;
    }
    /**
     * @param receiveNotifications the receiveNotifications to set
     */
    public void setReceiveNotifications(boolean receiveNotifications) {
        this.receiveNotifications = receiveNotifications;
    }
    /**
     * @return the notificationType
     */
    public Map<String, String> getNotificationType() {
        return notificationType;
    }
    /**
     * @param notificationTypes the notificationType to set
     */
    public void setNotificationType(Map<String, String> notificationTypes) {
        this.notificationType = notificationTypes;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
