package com.aitsi.project.blog.dao;

import com.aitsi.project.blog.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Syl on 2017-11-18.
 */
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByBlogTitle(String title);
    List<User> findAll();
}
