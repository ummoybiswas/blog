package com.sqh.blog.repository;

import com.sqh.blog.model.Post;
import com.sqh.blog.model.User;

public interface PostRepositoryCustom {
    Post findApprovedPostOrOwnPost(Long id, User postedBy);

    Post findApprovedPostExcluding(Long id, User postedBy);
}
