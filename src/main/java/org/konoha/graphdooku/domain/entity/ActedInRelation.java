package org.konoha.graphdooku.domain.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.Set;

@Data
@RelationshipProperties
public class ActedInRelation {

    @RelationshipId
    private Long id;

    @TargetNode
    private Person actor;

    private Set<String> roles;
}
