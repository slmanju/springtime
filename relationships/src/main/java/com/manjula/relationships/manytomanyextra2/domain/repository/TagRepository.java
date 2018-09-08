package com.manjula.relationships.manytomanyextra2.domain.repository;

import com.manjula.relationships.manytomanyextra2.domain.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
