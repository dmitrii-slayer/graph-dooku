package org.konoha.graphdooku.domain.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.Map;
import java.util.Set;

@Data
@Node("Movie")
public class Movie {

    @Id
    @Property("title")
    private String title;

    @Property("released")
    private Integer released;

    @Property("tagline")
    private String tagline;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private Set<ActedInRelation> actedInRelations;

    @CompositeProperty
    private Map<String, Object> attributes;

}
