package com.otoniel.tweetsextractor.batch;


import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import java.util.List;

@Component("reader")
public class TweetReader {


    public List<Status> getStatuses() throws TwitterException {
        TwitterFactory factory = new TwitterFactory();
        AccessToken accessToken = new AccessToken("",
                "");
        Twitter twitter = factory.getInstance();
        twitter.setOAuthConsumer("", "");
        twitter.setOAuthAccessToken(accessToken);

        return twitter.search(new Query("test")).getTweets();
    }

}