package com.aitsi.project.blog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String subtitle;
    private Date creationDate;
    private String aboutMeSubtitle;
    @Column(columnDefinition = "text")
    private String aboutMe;
    @Type(type="org.hibernate.type.BinaryType")
    @Basic(fetch = FetchType.LAZY)
    private byte[] homePhoto;
    @Type(type="org.hibernate.type.BinaryType")
    @Basic(fetch = FetchType.LAZY)
    private byte[] aboutPhoto;
    private float rate = 0;
    private int numberOfRates = 0;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Post> postList;

    public Blog() {}

    public Blog(String subtitle, String aboutMe, List<Post> postList) {
        this.subtitle = subtitle;
        this.aboutMe = aboutMe;
        this.postList = postList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public String getAboutMeSubtitle() {
        return aboutMeSubtitle;
    }

    public void setAboutMeSubtitle(String aboutMeSubtitle) {
        this.aboutMeSubtitle = aboutMeSubtitle;
    }

    public byte[] getHomePhoto() {
        return homePhoto;
    }

    public void setHomePhoto(byte[] homePhoto) {
        this.homePhoto = homePhoto;
    }

    public byte[] getAboutPhoto() {
        return aboutPhoto;
    }

    public void setAboutPhoto(byte[] aboutPhoto) {
        this.aboutPhoto = aboutPhoto;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getNumberOfRates() {
        return numberOfRates;
    }

    public void setNumberOfRates(int numberOfRates) {
        this.numberOfRates = numberOfRates;
    }

    public String generateBase64ImageAbout()
    {
        return DatatypeConverter.printBase64Binary(getAboutPhoto());
    }

    public String generateBase64ImageHome()
    {
        return DatatypeConverter.printBase64Binary(getHomePhoto());
    }

}
