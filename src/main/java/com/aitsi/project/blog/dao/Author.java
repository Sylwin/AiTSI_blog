package com.aitsi.project.blog.dao;

public class Author {

    private String id;
    private String firstName;
    private String lastName;
    private String description;

    public Author(String id, String firstName, String lastName, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
