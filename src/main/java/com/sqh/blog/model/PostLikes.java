package com.sqh.blog.model;

import javax.persistence.*;

@Entity
public class PostLikes {
    @Id
    @GeneratedValue
    private Long id;
    private Long postId;
    private Long userId;
    @Enumerated(EnumType.ORDINAL)
    private LikeValue likeValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LikeValue getLikeValue() {
        return likeValue;
    }

    public void setLikeValue(LikeValue likeValue) {
        this.likeValue = likeValue;
    }
}
