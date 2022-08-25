package com.neo.spring_neo.repositories;

import com.neo.spring_neo.entity.Page;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PageRepository extends Neo4jRepository<Page, Long> {

    //fetching pages followed by user
    @Query("MATCH (p:Person)-[:FOLLOWS]->(pg:Page) WHERE id(p)=$id RETURN pg")
    List<Page>findFollowedPage(@Param("id")Long id);

    //fetching pages user's friends follow
    @Query("MATCH (p:Person)-[:FRIEND_WITH]-(f:Person)-[:FOLLOWS]-(pg:Page) WHERE id(p)=$userId AND NOT exists((p)-[:FOLLOWS]-(pg)) RETURN pg")
    List<Page>recommendedPages(@Param("userId")Long userId);

    //fetching pages by tag
    @Query("MATCH (pg:Page)-[:HAS_AS_TAG]-(tg:Tag) WHERE tg.name=$tag RETURN pg")
    List<Page>pagesByTag(@Param("tag") String tag);


}
