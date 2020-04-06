package com.otoniel.tweetsextractor.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.TwitterException;

@Component
public class TaskScheduled {

    private static final Logger log = LoggerFactory.getLogger(TaskScheduled.class);

    @Autowired private TweetReader reader;

    @Scheduled(fixedRate = 5000)
    public void readTweets() {
        try {
            for (Status status : reader.getStatuses()) {
                log.info("Tweet" + status);
            }
        } catch (TwitterException e) {
            log.error("Error", e);
        }
    }

}
