package com.aitsi.project.blog.service;

import com.aitsi.project.blog.dao.Post;
import com.aitsi.project.blog.database.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    Reader reader;

    public Post findById(String id) {
        List<Post> posts = reader.retrievePosts();

        return posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
