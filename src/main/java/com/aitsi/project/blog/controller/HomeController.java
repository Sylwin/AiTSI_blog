package com.aitsi.project.blog.controller;

import com.aitsi.project.blog.dao.RoleDao;
import com.aitsi.project.blog.domain.Blog;
import com.aitsi.project.blog.domain.Post;
import com.aitsi.project.blog.domain.User;
import com.aitsi.project.blog.domain.security.UserRole;
import com.aitsi.project.blog.service.BlogService;
import com.aitsi.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Syl on 2017-11-18.
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private RoleDao roleDao;

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String getHomePage(Principal principal, Model model) {
        if( principal != null ) {
            User user = userService.findByUsername(principal.getName());
            model.addAttribute("user", user);
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }

        return "home";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String register(Model model) {
        User user = new User();

        model.addAttribute("user",user);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerPost(@ModelAttribute("user") User user, Model model) {

        if(userService.checkUserExists(user.getUsername(), user.getEmail()) ||
                userService.checkPasswordLengthNotBetween6and30(user.getPassword()) ||
                userService.checkEmail(user.getEmail()))  {

            if (userService.checkEmailExists(user.getEmail())) {
                model.addAttribute("emailExists", true);
            }

            if (userService.checkUsernameExists(user.getUsername())) {
                model.addAttribute("usernameExists", true);
            }

            if (userService.checkPasswordLengthNotBetween6and30(user.getPassword())) {
               model.addAttribute("passwordWrongLength", true);
            }

            if (userService.checkEmail(user.getEmail())) {
                model.addAttribute("wrongEmailFormat", true);
            }

            return "registration";
        } else {
            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));

            userService.createUser(user, userRoles);

            model.addAttribute("registered", true);

            return "redirect:/login";
        }
    }

    @RequestMapping("/login")
    public String getLoginPage() { return "login"; }

    @RequestMapping("/blog")
    public String blog(Principal principal, Model model) {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(principal.getName());

        List<Post> postsList = blogService.findPostsList(user.getUsername());

        Collections.reverse(postsList);

        Blog blog = user.getBlog();

        model.addAttribute("user", user);
        model.addAttribute("blog", blog);
        model.addAttribute("postsList", postsList);
        model.addAttribute("rated", false);

        return "userFront";
    }

    @RequestMapping(value = "/find/{title}", method = RequestMethod.GET)
    public String search(Model model, @PathVariable("title") String title, Principal principal) {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }

        List<User> users = userService.findByBlogTitle(title);

        model.addAttribute("usersList", users);

        return "home :: resultsList";
    }

    @RequestMapping(value = "/get/newest", method = RequestMethod.GET)
    public String getNewest(Model model, Principal principal) {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }

        List<User> fiveUsersList = userService.findNewestUsers();

        model.addAttribute("usersList", fiveUsersList);
        model.addAttribute("type", "Newest Blogs");

        return "home :: resultsBlog";
    }

    @RequestMapping(value = "/get/oldest", method = RequestMethod.GET)
    public String getOldest(Model model, Principal principal) {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }

        List<User> fiveUsersList = userService.findOldestUsers();

        model.addAttribute("usersList", fiveUsersList);
        model.addAttribute("type", "Oldest Blogs");

        return "home :: resultsBlog";
    }

    @RequestMapping(value = "/get/highestRated", method = RequestMethod.GET)
    public String getHighestRated(Model model, Principal principal) {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }

        List<User> fiveUsersList = userService.findHighestRatedBlogs();

        model.addAttribute("usersList", fiveUsersList);
        model.addAttribute("type", "Highest Rated Blogs");

        return "home :: resultsBlog";
    }
}
