package com.otoniel.tweetsextractor.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import java.util.List;

@Component
public class TweetReader {
    
    @Value("${twitter.oauth_consumer}")
    private String oauthConsumer;

    @Value("${twitter.oauth_access_token}")
    private String oauthAccessToken;

    @Value("${twitter.token_value}")
    private String token;

    @Value("${twitter.token_secret}")
    private String tokenSecret;

   

    public List<Status> getStatuses() throws TwitterException {
        TwitterFactory factory = new TwitterFactory();
        AccessToken accessToken = new AccessToken(token,
                tokenSecret);
        Twitter twitter = factory.getInstance();
        twitter.setOAuthConsumer(oauthConsumer, oauthAccessToken);
        twitter.setOAuthAccessToken(accessToken);

        return twitter.search(new Query("test")).getTweets();
    }

}