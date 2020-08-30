package com.sqh.blog.service;

import com.sqh.blog.model.Post;
import com.sqh.blog.model.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Optional<Post> findPostById(Long id);

    Post findApprovedPost(Long id, User user);

    List<Post> findApprovedPostsIncluding(User user);

    List<Post> findAllPosts();

    Post createPost(String title, String text, User postedBy);

    void likePost(Post post, User user);

    void dislikePost(Post post, User user);

    boolean isPostLikedByUser(Post post, User user);

    boolean isPostDislikedByUser(Post post, User user);

    Post approvePost(Post post);

    void deletePost(Post post);
}
