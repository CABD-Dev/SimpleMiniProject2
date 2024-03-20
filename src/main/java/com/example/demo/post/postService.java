package com.example.demo.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.config.PayloadEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class postService {

    @Autowired
    PostRepository repository;

    @Autowired
    PostNativeRepository postNativeRepository;

    @Autowired
    PayloadEncryptor encryptor;

    public List<Post> postPopularArticleService() {
        Iterable<Post> iterator = repository.findTop5ByOrderByViewCountDesc();
        List<Post> result = new ArrayList<>();
        System.out.println("All Post items: ");
        iterator.forEach(category -> result.add(category));

        return result;
    }

    public List<Post> postFindArticleByCategoryService(Post post) {
//        Iterable<Post> iterator = repository.findByCategory(post.getCategory());
        Iterable<Post> iterator = repository.getPostByCategory(post.getCategory());
        List<Post> result = new ArrayList<>();
        System.out.println("All Post items: ");
        iterator.forEach(result::add);

        return result;
    }

    public List<Post> FindArticleByCategoryJoined(Post post) {
        Iterable<Post> iterator = repository.getSelectedColumsByCategory(post.getCategory());
        List<Post> result = new ArrayList<>();
        System.out.println("All Post items: ");
        iterator.forEach(result::add);

        return result;
    }
    public Post postFindArticleDetail(Post post) {

        return repository.findById(post.getId())
                .orElseThrow(() -> new ResourceAccessException("data with id " + post.getId() + "is not found"));
    }

    public List<Post> postSearchArticle(Post post) {
        Iterable<Post> iterator = repository.findByContentContaining(post.getContent());
        List<Post> result = new ArrayList<>();
        System.out.println("All Post items: ");
        iterator.forEach(category -> result.add(category));

        return result;
    }

    public Post CreateArticle(Post post) {
        try {
            post = repository
                    .save(post);
            return post;
        } catch (Exception e) {
            return post;
        }
    }

    public Post updateSubscribe(String id, Post post) {
        Optional<Post> data = repository.findById(id);
        if (data.isPresent()) {
            Post temp = data.get();
            temp.setSubscribed(post.getSubscribed());
            post = repository
                    .save(temp);
        }

        return post;
    }

    public Post InsertArticle(Post post) {
        try {
            post = repository
                    .save(post);
            return post;
        } catch (Exception e) {
            return post;
        }
    }

    public Subscription InsertSubscription(Subscription subs) {
        try {
            telegramNotice();
            if (subs.getStatus() == null || subs.getStatus().isEmpty()) {
                subs.setStatus("");
            }
            subs = repository
                    .save(subs);
            return subs;
        } catch (Exception e) {
            return subs;
        }
    }

    public String ArticleIntoCSV(Post post) {
        Iterable<Post> iterator = repository.findAll();
        List<Post> result = new ArrayList<>();
        String pool = ";";
        return pool;
    }

    public void telegramNotice(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.telegram.org/bot6253531554:AAE2eILvLq8nKUWvyxZbl0XN3FYhOnwJmI4/sendMessage?chat_id=-891236874&text=Hello&parse_mode=HTML";
        String answer = restTemplate.getForObject(url, String.class);
    }

    public List<PostNative> FindArticleByCategoryNative() {
        List<PostNative> iterator = postNativeRepository.findAll();
        System.out.println("All Post items: ");;
        return iterator;
    }


    // public String convertToCSV(List<Post> data) {
    // String result;
    // List<String> pool = data.stream()
    // .map(p -> p.getTitle(),
    // (p -> p.getViewCount),
    // (p -> p.getId),
    // (p -> p.getUrl_slug));
    // return result = Stream.of(data)
    // .map(this::escapeSpecialCharacters)
    // .collect(Collectors.joining(","));
    // }

    // public void givenDataArray_whenConvertToCSV_thenOutputCreated() throws
    // IOException {
    // List<String[]> dataLines = new ArrayList<>();
    // dataLines.add(new String[] { "John", "Doe", "38", "Comment Data\nAnother line
    // of comment data" });
    // dataLines.add(new String[] { "Jane", "Doe, Jr.", "19", "She said \"I'm being
    // quoted\"" });
    // File csvOutputFile = new File("Documents/test.csv");
    // try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
    // dataLines.stream()
    // .map(this::convertToCSV)
    // .forEach(pw::println);
    // }
    // }

    // public String escapeSpecialCharacters(List<String> data) {
    // String result = data.toString();
    // String escapedData = result.replaceAll("\\R", " ");
    // if (result.contains(",") || result.contains("\"") || result.contains("'")) {
    // result = result.replace("\"", "\"\"");
    // escapedData = "\"" + result + "\"";
    // }
    // return escapedData;
    // }

}
