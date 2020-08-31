package com.sqh.blog.service;

import com.sqh.blog.model.Post;
import com.sqh.blog.model.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Optional<Post> findPostById(Long id);

    Post getPost(Long id);

    Optional<Post> findApprovedPostOrOwnPost(Long id, User user);

    Optional<Post> findPostByUser(Long id, User user);

    List<Post> findApprovedPostsIncluding(User user);

    Optional<Post> findApprovedPostExcluding(Long id, User user);

    List<Post> findAllPosts();

    Post createPost(String title, String text, User postedBy);

    void likePost(Post post, User user);

    void dislikePost(Post post, User user);

    boolean isLikedByUser(Post post, User user);

    boolean isDislikedByUser(Post post, User user);

    Integer findLikeCount(Post post);

    Integer findDislikeCount(Post post);

    Post approvePost(Post post);

    void deletePost(Post post);
}
