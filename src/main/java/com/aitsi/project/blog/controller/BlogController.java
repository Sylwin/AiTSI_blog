package com.aitsi.project.blog.controller;

import com.aitsi.project.blog.domain.Blog;
import com.aitsi.project.blog.domain.Photo;
import com.aitsi.project.blog.domain.Post;
import com.aitsi.project.blog.domain.User;
import com.aitsi.project.blog.service.BlogService;
import com.aitsi.project.blog.service.PhotoService;
import com.aitsi.project.blog.service.PostService;
import com.aitsi.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private PostService postService;

    @Autowired
    private PhotoService photoService;

    @RequestMapping("/about")
    public String about(Principal principal, Model model) {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(principal.getName());
        Blog blog = user.getBlog();
        model.addAttribute("user", user);
        model.addAttribute("blog", blog);
        return "about";
    }

    @RequestMapping(value = "/editAbout", method = RequestMethod.GET)
    public String aboutEdit(Principal principal, Model model) {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(principal.getName());
        Blog blog = user.getBlog();
        model.addAttribute("user", user);
        model.addAttribute("blog", blog);
        return "editAbout";
    }

    @RequestMapping(value = "/editAbout", method = RequestMethod.POST)
    public String aboutEditPost(@ModelAttribute("aboutMeSubtitle") String aboutMeSubtitle,
                                @ModelAttribute("aboutMe") String aboutMe,
                                @ModelAttribute("photo") MultipartFile photo,
                                Principal principal, Model model) throws IOException {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(principal.getName());
        Blog blog = user.getBlog();

        blog.setAboutMeSubtitle(aboutMeSubtitle);
        blog.setAboutMe(aboutMe);

        if( photo.getOriginalFilename().length() > 0 ) {
            byte[] byteArr = photo.getBytes();
            blog.setAboutPhoto(byteArr);
        }

        blogService.save(blog);

        model.addAttribute("user", user);
        model.addAttribute("blog", blog);

        return "about";
    }

    @RequestMapping("/post")
    public String post(Principal principal, Model model) {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(principal.getName());
        Blog blog = user.getBlog();
        Post post = postService.findLastPost(user.getUsername());

        model.addAttribute("user", user);
        model.addAttribute("blog", blog);
        model.addAttribute("chosenPost", post);

        return "post";
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String getPost(@PathVariable("id") Integer id, Principal principal, Model model) {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(principal.getName());
        Blog blog = user.getBlog();
        Post post = postService.findById(id);

        model.addAttribute("user", user);
        model.addAttribute("blog", blog);
        model.addAttribute("chosenPost", post);

        return "post";
    }


    @RequestMapping(value = "/editBlog/{id}", method = RequestMethod.GET)
    public String blogEdit(@RequestParam("request") String request,
                           @PathVariable("id") long id,
                           Principal principal, Model model) {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(principal.getName());
        Blog blog = user.getBlog();
        if( request.equals("add") ) {
            model.addAttribute("user", user);
            model.addAttribute("blog", blog);

            return "newPost";
        }
        else {
            model.addAttribute("user", user);
            model.addAttribute("blog", blog);

            return "editBlog";
        }
    }

    @RequestMapping(value = "/editBlog/{id}", method = RequestMethod.POST)
    public String blogEditPost(@ModelAttribute("id") int id,
                               @ModelAttribute("title") String title,
                               @ModelAttribute("subtitle") String subtitle,
                               @ModelAttribute("backgroundPhoto") MultipartFile backgroundPhoto,
                               Principal principal, Model model) throws IOException {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(principal.getName());
        Blog blog = user.getBlog();

        user.setBlogTitle(title);
        blog.setSubtitle(subtitle);
        if( backgroundPhoto.getOriginalFilename().length() > 0 ) {
            byte[] background = backgroundPhoto.getBytes();
            blog.setHomePhoto(background);
        }

        blogService.save(blog);

        model.addAttribute("user", user);
        model.addAttribute("blog", blog);

        return "redirect:/blog";
    }

    @RequestMapping(value = "/newPost", headers = "content-type=multipart/*", method = RequestMethod.POST)
    public String newPostPost(@ModelAttribute("title") String title,
                              @ModelAttribute("subtitle") String subtitle,
                              @ModelAttribute("postText") String postText,
                              @ModelAttribute("photos") MultipartFile[] photos,
                              @ModelAttribute("backgroundPhoto") MultipartFile backgroundPhoto,
                              Principal principal, Model model) throws IOException {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        byte[] background = backgroundPhoto.getBytes();

        postService.newPost(title, subtitle, postText, background, principal);

        User user = userService.findByUsername(principal.getName());
        Blog blog = user.getBlog();

        Post chosenPost = postService.findLastPost(user.getUsername());

        if( photos != null && photos.length > 1 ) {
            for (MultipartFile multipartFile : photos) {
                byte[] byteArr = multipartFile.getBytes();
                Photo photo1 = new Photo(byteArr, chosenPost);
                photoService.save(photo1);
            }
        }

        model.addAttribute("chosenPost", chosenPost);
        model.addAttribute("user", user);
        model.addAttribute("blog", blog);

        return "redirect:/blog/post/" + chosenPost.getId();
    }

    @RequestMapping(value = "/editPost/{id}", method = RequestMethod.GET)
    public String postEdit(@RequestParam("request") String request,
                           @PathVariable("id") long id,
                           Principal principal, Model model) {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(principal.getName());
        if( request.equals("edit") ) {
            Blog blog = user.getBlog();

            Post post = postService.findById(id);

            model.addAttribute("user", user);
            model.addAttribute("blog", blog);
            model.addAttribute("chosenPost", post);

            return "editPost";
        }
        else {
            Post post = postService.findById(id);
            postService.delete(post);

            return "redirect:/blog";
        }
    }

    @RequestMapping(value = "/editPost/{id}", method = RequestMethod.POST)
    public String postEditPost(@ModelAttribute("id") long id,
                               @ModelAttribute("title") String title,
                               @ModelAttribute("subtitle") String subtitle,
                               @ModelAttribute("postText") String postText,
                               @ModelAttribute("photos") MultipartFile[] photos,
                               @ModelAttribute("backgroundPhoto") MultipartFile backgroundPhoto,
                               Principal principal, Model model) throws IOException {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(principal.getName());
        Blog blog = user.getBlog();

        Post post = postService.findById(id);

        post.setTitle(title);
        post.setSubtitle(subtitle);
        post.setPostText(postText);
        if( backgroundPhoto.getOriginalFilename().length() > 0 ) {
            byte[] background = backgroundPhoto.getBytes();
            post.setBackgroundPhoto(background);
        }

        postService.save(post);

        if( photos != null && photos.length > 1 ) {
            for (MultipartFile multipartFile : photos) {
                byte[] byteArr = multipartFile.getBytes();
                photoService.save(new Photo(byteArr, post));
            }
        }

        model.addAttribute("user", user);
        model.addAttribute("blog", blog);
        model.addAttribute("chosenPost", post);

        return "redirect:/blog/post/" + post.getId();
    }

    @RequestMapping(value = "/post/{postId}/deletePhoto/{photoId}")
    public String deletePhoto(@PathVariable("postId") long postId,
                              @PathVariable("photoId") int photoId,
                              Principal principal, Model model) {
        if(principal != null) {
            model.addAttribute("loggedIn", true);
        }
        else {
            model.addAttribute("loggedIn", false);
        }
        User user = userService.findByUsername(principal.getName());
        Blog blog = user.getBlog();

        Post chosenPost = postService.findById(postId);

        Photo photo = photoService.findById(photoId);

        photoService.delete(photo);

        model.addAttribute("user", user);
        model.addAttribute("blog", blog);
        model.addAttribute("chosenPost", chosenPost);

        return "redirect:/blog/post/" + postId;
    }

}
