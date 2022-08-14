package com.neo.spring_neo.repositories;

import com.neo.spring_neo.entity.Post;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PostRepository extends Neo4jRepository<Post, Long> {
}
