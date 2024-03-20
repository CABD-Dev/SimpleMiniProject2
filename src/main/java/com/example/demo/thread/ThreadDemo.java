package com.example.demo.thread;

import com.example.demo.email.EmailService;
import com.example.demo.post.postService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadDemo extends Thread {

    @Autowired
    EmailService emailService;

    @Autowired
    postService postService;

    private Thread t;
    private String threadName;

    public void ThreadSetUp(String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
                emailService.sendSimpleEmail();
                postService.telegramNotice();
                Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

//public class TestThread {
//
//    public static void main(String args[]) {
//        ThreadDemo T1 = new ThreadDemo("Thread-1");
//        T1.start();
//
//        ThreadDemo T2 = new ThreadDemo("Thread-2");
//        T2.start();
//    }
//}
}
