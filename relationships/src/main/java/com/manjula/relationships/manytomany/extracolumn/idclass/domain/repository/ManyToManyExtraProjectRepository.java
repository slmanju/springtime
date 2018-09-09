package com.manjula.relationships.manytomany.extracolumn.idclass.domain.repository;

import com.manjula.relationships.manytomany.extracolumn.idclass.domain.model.ManyToManyExtraProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyToManyExtraProjectRepository extends JpaRepository<ManyToManyExtraProject, Long> {
}
