package com.aitsi.project.blog.service;

import com.aitsi.project.blog.domain.Blog;
import com.aitsi.project.blog.domain.Post;

import java.util.List;

public interface BlogService {

    Blog createBlog();

    void save(Blog blog);

    List<Post> findPostsList(String username);

    List<Blog> findBlogsList();

    float countRate(String username, int rate);
}
