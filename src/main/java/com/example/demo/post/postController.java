package com.example.demo.post;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import com.example.demo.Model.WSMessage;
import com.example.demo.config.DecryptBody;
import com.example.demo.config.PayloadEncryptor;
import com.example.demo.thread.ThreadDemo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/postArticle")
public class postController {

    @Autowired
    postService PAService;

    @Autowired
    ThreadDemo threadDemo;

    @Autowired
    PostRepository repository;

    @Autowired
    PayloadEncryptor encryptor;

    @Autowired
    DecryptBody decryptor;

    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = "WnZr4u7x!A%D*G-KaPdSgVkXp2s5v8y/".getBytes();

    @GetMapping("/PopularArticle")
    public List<Post> getPopularArticle() {
        return PAService.postPopularArticleService();
    }

    @GetMapping("/ArticleIntoCSV")
    public String ArticleIntoCSV(@RequestBody Post post) {
        return PAService.ArticleIntoCSV(post);
    }

    @PostMapping("/FindArticleByCategory")
    public List<Post> FindArticleByCategory(@RequestBody Post post) {
        return PAService.postFindArticleByCategoryService(post);
    }

    @PostMapping("/FindArticleByCategoryJoined")
    public List<Post> FindArticleByCategoryJoined(@RequestBody Post post) {
        return PAService.FindArticleByCategoryJoined(post);
    }

    @GetMapping("/FindArticleByCategoryNative")
    public List<PostNative> FindArticleByCategoryNative() {
        return PAService.FindArticleByCategoryNative();
    }

    @PostMapping("/FindArticleDetail")
    public WSMessage FindArticleDetail(@RequestBody Post post) {
        WSMessage message = new WSMessage();
        Optional<Post> data = repository.findById(post.getId());
        String tmp = String.valueOf(data);
        String encrypted = encryptor.encrypt(tmp);
        message.setId_message(200);
        message.setMessage("Success");
        message.setData(encrypted);
        return message;
    }

    @PostMapping("/SearchArticle")
    public List<Post> SearchArticle(@RequestBody Post post) {
        return PAService.postSearchArticle(post);
    }

    @PostMapping("/CreateArticle")
    public Post CreateArticle(@RequestBody Post post) {
        return PAService.CreateArticle(post);
    }

    @PostMapping("/InsertArticle")
    public Post InsertArticle(@RequestBody Post post) {
        return PAService.InsertArticle(post);
    }

    @PutMapping("/UpdateSubscribe")
    public Post updateSubscribe(@RequestParam String id, @RequestBody Post post) {
        return PAService.updateSubscribe(id, post);
    }

    @PostMapping("/InsertSubscription")
    public Subscription InsertSubscription(@RequestBody Subscription subs) {
        threadDemo.ThreadSetUp("Thread-1");
        threadDemo.start();
        return PAService.InsertSubscription(subs);
    }

    @GetMapping("/export")
    public void exportCsv(HttpServletResponse response, @RequestBody Post post) throws IOException {
        // Set response headers
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=data.csv");

        // Load data from database or other source
        List<Post> data = repository.findByMonthAndYear(post.getMonth(), post.getYear());

        // Write data to CSV file
        try (PrintWriter writer = response.getWriter()) {
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            csvPrinter.printRecord("id", "url_slug", "title", "view_count");
            for (Post record : data) {
                csvPrinter.printRecord(record.getId(), record.getUrl_slug(), record.getTitle(), record.getViewCount());
            }
            csvPrinter.flush();
        }

    }

    @GetMapping("/encryptor")
    public WSMessage encryptor(@RequestParam String data) {
        WSMessage message = new WSMessage();
        String tmp = String.valueOf(data);
        String encrypted = encryptor.encrypt(tmp);
        System.out.println(encrypted);
        message.setId_message(200);
        message.setMessage("Success");
        message.setData(encrypted);
        return message;
    }

    @GetMapping("/decryptor")
    public WSMessage decryptor(@RequestParam String data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        WSMessage message = new WSMessage();

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(KEY, ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decodedBytes = Base64.decodeBase64(data.getBytes());
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        message.setId_message(1);
        message.setMessage("Success");
        message.setData(decryptedBytes);
        return message;
    }





}
