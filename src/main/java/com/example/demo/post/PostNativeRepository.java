package com.example.demo.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostNativeRepository extends JpaRepository<PostNative, Long> {

//    Optional<PostNative> findall();

}