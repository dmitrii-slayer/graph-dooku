package org.konoha.graphdooku.domain.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;

@Data
public class Person {


    @Id
    @Property("name")
    private String name;

    @Property("born")
    private Integer born;
//
//    private Set<>
}
