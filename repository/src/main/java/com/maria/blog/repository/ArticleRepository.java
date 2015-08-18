package com.maria.blog.repository;

import com.maria.blog.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by mcsere on 7/8/2015.
 */
public interface ArticleRepository extends MongoRepository<Article, String>{


}
