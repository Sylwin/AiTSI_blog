package com.aitsi.project.blog.service.UserServiceImpl;

import com.aitsi.project.blog.dao.PostDao;
import com.aitsi.project.blog.domain.Blog;
import com.aitsi.project.blog.domain.Post;
import com.aitsi.project.blog.domain.User;
import com.aitsi.project.blog.service.PostService;
import com.aitsi.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private UserService userService;

    @Override
    public void save(Post post) {
        postDao.save(post);
    }

    @Override
    public void delete(Post post) { postDao.delete(post); }

    @Override
    public void newPost(String title, String subtitle, String postText, byte[] backgroundPhoto, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Blog blog = user.getBlog();
        Date date = new Date();

        Post newPost = new Post(title, postText, date, subtitle, blog, backgroundPhoto);

        save(newPost);
    }

    @Override
    public Post findLastPost(String username) {
        User user = userService.findByUsername(username);
        List<Post> postsList = user.getBlog().getPostList();

        if (postsList.size() > 0) {
            Collections.sort(postsList, Comparator.comparingLong(Post::getId));
        }

        return postsList.get(postsList.size()-1);
    }

    @Override
    public Post findByTitle(String title) {
        return postDao.findByTitle(title);
    }

    @Override
    public Post findById(long id) { return postDao.findById(id).get(); }


}
