package com.maria.blog.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mcsere on 7/8/2015.
 */
@Document
public class Article extends AbstractEntity {

    private String title;

    private String content;

    private final String author = "Maria Simion";

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private List<Comment> commentList = new ArrayList<Comment>();

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public List<Comment> getCommentList() {
        return commentList;
    }

    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
