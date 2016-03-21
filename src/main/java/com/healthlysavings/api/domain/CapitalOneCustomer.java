package com.healthlysavings.api.domain;



/**
 * Created by jrdavis on 3/14/16.
 */
public class CapitalOneCustomer {


    private String _id;
    private String last_name;
    private String first_name;
    private Address address;

    public CapitalOneCustomer(String id, String last_name, String first_name, Address address) {
        this._id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.address = address;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) { this._id = _id; }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
