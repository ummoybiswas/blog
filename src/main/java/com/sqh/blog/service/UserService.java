package com.sqh.blog.service;

import com.sqh.blog.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

    User createAdmin(String fullName, String username, String password);

    User createBlogger(String fullName, String username, String password);

    User toggleEnabledUser(User user);

    List<User> getBloggers();

    List<User> getAdmins();
}
