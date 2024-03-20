package com.example.demo.post;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "utf8mb4_unicode_ci")
    private String title;
    @Column(name = "view_count")
    private long viewCount;
    private String category;
    private String image;
    private String image_source;
    private String content;
    private String comment;
    private String author;
    private String subscribed;
    @Column(columnDefinition = "utf8mb4_unicode_ci")
    private String source_link;
    private String url_slug;
    private String is_trending;
    private String year;
    private String month;
    private String blast_stop;
    private Date created_at;
    private Date updated_at;
    @Column(columnDefinition = "utf8mb4_unicode_ci")
    private String thumbnail;
    @Column(name = "`order`")
    private int order;
    private String meta_title;
    private String meta_description;
    private String meta_keyword;
    @Column(columnDefinition = "utf8mb4_unicode_ci")
    private String short_description;
    private int view;
    private String category_name;


    public Post() {
        super();
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", url_slug=" + url_slug + ", view_count=" +viewCount  + "]";
    }

    // public Post(long id, String comment, long view_count, String category) {
    // super();
    // this.id = id;
    // this.title = comment;
    // this.viewCount = view_count;
    // this.category = category;
    // }

    // @Override
    // public String toString() {
    // return id + ". " + title + " - " + viewCount + " - " + category;
    // }

    // public String getTitle() {
    // return title;
    // }

    // public void setTitle(String comment) {
    // this.title = comment;
    // }

    // public long getId() {
    // return id;
    // }

    // public void setId(long id) {
    // this.id = id;
    // }

    // public long getViewCount() {
    // return viewCount;
    // }

    // public void setViewCount(long viewCount) {
    // this.viewCount = viewCount;
    // }

    // public String getCategory() {
    // return category;
    // }

    // public void setCategory(String category) {
    // this.category = category;
    // }

}
