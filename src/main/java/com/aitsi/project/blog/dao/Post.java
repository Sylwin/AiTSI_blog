package com.aitsi.project.blog.dao;

import java.io.Serializable;

public class Post implements Serializable {

    private String id;
    private String title;
    private String postText;

    public Post(String id, String title, String postText) {
        this.id = id;
        this.title = title;
        this.postText = postText;
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

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

}
