package com.neo.spring_neo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Node
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String content;
    private Integer likes;
    private Date postedOn;
    @Relationship(type = "LIKES", direction = Relationship.Direction.INCOMING)
    List<Person>likers=new ArrayList<>();
    @Relationship(type = "TAGGED", direction = Relationship.Direction.INCOMING)
    List<Tag>tagList=new ArrayList<>();
}
