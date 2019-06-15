package com.e.interview.model;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Employee extends RealmObject {
    private String Name;
    private String Address;

    @PrimaryKey
    private String email;


    private  String phoneno;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", email='" + email + '\'' +
                ", phoneno='" + phoneno + '\'' +
                '}';
    }
    public static List<Employee> getAllEmployee() {
        try {
            Realm realm = Realm.getDefaultInstance();
            return realm.where(Employee.class).findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
