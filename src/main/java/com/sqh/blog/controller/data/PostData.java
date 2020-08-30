package com.sqh.blog.controller.data;

public class PostData {
    private long id;
    private String title;
    private String text;
    private String postedBy;
    private String postedAt;
    private boolean approvedPost;
    private boolean admin;
    private boolean submittedByActor;
    private boolean likedByActor;
    private boolean dislikedByActor;
    private int likeCount;
    private int dislikeCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(String postedAt) {
        this.postedAt = postedAt;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isSubmittedByActor() {
        return submittedByActor;
    }

    public void setSubmittedByActor(boolean submittedByActor) {
        this.submittedByActor = submittedByActor;
    }

    public boolean isApprovedPost() {
        return approvedPost;
    }

    public void setApprovedPost(boolean approvedPost) {
        this.approvedPost = approvedPost;
    }

    public boolean isLikedByActor() {
        return likedByActor;
    }

    public void setLikedByActor(boolean likedByActor) {
        this.likedByActor = likedByActor;
    }

    public boolean isDislikedByActor() {
        return dislikedByActor;
    }

    public void setDislikedByActor(boolean dislikedByActor) {
        this.dislikedByActor = dislikedByActor;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }
}
