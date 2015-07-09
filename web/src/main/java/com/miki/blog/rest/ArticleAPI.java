package com.miki.blog.rest;

import com.miki.blog.model.Article;
import com.miki.blog.repository.ArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mcsere on 7/9/2015.
 */
@Controller
@RequestMapping("/articles")
public class ArticleAPI {

    @Resource
    ArticleRepository articleRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    Boolean addIntoCollection(@RequestBody Article article) {
        this.articleRepository.save(article);
        return true;
    }

}
