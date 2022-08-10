package com.neo.spring_neo.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDate;

@RelationshipProperties
public class FriendTo {

    @Id
    @GeneratedValue
    private Long id;
    @Property("since")
    private LocalDate date;
    @TargetNode
    private Person friendTo;

}
