package com.manjula.relationships.manytomanyextra2.domain.repository;

import com.manjula.relationships.manytomanyextra2.domain.model.PostTag;
import com.manjula.relationships.manytomanyextra2.domain.model.PostTagId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTagRepository extends JpaRepository<PostTag, PostTagId> {
}
