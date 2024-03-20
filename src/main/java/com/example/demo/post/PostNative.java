package com.example.demo.post;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "post")
@Table(name = "post")
public class PostNative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String content;
    String view_count;
    String category;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_name", referencedColumnName = "id")
    CategoryName categoryName;
}

