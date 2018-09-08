package com.manjula.relationships.identifiers.idclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdClassOrderEntryRepository extends JpaRepository<IdClassOrderEntry, IdClassOrderEntryId> {
}
