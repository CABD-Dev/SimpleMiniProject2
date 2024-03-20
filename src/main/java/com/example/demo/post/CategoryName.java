package com.example.demo.post;

import jakarta.persistence.*;
@Entity
@Table(name = "category")
public class CategoryName {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id_category;

        private String category_name;

        @OneToOne(mappedBy = "categoryName", cascade = CascadeType.ALL,optional = false)
        private PostNative postNative;
    }
