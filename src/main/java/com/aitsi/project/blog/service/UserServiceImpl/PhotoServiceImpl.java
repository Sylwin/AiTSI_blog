package com.aitsi.project.blog.service.UserServiceImpl;

import com.aitsi.project.blog.dao.PhotoDao;
import com.aitsi.project.blog.domain.Photo;
import com.aitsi.project.blog.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    PhotoDao photoDao;

    @Override
    public void save(Photo photo) {
        photoDao.save(photo);
    }

    @Override
    public void delete(Photo photo) {
        photoDao.delete(photo);
    }

    @Override
    public Photo findById(int id) { return photoDao.findById(id).get(); }
}
