package com.aitsi.project.blog.service;

import com.aitsi.project.blog.domain.Photo;

public interface PhotoService {
    void save(Photo photo);

    void delete(Photo photo);

    Photo findById(int id);
}
