package com.manjula.relationships.selfreferencemany.domain.repository;

import com.manjula.relationships.selfreferencemany.domain.model.Twitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterRepository extends JpaRepository<Twitter, Long> {
}
