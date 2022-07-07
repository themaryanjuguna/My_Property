package com.moringaschool.myproperty.models;

import java.util.Objects;

public class PropertyManager {

    public int id;
    public String manager_name ,phone_number,email,property_name,property_description;


    public PropertyManager(String manager_name, String phone_number, String email, String property_name, String property_description) {
        this.manager_name = manager_name;
        this.phone_number = phone_number;
        this.email = email;
        this.property_name = property_name;
        this.property_description = property_description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyManager that = (PropertyManager) o;
        return Objects.equals(manager_name, that.manager_name) && Objects.equals(phone_number, that.phone_number) && Objects.equals(email, that.email) && Objects.equals(property_name, that.property_name) && Objects.equals(property_description, that.property_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manager_name, phone_number, email, property_name, property_description);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

    public String getProperty_description() {
        return property_description;
    }

    public void setProperty_description(String property_description) {
        this.property_description = property_description;
    }
}
