package com.sqh.blog.repository;

import com.sqh.blog.model.Post;
import com.sqh.blog.model.Role;
import com.sqh.blog.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Post findApprovedPost(Long id, User postedBy) {
        String q = "select p from Post p where p.id = :id and (p.approved = true or p.postedBy = :postedBy)";
        Query query = entityManager.createQuery(q);
        query.setParameter("id", id);
        query.setParameter("postedBy", postedBy);
        return (Post) query.getSingleResult();
    }
}
