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
public class Page {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer nbrOfFollowers=0;
    @Relationship(type = "HAS_AS_TAG", direction = Relationship.Direction.INCOMING)
    private List<Tag> tagList=new ArrayList<>();
}
