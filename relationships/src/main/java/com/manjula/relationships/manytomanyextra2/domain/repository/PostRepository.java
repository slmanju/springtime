package com.manjula.relationships.manytomanyextra2.domain.repository;

import com.manjula.relationships.manytomanyextra2.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
