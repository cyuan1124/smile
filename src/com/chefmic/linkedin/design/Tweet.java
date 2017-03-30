package com.chefmic.linkedin.design;

/**
 * Created by cyuan on 3/21/17.
 */
public class Tweet {

    public int id;
    public int user_id;
    public String text;

    public static Tweet create(int user_id, String tweet_text) {
        Tweet tweet = new Tweet();
        tweet.user_id = user_id;
        tweet.text = tweet_text;
        tweet.id = (int) System.currentTimeMillis();
        return tweet;
    }

}
