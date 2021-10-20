package com.jakartaee10recipes.chapter04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Chapter 4
 *
 * @author juneau, ttelang
 */
public class Subscription implements Serializable {
    private List<Contact> subscriptionList;

    Subscription() {
        subscriptionList = new ArrayList<>();
    }

    public List<Contact> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<Contact> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }
}
