package org.konoha.graphdooku.domain.repository;

import org.konoha.graphdooku.domain.entity.ActedInRelation;
import org.konoha.graphdooku.domain.entity.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MovieRepository extends Neo4jRepository<Movie, String> {

    // Does not work since SDN 6+ https://stackoverflow.com/questions/65669613/how-do-i-return-relationship-properties-neo4j-spring-data
//    @Query("MATCH (m:Movie {title: $movieTitle})-[r]-(p:Person {name: $actorName}) RETURN properties(r)")
    @Query("MATCH (m:Movie {title: $movieTitle})-[r]-(p:Person {name: $actorName}) RETURN r")
    Optional<ActedInRelation> findRelationBetween(@Param("movieTitle") String movie, @Param("actorName") String actorName);

    @Query("MATCH (m:Movie {title: $movieTitle})-[r]-(p:Person {name: $actorName}) RETURN m")
    Optional<Movie> findRelationBetweenReturnMovie(@Param("movieTitle") String movie, @Param("actorName") String actorName);
}
