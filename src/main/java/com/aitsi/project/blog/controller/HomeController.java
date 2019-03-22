package com.aitsi.project.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Syl on 2017-11-18.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String getHomePage() {
        return "home";
    }

    @RequestMapping("/post")
    public String getLoginPage() {
        return "post"; }
}
