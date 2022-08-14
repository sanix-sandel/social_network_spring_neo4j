package com.neo.spring_neo.repositories;

import com.neo.spring_neo.entity.Tag;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TagRepository extends Neo4jRepository<Tag, Long> {
}
