package com.example.demo.post;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    int id;
    @Column(columnDefinition = "utf8mb4_unicode_ci")
    String email;
    @Column(columnDefinition = "utf8mb4_unicode_ci")
    String status;
    String year;
    String month;
    Date created_at;
    Date updated_at;
    @Column(columnDefinition = "utf8mb4_unicode_ci")
    String category;

    public Subscription() {
        super();
    }
}
