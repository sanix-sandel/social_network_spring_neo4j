package com.neo.spring_neo.repositories;

import com.neo.spring_neo.entity.Page;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PageRepository extends Neo4jRepository<Page, Long> {

    @Query("MATCH (p:Person)-[:FOLLOWS]->(pg:Page) WHERE id(p)=$id RETURN pg")
    List<Page>findFollowedPage(@Param("id")Long id);

    @Query("MATCH (p:Person)-[:FRIEND_WITH]-(f:Person)-[:FOLLOWS]-(p:Page) WHERE p.userId=userId RETURN p")
    List<Page>recommendedPages(@Param("userId")Long userId);


}
