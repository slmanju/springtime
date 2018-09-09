package com.manjula.relationships.manytomany.linkentity.domain.repository;

import com.manjula.relationships.manytomany.linkentity.domain.model.ManyToManyAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyToManyAddressRepository extends JpaRepository<ManyToManyAddress, Long> {
}
