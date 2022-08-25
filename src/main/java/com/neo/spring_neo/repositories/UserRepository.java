package com.neo.spring_neo.repositories;

import com.neo.spring_neo.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface UserRepository extends Neo4jRepository<Person, Long> {

    //to recommend friends (friends of user's friends)
    @Query("MATCH (p:Person)-[:FRIEND_WITH]-(:Person)-[:FRIEND_WITH]-(fp:Person) WHERE p.id=userId AND NOT exists((p)-[:FRIEND_WITH]-(fp)) RETURN fp")
    List<Person> findFriendOfFriend(Long userId);

}
