package com.aitsi.project.blog.service.UserServiceImpl;

import com.aitsi.project.blog.dao.BlogDao;
import com.aitsi.project.blog.domain.Blog;
import com.aitsi.project.blog.domain.Post;
import com.aitsi.project.blog.domain.User;
import com.aitsi.project.blog.service.BlogService;
import com.aitsi.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private UserService userService;

    @Override
    public Blog createBlog() {
        Blog blog = new Blog();
        Date date = new Date();

        blog.setSubtitle("Default description");
        blog.setAboutMe("This is what I do");
        blog.setAboutMeSubtitle("Something about me");
        blog.setCreationDate(date);

        blogDao.save(blog);

        return blogDao.findById(blog.getId()).get();
    }

    @Override
    public void save(Blog blog) { blogDao.save(blog); }

    @Override
    public List<Post> findPostsList(String username) {
        User user = userService.findByUsername(username);
        List<Post> postsList = user.getBlog().getPostList();

        if (postsList.size() > 0) {
            Collections.sort(postsList, Comparator.comparingLong(Post::getId));
        }

        return postsList;
    }

    @Override
    public List<Blog> findBlogsList() {
        List<Blog> allBlogsList = (List<Blog>) blogDao.findAll();

        if (allBlogsList.size() > 0) {
            Collections.sort(allBlogsList, Comparator.comparingLong(Blog::getId));
        }

        Collections.reverse(allBlogsList);

        return allBlogsList;
    }

    @Override
    public float countRate(String username, int rate) {
        float newRate;

        User user = userService.findByUsername(username);
        Blog blog = user.getBlog();

        float currentRate = blog.getRate();
        int numberOfRates = blog.getNumberOfRates();

        float average = currentRate * numberOfRates;

        numberOfRates++;
        blog.setNumberOfRates(numberOfRates);

        newRate = (average + rate) / numberOfRates;

        return (float) (Math.round(newRate*100.0)/100.0);
    }
}
