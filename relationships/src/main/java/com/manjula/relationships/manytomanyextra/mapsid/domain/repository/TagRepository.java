package com.manjula.relationships.manytomanyextra.mapsid.domain.repository;

import com.manjula.relationships.manytomanyextra.mapsid.domain.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
