package com.aitsi.project.blog.controller;

import com.aitsi.project.blog.dao.Post;
import com.aitsi.project.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping("/{id}")
    public String getLoginPage(@PathVariable("id") String id, Model model) {

        Post post = postService.findById(id);
        model.addAttribute("post" , post);

        return "post"; }

}
