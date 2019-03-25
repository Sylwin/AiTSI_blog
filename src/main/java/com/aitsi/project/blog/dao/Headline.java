package com.aitsi.project.blog.dao;

public class Headline {

    private String id;
    private String title;
    private String text;
    private String photo;

    public Headline(String id, String title, String text, String photo) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
