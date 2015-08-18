package com.maria.blog;

import com.maria.blog.model.Comment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Maria Simion on 29.07.2015.
 */
public class MatureLanguageFilter {

    public static Comment replaceMatureWord(Comment comment){
        String commentWords[] = comment.getContext().split(" ");
        StringBuilder sb = new StringBuilder("");
        for(String word : commentWords){
            if(BAD_WORDS.contains(word.toLowerCase())){
                sb.append("**** ");
            }else{
                sb.append(word + " ");
            }
        }
        comment.setContext(sb.toString());
        return comment;
    }

    public static List<String > BAD_WORDS = new ArrayList<String>(Arrays.asList("fuck", "fuckoff", "prick", "asshole"));

}

