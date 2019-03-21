package com.aitsi.project.blog.dao;

import com.aitsi.project.blog.domain.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoDao extends CrudRepository<Photo, Integer> {

}
