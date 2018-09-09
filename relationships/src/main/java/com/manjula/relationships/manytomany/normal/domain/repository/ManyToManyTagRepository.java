package com.manjula.relationships.manytomany.normal.domain.repository;

import com.manjula.relationships.manytomany.normal.domain.model.ManyToManyTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyToManyTagRepository extends JpaRepository<ManyToManyTag, Long> {
}
