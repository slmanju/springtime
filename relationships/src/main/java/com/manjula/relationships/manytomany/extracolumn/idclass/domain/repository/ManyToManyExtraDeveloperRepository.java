package com.manjula.relationships.manytomany.extracolumn.idclass.domain.repository;

import com.manjula.relationships.manytomany.extracolumn.idclass.domain.model.ManyToManyExtraDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyToManyExtraDeveloperRepository extends JpaRepository<ManyToManyExtraDeveloper, Long> {
}
