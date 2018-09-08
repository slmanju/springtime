package com.manjula.relationships.manytomanyextra.domain.repository;

import com.manjula.relationships.manytomanyextra.domain.model.ManyToManyExtraProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyToManyExtraProjectRepository extends JpaRepository<ManyToManyExtraProject, Long> {
}
