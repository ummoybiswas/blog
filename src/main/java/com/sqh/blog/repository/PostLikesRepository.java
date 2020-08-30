package com.sqh.blog.repository;

import com.sqh.blog.model.LikeValue;
import com.sqh.blog.model.PostLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostLikesRepository extends JpaRepository<PostLikes, Long> {
    Optional<PostLikes> findByPostIdAndAndUserId(Long postId, Long userId);

    List<PostLikes> findByPostId(Long postId);

    Integer countByPostIdAndAndLikeValue(Long postId, LikeValue likeValue);
}
