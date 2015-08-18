package com.maria.blog.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Maria Simion on 10.07.2015.
 */

public class Comment{


    private String commentator;

    private String context;

    private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Comment() {

    }

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

}
