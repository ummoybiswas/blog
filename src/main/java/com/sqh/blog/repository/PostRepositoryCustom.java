package com.sqh.blog.repository;

import com.sqh.blog.model.Post;
import com.sqh.blog.model.User;

public interface PostRepositoryCustom {
    Post findApprovedPost(Long id, User postedBy);
}
