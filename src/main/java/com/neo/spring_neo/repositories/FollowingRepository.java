package com.neo.spring_neo.repositories;

import com.neo.spring_neo.entity.Follow;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FollowingRepository extends Neo4jRepository<Follow, Long> {
}
