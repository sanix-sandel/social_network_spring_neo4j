package com.neo.spring_neo.repositories;

import com.neo.spring_neo.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface UserRepository extends Neo4jRepository<Person, Long> {

    @Query("MATCH (p:Person)-[:FRIEND_WITH]-(:Person)-[:FRIEND_WITH]-(fp:Person) WHERE p.id=userId RETURN fp")
    List<Person> findFriendOfFriend(Long userId);
}
