package com.sqh.blog.controller.mapper;

import com.sqh.blog.controller.data.PostData;
import com.sqh.blog.model.Post;
import com.sqh.blog.model.User;
import com.sqh.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PostViewDataMapper {
    @Autowired
    private PostService postService;

    public List<PostData> map(List<Post> posts, User actorUser) {
        return posts.stream()
                .map(post -> map(post, actorUser))
                .collect(Collectors.toList());
    }

    public PostData map(Post post, User actorUser) {
        PostData postData = new PostData();
        postData.setId(post.getId());
        postData.setTitle(post.getTitle());
        postData.setText(post.getText());
        postData.setPostedAt(new SimpleDateFormat("dd MMM YYYY").format(post.getCreatedAt()));
        postData.setPostedBy(post.getPostedBy().getFullName());
        postData.setApprovedPost(post.isApproved());
        postData.setLikedByActor(postService.isLikedByUser(post, actorUser));
        postData.setDislikedByActor(postService.isDislikedByUser(post, actorUser));
        postData.setLikeCount(postService.findLikeCount(post));
        postData.setDislikeCount(postService.findDislikeCount(post));

        if (actorUser != null) {
            postData.setAdmin(actorUser.getRole().isAdmin());
            postData.setSubmittedByActor(Objects.equals(actorUser.getId(), post.getPostedBy().getId()));
        }

        return postData;
    }
}
