package com.sqh.blog.controller.mapper;

import com.sqh.blog.controller.data.PostData;
import com.sqh.blog.controller.data.UserData;
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
public class UserViewDataMapper {
    public List<UserData> map(List<User> users) {
        return users.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public UserData map(User user) {
        UserData userData = new UserData();
        userData.setId(user.getId());
        userData.setEnabled(user.isEnabled());
        userData.setFullName(user.getFullName());
        userData.setUsername(user.getUsername());
        userData.setCreatedAt(new SimpleDateFormat("dd MMM YYYY").format(user.getCreatedAt()));

        return userData;
    }
}
