package com.jakartaee10recipes.chapter04;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;

import java.util.*;

/**
 * Chapter 4
 *
 * @author juneau, ttelang
 */
@RequestScoped
@Named(value = "contactController")
public class ContactController {
    private Contact current;
    private Subscription subscription;
    private String newsletterDescription;


    // Declaration of the managed bean properties
    private List<String> occupationList;

    private Map<String, String> allNewsletters;

    public Map<String, String> getNotificationTypes() {
        return notificationTypes;
    }

    public void setNotificationTypes(Map<String, String> notificationTypes) {
        this.notificationTypes = notificationTypes;
    }

    // Declaration
    private Map<String, String> notificationTypes;

    /**
     * Creates a new instance of ContactController
     */
    public ContactController() {
        current = null;
        newsletterDescription = "Enter your information below in order to be " +
            "added to the Acme Bookstore newsletter.";
        subscription = new Subscription();
        populateOccupationList();
        populateNewsletterList();

        // Population occurs within the constructor, calling the populateNotificationTypes method
        populateNotificationTypes();
    }

    private void populateNotificationTypes() {
        notificationTypes = new HashMap<>();
        notificationTypes.put("Product Updates", "1");
        notificationTypes.put("Best Seller Alerts","2");
        notificationTypes.put("Spam", "3");
    }



    public Map<String, String> getAllNewsletters() {
        return allNewsletters;
    }

    public void setAllNewsletters(Map<String, String> allNewsletters) {
        this.allNewsletters = allNewsletters;
    }

    // Example of populating the object
    private void populateOccupationList(){
        occupationList = new ArrayList();
        occupationList.add("Author");
        occupationList.add("IT Professional");
    }
    // Example of populating the object
    private void populateNewsletterList(){
        allNewsletters = new LinkedHashMap<String,String>();
        allNewsletters.put("Java 9 Recipes Weekly", "Java");
        allNewsletters.put("JavaFX Weekly", "FX");
        allNewsletters.put("Oracle PL/SQL Weekly", "Oracle");
        allNewsletters.put("New Books Weekly", "New Books");
    }

    /**
     * @return the occupationList
     */
    public List<String> getOccupationList() {
        return occupationList;
    }
    /**
     * @param occupationList the occupationList to set
     */
    public void setOccupationList(List<String> occupationList) {
        this.occupationList = occupationList;
    }

    /**
     * Obtain the current instance of the Contact object
     * @return Contact
     */
    public Contact getCurrent(){
        if (current == null){
            current = new Contact();
            newsletterDescription = "Enter your information below in order to be " +
                    "added to the Acme Bookstore newsletter.";

        }
        return current;
    }

    public String getNewsletterDescription() {
        return newsletterDescription;
    }
    public void setNewsletterDescription(String newsletterDescription) {
        this.newsletterDescription = newsletterDescription;
    }

    /**
     * Custom validator to ensure that password field contents match
     * @param context
     * @param component
     * @param value
     */
    public void validatePassword(FacesContext context,
                                 UIComponent component,
                                 Object value){
        Map map = context.getExternalContext().getRequestParameterMap();
        String passwordText = (String) map.get(("contactForm:password"));
        String confirmPassword = value.toString();
        if (!passwordText.equals(confirmPassword)) {
            throw new ValidatorException(new FacesMessage("Passwords do not match"));
        }
    }

    /**
     * Adds a subscriber to the newsletter
     * @return String
     */
    public String subscribe(){
        // Using a list implementation for now,
        // but will add to a database table in Chapter 7
        // Add the current contact to the subscription list
        subscription.getSubscriptionList().add(current);
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Successfully Subscribed to Newsletter for " + getCurrent().getEmail(), null);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        return "SUBSCRIBE";
    }

    /**
     * Navigational method
     * @return String
     */
    public String add(){
        return "ADD_SUBSCRIBER";
    }
    /**
     * This method will allow a user to navigate to the manageAccount view.
     * This method will be moved into another managed bean that focuses on
     * authentication later on.
     * @return
     */
    public String manage(){
        return "/chapter04/manageAccount";
    }

}
