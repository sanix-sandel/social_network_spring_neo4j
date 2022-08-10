package com.neo.spring_neo.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Relationship(type = "friend_to", direction = Relationship.Direction.OUTGOING)
    private List<FriendTo> friendTo=new ArrayList<>();
    @Relationship(type = "follows", direction = Relationship.Direction.OUTGOING)
    private List<Follow>follows=new ArrayList<>();
    private Integer nbrOfFriends=0;
}
