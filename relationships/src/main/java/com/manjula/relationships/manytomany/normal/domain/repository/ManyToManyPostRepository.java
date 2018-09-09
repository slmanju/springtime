package com.manjula.relationships.manytomany.normal.domain.repository;

import com.manjula.relationships.manytomany.normal.domain.model.ManyToManyPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyToManyPostRepository extends JpaRepository<ManyToManyPost, Long> {
}
