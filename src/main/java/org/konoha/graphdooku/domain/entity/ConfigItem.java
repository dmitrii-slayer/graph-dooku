package org.konoha.graphdooku.domain.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.CompositeProperty;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.support.DateLong;

import java.time.Instant;
import java.util.Map;

@Data
@Builder
@Node("CI")
public class ConfigItem {

    @Id
    @Property("businessId")
    private String businessId;

    @CompositeProperty(prefix = "fields")
    private Map<String, Object> fields;

//    @DateLong
//    private Instant

}
