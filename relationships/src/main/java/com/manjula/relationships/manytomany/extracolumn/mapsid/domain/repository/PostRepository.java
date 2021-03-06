package com.manjula.relationships.manytomany.extracolumn.mapsid.domain.repository;

import com.manjula.relationships.manytomany.extracolumn.mapsid.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
