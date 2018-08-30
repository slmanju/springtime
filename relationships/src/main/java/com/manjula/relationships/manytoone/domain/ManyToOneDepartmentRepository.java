package com.manjula.relationships.manytoone.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyToOneDepartmentRepository extends JpaRepository<ManyToOneDepartment, String> {
}
