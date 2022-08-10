package com.neo.spring_neo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Node
@Data
@NoArgsConstructor
public class Tag {

    @Id @GeneratedValue
    private Long id;
    private String name;

}
