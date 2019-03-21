package com.aitsi.project.blog.controller;

import com.aitsi.project.blog.domain.Blog;
import com.aitsi.project.blog.domain.Post;
import com.aitsi.project.blog.domain.User;
import com.aitsi.project.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/travels/blog")
public class GuestController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private PostService postService;

    @Autowired
    private PhotoService photoService;

    @RequestMapping(value = "/{username}")
    public String userBlog(@PathVariable("username") String username,
                           Principal principal, Model model) {
        if(principal != null && Objects.equals(principal.getName(), username)) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }

        User user = userService.findByUsername(username);

        List<Post> postsList = blogService.findPostsList(user.getUsername());

        Collections.reverse(postsList);

        Blog blog = user.getBlog();

        model.addAttribute("user", user);
        model.addAttribute("blog", blog);
        model.addAttribute("postsList", postsList);
        model.addAttribute("rated", false);

        return "userFront";
    }

    @RequestMapping(value = "/{username}/about")
    public String userAbout(@PathVariable("username") String username,
                            Principal principal, Model model) {
        if(principal != null && Objects.equals(principal.getName(), username) ) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(username);
        Blog blog = user.getBlog();

        model.addAttribute("user", user);
        model.addAttribute("blog", blog);

        return "about";
    }

    @RequestMapping(value = "/{username}/newestPost")
    public String userNewestPost(@PathVariable("username") String username,
                                 Principal principal, Model model) {
        if(principal != null && Objects.equals(principal.getName(), username) ) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(username);
        Blog blog = user.getBlog();
        Post post = postService.findLastPost(user.getUsername());

        model.addAttribute("user", user);
        model.addAttribute("blog", blog);
        model.addAttribute("chosenPost", post);

        return "post";
    }

    @RequestMapping(value = "/{username}/post/{id}", method = RequestMethod.GET)
    public String userPost(@PathVariable("username") String username,
                           @PathVariable("id") Integer id, Principal principal, Model model) {
        if(principal != null && Objects.equals(principal.getName(), username) ) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(username);
        Blog blog = user.getBlog();
        Post post = postService.findById(id);

        model.addAttribute("user", user);
        model.addAttribute("blog", blog);
        model.addAttribute("chosenPost", post);

        return "post";
    }

    @RequestMapping(value="/rate/{username}", method = RequestMethod.POST)
    public String addRate(@PathVariable("username") String username,
                          @RequestParam("request") String number,
                          Principal principal, Model model) {
        if(principal != null && Objects.equals(principal.getName(), username) ) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }

        User user = userService.findByUsername(username);
        Blog blog = user.getBlog();

        blog.setRate(blogService.countRate(username, Integer.parseInt(number)));

        List<Post> postsList = blogService.findPostsList(user.getUsername());

        Collections.reverse(postsList);

        model.addAttribute("user", user);
        model.addAttribute("blog", blog);
        model.addAttribute("postsList", postsList);
        model.addAttribute("rated", true);

        return "userFront";
    }

}
