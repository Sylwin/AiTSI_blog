package com.aitsi.project.blog.controller;

import com.aitsi.project.blog.dao.Author;
import com.aitsi.project.blog.dao.Headline;
import com.aitsi.project.blog.dao.Post;
import com.aitsi.project.blog.database.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Syl on 2017-11-18.
 */
@Controller
public class HomeController {

    @Autowired
    Reader reader;

    @RequestMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String getHomePage(Model model) {

        List<Author> authors = reader.retrieveAuthors();
        model.addAttribute("authors", authors);

        List<Post> posts = reader.retrievePosts();
        posts = posts.stream()
                .sorted(Comparator.comparing(Post::getId).reversed())
                .collect(Collectors.toList());
        model.addAttribute("posts" , posts);

        List<Headline> headlines = reader.retrieveHeadlines();
        model.addAttribute("headlines" , headlines);

        return "home";
    }

    @RequestMapping("/project")
    public String getProjectDescription() {
        return "project";
    }

}
