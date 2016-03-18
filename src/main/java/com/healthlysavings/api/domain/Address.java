package com.healthlysavings.api.domain;

import javax.persistence.Id;

/**
 * Created by jrdavis on 3/14/16.
 */

    public class Address {
        @Id
        private String city;
        private String street_name;
        private String zip;
        private String state;
        private String street_number;


    public Address(String city, String street_name, String zip, String state, String street_number) {
        this.city = city;
        this.street_name = street_name;
        this.zip = zip;
        this.state = state;
        this.street_number = street_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet_number() {
        return street_number;
    }

    public void setStreet_number(String street_number) {
        this.street_number = street_number;
    }
}
