package com.neo.spring_neo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Relationship(type = "FRIEND_WITH", direction = Relationship.Direction.OUTGOING)
    private List<FriendWith> friendTo=new ArrayList<>();
    @Relationship(type = "FOLLOWS", direction = Relationship.Direction.OUTGOING)
    private List<Follow>follows=new ArrayList<>();
    private Integer nbrOfFriends=0;
}
