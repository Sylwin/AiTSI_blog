package com.aitsi.project.blog.dao;

import com.aitsi.project.blog.domain.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogDao extends CrudRepository<Blog, Integer> {
}
