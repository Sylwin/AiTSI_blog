package com.aitsi.project.blog.domain;

import javax.persistence.*;
import javax.xml.bind.DatatypeConverter;

@Entity
@Table(name="photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Photo() { }

    public Photo(byte[] picture, Post post) {
        this.picture = picture;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String generateBase64Image()
    {
        return DatatypeConverter.printBase64Binary(getPicture());
    }
}
