package com.moringaschool.myproperty.models;

import java.util.Objects;

public class Tenant {

    public int id;
    public String tenant_name,tenant_email, property_name;

    public Tenant(String tenant_name, String tenant_email, String property_name) {
        this.tenant_name = tenant_name;
        this.tenant_email = tenant_email;
        this.property_name = property_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenant tenant = (Tenant) o;
        return Objects.equals(tenant_name, tenant.tenant_name) && Objects.equals(tenant_email, tenant.tenant_email) && Objects.equals(property_name, tenant.property_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenant_name, tenant_email, property_name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenant_name() {
        return tenant_name;
    }

    public void setTenant_name(String tenant_name) {
        this.tenant_name = tenant_name;
    }

    public String getTenant_email() {
        return tenant_email;
    }

    public void setTenant_email(String tenant_email) {
        this.tenant_email = tenant_email;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }
}
