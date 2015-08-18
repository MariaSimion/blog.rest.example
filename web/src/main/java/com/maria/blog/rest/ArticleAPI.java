package com.maria.blog.rest;

import com.maria.blog.MatureLanguageFilter;
import com.maria.blog.model.Article;

import com.maria.blog.model.Comment;
import com.maria.blog.repository.ArticleRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mcsere on 7/9/2015.
 */
@Controller
@RequestMapping("/articles")
public class ArticleAPI {

    @Resource
    protected ArticleRepository articleRepository;

    // ######################################################################### GET METHODS :

    /**
     * get all articles
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Article> getArticles() {
        return articleRepository.findAll();
    }

    /**
     * get an article by id
     *
     * @param idArticle
     * @return
     */
    @RequestMapping(value = "/article/{idArticle}", method = RequestMethod.GET)
    public
    @ResponseBody
    Article getArticleById(@PathVariable("idArticle") String idArticle) {
        return articleRepository.findOne(idArticle);
    }

    /**
     * get all comments for an article
     *
     * @param idArticle
     * @return
     */
    @RequestMapping(value = "/article/{idArticle}/comments", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Comment> getAllCommentsForAnArticle(@PathVariable("idArticle") String idArticle) {
        return articleRepository.findOne(idArticle).getCommentList();
    }


    /**
     * get comment from an article
     *
     * @param idArticle
     * @param idComment
     * @return
     */
    @RequestMapping(value = "/article/{idArticle}/comments/{idComment}", method = RequestMethod.GET)
    public
    @ResponseBody
    Comment getCommentForAnArticle(@PathVariable("idArticle") String idArticle
            , @PathVariable("idComment") int idComment) {
        if (idComment <= articleRepository.findOne(idArticle).getCommentList().size() - 1) {
            return articleRepository.findOne(idArticle).getCommentList().get(idComment);
        } else {
            return null;
        }
    }

    // ######################################################################### POST METHODS :

    /**
     * post an article
     *
     * @param article
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    Boolean postArticle(@RequestBody Article article) {
        article.setDate(new Date());
        articleRepository.save(article);

        return true;
    }

    /**
     * post a comment
     *
     * @param comment
     * @param idArticle
     * @return
     */
    @RequestMapping(value = "/article/{idArticle}/comments", method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    Boolean postCommentToArticle(@RequestBody Comment comment, @PathVariable("idArticle") String idArticle) {
        Article article = articleRepository.findOne(idArticle);
        MatureLanguageFilter.replaceMatureWord(comment);
        comment.setDate(new Date());
        article.getCommentList().add(comment);
        articleRepository.save(article);

        return true;
    }

    // ######################################################################### PUT METHODS :

    /**
     * put an article
     *
     * @param article
     * @param idArticle
     * @return
     */
    @RequestMapping(value = "/article/{idArticle}", method = RequestMethod.PUT, consumes = "application/json")
    public
    @ResponseBody
    Boolean putArticle(@RequestBody Article article, @PathVariable("idArticle") String idArticle) {
        Article articleToModify = articleRepository.findOne(idArticle);
        articleToModify.setTitle(article.getTitle());
        articleToModify.setContent(article.getContent());
        //articleToModify.setCommentList(article.getCommentList());
        articleRepository.save(articleToModify);

        return true;
    }


    /**
     * put a comment
     *
     * @param comment
     * @param idArticle
     * @param idComment
     * @return
     */
    @RequestMapping(value = "/article/{idArticle}/comments/{idComment}/", method = RequestMethod.PUT, consumes = "application/json")
    public
    @ResponseBody
    Boolean putCommentToArticle(@RequestBody Comment comment, @PathVariable("idArticle") String idArticle
            , @PathVariable("idComment") int idComment) {
        Article article = articleRepository.findOne(idArticle);
        article.getCommentList().set(idComment, comment);
        articleRepository.save(article);

        return true;
    }

    // ######################################################################### DELETE METHODS :

    /**
     * delete an article
     *
     * @param idArticle
     * @return
     */
    @RequestMapping(value = "/article/{idArticle}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    Boolean deleteArticleById(@PathVariable("idArticle") String idArticle) {
        articleRepository.delete(idArticle);

        return true;
    }

    /**
     * delete comment for an article
     *
     * @param idArticle
     * @param idComment
     * @return
     */
    @RequestMapping(value = "/article/{idArticle}/comments/{idComment}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    Boolean deleteCommentForAnArticle(@PathVariable("idArticle") String idArticle
            , @PathVariable("idComment") int idComment) {
        Article article = articleRepository.findOne(idArticle);
        article.getCommentList().remove(idComment);
        articleRepository.save(article);

        return true;
    }

}
