package com.maria.blog.util;

import java.util.Random;

/**
 * Created by mcsere on 7/8/2015.
 */
public class IsbdnGenerator {

    static Random random = new Random();


    public static String generate() {
        return encode(random.nextInt(10000000));
    }


    private static final String ALPHABET = "bcdfghjkmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ23456789";
    private static final int BASE = ALPHABET.length();


    private static String encode(long num) {
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.insert(0, ALPHABET.charAt((int) (num % BASE)));
            num = num / BASE;
        }
        return str.toString();
    }

}
