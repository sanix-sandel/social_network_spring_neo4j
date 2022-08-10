package com.neo.spring_neo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor
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
