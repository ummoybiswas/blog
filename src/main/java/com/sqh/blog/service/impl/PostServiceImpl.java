package com.sqh.blog.service.impl;

import com.sqh.blog.model.LikeValue;
import com.sqh.blog.model.Post;
import com.sqh.blog.model.PostLikes;
import com.sqh.blog.model.User;
import com.sqh.blog.repository.PostLikesRepository;
import com.sqh.blog.repository.PostRepository;
import com.sqh.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostLikesRepository postLikesRepository;

    @Override
    public Optional<Post> findPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post findApprovedPost(Long id, User user) {
        if (user.getRole().isAdmin()) {
            return findPostById(id).orElse(null);
        }
        return postRepository.findApprovedPost(id, user);
    }

    @Override
    public List<Post> findApprovedPostsIncluding(User user) {
        if (user.getRole().isAdmin()) {
            return findAllPosts();
        }
        return postRepository.findByApprovedOrPostedByOrderByIdDesc(true, user);
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAllByOrderByIdDesc();
    }

    @Transactional
    @Override
    public Post createPost(String title, String text, User postedBy) {
        Post post = new Post();
        post.setTitle(title);
        post.setText(text);
        post.setPostedBy(postedBy);

        return postRepository.save(post);
    }

    @Transactional
    @Override
    public void likePost(Post post, User user) {
        createOrUpdatePostLikesInternal(post, user, LikeValue.LIKE);
    }

    @Transactional
    @Override
    public void dislikePost(Post post, User user) {
        createOrUpdatePostLikesInternal(post, user, LikeValue.DISLIKE);
    }

    private PostLikes createOrUpdatePostLikesInternal(Post post, User user, LikeValue likeValue) {
        PostLikes postLikes = postLikesRepository.findByPostIdAndAndUserId(post.getId(), user.getId())
                .orElseGet(() ->createDefaultPostLikes(post, user));

        if (postLikes.getLikeValue() == null || !Objects.equals(postLikes.getLikeValue(), likeValue)) {
            postLikes.setLikeValue(likeValue);
        } else {
            postLikes.setLikeValue(LikeValue.NO_REACTION);
        }

        return postLikesRepository.save(postLikes);
    }

    @Override
    public boolean isPostLikedByUser(Post post, User user) {
        PostLikes postLikes = postLikesRepository.findByPostIdAndAndUserId(post.getId(), user.getId()).orElse(null);
        return postLikes != null && postLikes.getLikeValue().isLike();
    }

    @Override
    public boolean isPostDislikedByUser(Post post, User user) {
        PostLikes postLikes = postLikesRepository.findByPostIdAndAndUserId(post.getId(), user.getId()).orElse(null);
        return postLikes != null && postLikes.getLikeValue().isDislike();
    }

    @Transactional
    @Override
    public Post approvePost(Post post) {
        if (!post.isApproved()) {
            post.setApproved(true);
        }
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Post post) {
        postRepository.delete(post);
        postLikesRepository.findByPostId(post.getId())
                .forEach(postLikes -> postLikesRepository.delete(postLikes));

    }

    private PostLikes createDefaultPostLikes(Post post, User user) {
        PostLikes postLikes = new PostLikes();
        postLikes.setPostId(post.getId());
        postLikes.setUserId(user.getId());

        return postLikes;
    }
}
