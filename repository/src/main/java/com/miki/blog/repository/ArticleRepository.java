package com.miki.blog.repository;

import com.miki.blog.model.Article;

import java.util.List;

/**
 * Created by mcsere on 7/8/2015.
 */
public interface ArticleRepository {


    Article findById(String id);


    Article save(Article article);


    List<Article> findByAuthor(Long author);

    List<Article> findAll();

}
