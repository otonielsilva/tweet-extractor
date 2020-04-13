package com.otoniel.tweetsextractor.web;

import com.otoniel.tweetsextractor.twitter.TweetReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

@Controller
public class TweetsController {

    @Autowired
    TweetReader tweetReader;

    @GetMapping("/tweets/{search}")
    public ResponseEntity getStatus(@PathVariable String search) {
        try {
            List<Status> statuses = tweetReader.getStatuses();
            return ResponseEntity.ok(statuses);
        } catch (TwitterException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
