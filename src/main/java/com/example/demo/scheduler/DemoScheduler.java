package com.example.demo.scheduler;


import com.example.demo.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.post.postService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

public class DemoScheduler {

    @Autowired
    postService postService;

    @Scheduled(cron = "${findID}")
    public void returnContentById(){
        Post post = new Post();
        post.setCategory("9");
        postService.FindArticleByCategoryJoined(post);
    }
}
