package com.sqh.blog.service.impl;

import com.sqh.blog.model.Role;
import com.sqh.blog.model.User;
import com.sqh.blog.repository.UserRepository;
import com.sqh.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    @Override
    public User createAdmin(String fullName, String username, String password) {
        return createUserInternal(fullName, username, password, Role.ROLE_ADMIN);
    }

    @Transactional
    @Override
    public User createBlogger(String fullName, String username, String password) {
        return createUserInternal(fullName, username, password, Role.ROLE_USER);
    }

    @Override
    public User toggleEnabledUser(User user) {
        user.setEnabled(!user.isEnabled());
        return userRepository.save(user);
    }

    @Override
    public List<User> getBloggers() {
        return userRepository.findByRole(Role.ROLE_USER);
    }

    @Override
    public List<User> getAdmins() {
        return userRepository.findByRole(Role.ROLE_ADMIN);
    }

    private User createUserInternal(String fullName, String username, String password, Role role) {
        User user = new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRole(role);

        if (role.isAdmin()) {
            user.setEnabled(true);
        }

        return userRepository.save(user);
    }
}
