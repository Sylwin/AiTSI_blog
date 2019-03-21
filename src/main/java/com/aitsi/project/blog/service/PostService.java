package com.aitsi.project.blog.service;

import com.aitsi.project.blog.domain.Post;

import java.security.Principal;

public interface PostService {

    void save(Post post);

    void delete(Post post);

    void newPost(String title, String subtitle, String postText, byte[] backgroundPhoto, Principal principal);

    Post findLastPost(String username);

    Post findByTitle(String title);

    Post findById(long id);
}
