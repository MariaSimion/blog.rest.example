package com.miki.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mcsere on 7/9/2015.
 */
@Controller
@RequestMapping("/")
public class IndexPage {

    @RequestMapping
    public String indexPage() {
        return "index.jsp";
    }
}
