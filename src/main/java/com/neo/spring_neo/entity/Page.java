package com.neo.spring_neo.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

public class Page {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer nbrOfFollowers=0;
}
