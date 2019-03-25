package com.aitsi.project.blog.dao;

import java.io.Serializable;
import java.util.List;

public class Post implements Serializable {

    private String id;
    private String title;
    private String country;
    private String postText;
    private String mainPhoto;
    private List<String> photos;
    private String date;

    public Post(String id, String title, String country, String postText, String mainPhoto, List<String> photos, String date) {
        this.id = id;
        this.title = title;
        this.country = country;
        this.postText = postText;
        this.mainPhoto = mainPhoto;
        this.photos = photos;
        this.date = date;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
