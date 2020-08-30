package com.sqh.blog.model;

public enum LikeValue {
    LIKE(1, "Like"),
    DISLIKE(2, "DisLike"),
    NO_REACTION(3, "No Reaction");

    private int id;
    private String name;

    LikeValue(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isLike() {
        return this == LIKE;
    }

    public boolean isDislike() {
        return this == DISLIKE;
    }
}
