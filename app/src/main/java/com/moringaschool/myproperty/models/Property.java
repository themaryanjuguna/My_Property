package com.moringaschool.myproperty.models;

import java.io.Serializable;
import java.util.Objects;

public class Property implements Serializable {

    public int id;
    public String property_name, manager_name;

    public Property(String property_name, String manager_name) {
        this.property_name = property_name;
        this.manager_name = manager_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(property_name, property.property_name) && Objects.equals(manager_name, property.manager_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property_name, manager_name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }
}
