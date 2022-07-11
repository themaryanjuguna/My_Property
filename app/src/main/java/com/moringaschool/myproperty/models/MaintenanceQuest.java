package com.moringaschool.myproperty.models;

import java.util.Objects;

public class MaintenanceQuest {
    public int quest_id;
    public String description, quest_url, property_name;

    public MaintenanceQuest(String description, String quest_url, String property_name) {
        this.description = description;
        this.quest_url = quest_url;
        this.property_name = property_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaintenanceQuest that = (MaintenanceQuest) o;
        return Objects.equals(description, that.description) && Objects.equals(quest_url, that.quest_url) && Objects.equals(property_name, that.property_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, quest_url, property_name);
    }

    public int getQuest_id() {
        return quest_id;
    }

    public void setQuest_id(int quest_id) {
        this.quest_id = quest_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuest_url() {
        return quest_url;
    }

    public void setQuest_url(String quest_url) {
        this.quest_url = quest_url;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }
}
