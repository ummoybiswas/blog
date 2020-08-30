package com.sqh.blog.repository;

import com.sqh.blog.model.Post;
import com.sqh.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
    Optional<Post> findById(Long id);

    List<Post> findAllByOrderByIdDesc();

    List<Post> findByApprovedOrPostedByOrderByIdDesc(boolean approved, User postedBy);

    Optional<Post> findByIdAndPostedBy(Long postId, User postedBy);
}
