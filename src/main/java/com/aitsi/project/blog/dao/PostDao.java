package com.aitsi.project.blog.dao;

import com.aitsi.project.blog.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostDao extends CrudRepository<Post, Long> {
    Post findByTitle(String title);

    void deleteByTitle(String title);
}
