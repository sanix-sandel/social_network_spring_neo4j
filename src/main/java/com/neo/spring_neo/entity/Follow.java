package com.neo.spring_neo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RelationshipProperties
public class Follow {

    @RelationshipId
    private Long id;
    private LocalDate since;
    @TargetNode
    private List<Page>pages=new ArrayList<>();

}
