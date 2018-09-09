package com.manjula.relationships.manytomany.linkentity.domain.repository;

import com.manjula.relationships.manytomany.linkentity.domain.model.ManyToManyPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyToManyPersonRepository extends JpaRepository<ManyToManyPerson, Long> {
}
