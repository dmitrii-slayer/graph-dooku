package org.konoha.graphdooku.domain.dao;

import org.konoha.graphdooku.domain.entity.ActedInRelation;

import java.util.Optional;

public interface ActedInRelationDAO {

    // Does not work since SDN 6+ https://stackoverflow.com/questions/65669613/how-do-i-return-relationship-properties-neo4j-spring-data
    Optional<ActedInRelation> findRelationBetween(String movieTitle, String personName);

    void findUsingClientRelationPropertiesBetween(String movie, String personName);
    void findUsingDriverRelationPropertiesBetween(String movie, String personName);
}
