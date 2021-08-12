package org.javaemailclinet.model;

import javax.mail.Store;
import java.util.Properties;


public class EmailAccount {
    private String address;
    private String password;
    private Properties properties;
    private Store store;

    @Override
    public String toString() {
        return address;
    }

    public EmailAccount(String address, String password) {
        this.address = address;
        this.password = password;
        properties = new Properties();

        properties.put("incomingHost", "imap.gmail.com");
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.host", "smtp.gmail.com");
        properties.put("mail.smtps.auth", "true");
        properties.put("outgoingHost", "smtp.gmail.com");



    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Properties getProperties() {
        return properties;
    }

    public String getPassword() {
        return password;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
