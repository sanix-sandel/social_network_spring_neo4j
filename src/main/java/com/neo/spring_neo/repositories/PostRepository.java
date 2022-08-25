package com.neo.spring_neo.repositories;

import com.neo.spring_neo.entity.Page;
import com.neo.spring_neo.entity.Post;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends Neo4jRepository<Post, Long> {

    //fetch posts by tag
    @Query("MATCH (p:Post)-[:TAGGED]-(t:Tag) WHERE tg.name=$tag RETURN p")
    List<Post>postsByTag(@Param("tag") String tag);

    //fetch posts liked by user's friends
    @Query("MATCH (p:Post)-[:LIKES]-(friend:Person)-[:FRIEND_WITH]-(user:Person) AND NOT exists((user)-[:LIKES]-(p)) WHERE id(user)=$userId RETURN p")
    List<Post>recommendedPosts(@Param("userId") Long userId);
}
