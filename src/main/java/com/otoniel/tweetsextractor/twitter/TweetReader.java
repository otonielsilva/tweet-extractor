package com.otoniel.tweetsextractor.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import java.util.List;

@Component
public class TweetReader {
    
    @Value("${OAUTH_CONSUMER}")
    private String oauthConsumer;

    @Value("${OAUTH_ACCESS_TOKEN}")
    private String oauthAccessToken;

    @Value("${TOKEN_VALUE}")
    private String token;

    @Value("${TOKEN_SECRET}")
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