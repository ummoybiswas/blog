package com.sqh.blog.model;

public enum Role {
    ROLE_ADMIN(1, "ROLE_ADMIN"),
    ROLE_USER(2, "ROLE_USER");

    private int id;
    private String name;

    Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return this == ROLE_ADMIN;
    }

    public boolean isUser() {
        return this == ROLE_USER;
    }
}
