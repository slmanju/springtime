package com.manjula.relationships.identifiers.embeddedid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntryRepository extends JpaRepository<OrderEntry, OrderEntryId> {
}
