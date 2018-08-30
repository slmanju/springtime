package com.manjula.relationships.manytoone.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManyToOneEmployeeRepository extends JpaRepository<ManyToOneEmployee, String> {

    @Query("select employee from ManyToOneEmployee employee join fetch employee.department")
    List<ManyToOneEmployee> findAll();

}
