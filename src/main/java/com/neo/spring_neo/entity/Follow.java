package com.neo.spring_neo.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RelationshipProperties
public class Follow {

    @Id @GeneratedValue
    private Long id;
    private LocalDate since;
    @TargetNode
    private List<Page>pages=new ArrayList<>();

}
