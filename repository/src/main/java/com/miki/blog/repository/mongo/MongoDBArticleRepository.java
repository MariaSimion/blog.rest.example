package com.miki.blog.repository.mongo;

import com.miki.blog.model.Article;
import com.miki.blog.model.Author;
import com.miki.blog.repository.ArticleRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.*;

/**
 * Created by mcsere on 7/8/2015.
 */
@Repository
public class MongoDBArticleRepository implements ArticleRepository {

    @Resource
    private MongoOperations operations;

    public Article findById(String id) {
        Query query = query(where("_id").is(new ObjectId(id)));
        return operations.findOne(query, Article.class);
    }

    public Article save(Article article) {
        operations.save(article);
        return article;
    }

    public List<Article> findByAuthor(Long author) {
        Query query = query(where("authorsList").is(author));
        return operations.find(query, Article.class);
    }

    public List<Article> findAll() {
        return operations.findAll(Article.class);
    }
}
