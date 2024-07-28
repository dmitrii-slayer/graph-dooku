package org.konoha.graphdooku.domain.repository;

import org.konoha.graphdooku.domain.entity.ConfigItem;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ConfigItemRepository extends Neo4jRepository<ConfigItem, String> {

}
