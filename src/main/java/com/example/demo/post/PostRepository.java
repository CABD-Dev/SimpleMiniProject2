package com.example.demo.post;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {

    public List<Post> findTop5ByOrderByViewCountDesc();

    public List<PostNative> findByCategory(String Category);

    public Optional<Post> findById(String id);

    public List<Post> findByContentContaining(String content);

    public List<Post> findByMonthAndYear(String month, String year);

    @Query(value = "SELECT distinct * FROM post e where category = :category order by view_count desc", nativeQuery = true)
    public List<Post> getPostByCategory(@Param("category") String category);;

    @Query(value = "SELECT * FROM post e " +
            "left join category c on e.category = c.id " +
            "where category = :category order by view_count desc", nativeQuery = true)
    public Iterable<Post> getSelectedColumsByCategory(@Param("category") String category);

    public Subscription save(Subscription subs);

}
