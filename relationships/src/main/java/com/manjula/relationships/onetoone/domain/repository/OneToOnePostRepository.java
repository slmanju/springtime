package com.manjula.relationships.onetoone.domain.repository;

import com.manjula.relationships.onetoone.domain.model.OneToOnePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OneToOnePostRepository extends JpaRepository<OneToOnePost, Long> {

    @Query("select post from OneToOnePost post left join fetch post.details")
    List<OneToOnePost> findAllEagerly();

    @Query("select post from OneToOnePost post left join fetch post.details where post.id =:id")
    Optional<OneToOnePost> findByIdEagerly(@Param("id") Long id);

}
