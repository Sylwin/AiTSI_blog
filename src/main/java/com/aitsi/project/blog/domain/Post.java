package com.aitsi.project.blog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String subtitle;
    @Column(columnDefinition = "text")
    private String postText;
    private Date creationDate;
    private byte[] backgroundPhoto;
    private int likes = 0;
    private int dislikes = 0;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Photo> photosList;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    @JsonIgnore
    private Blog blog;

    public Post() {}

    public Post(String title, String postText, Date creationDate, String subtitle, Blog blog,
                byte[] backgroundPhoto) {
        this.title = title;
        this.postText = postText;
        this.creationDate = creationDate;
        this.subtitle = subtitle;
        this.blog = blog;
        this.backgroundPhoto = backgroundPhoto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Photo> getPhotosList() {
        return photosList;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public void setPhotosList(List<Photo> photosList) {
        this.photosList = photosList;
    }

    public byte[] getBackgroundPhoto() {
        return backgroundPhoto;
    }

    public void setBackgroundPhoto(byte[] backgroundPhoto) {
        this.backgroundPhoto = backgroundPhoto;
    }

    public String generateBase64Image()
    {
        return DatatypeConverter.printBase64Binary(getBackgroundPhoto());
    }
}

