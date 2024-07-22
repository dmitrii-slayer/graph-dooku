package org.konoha.graphdooku.domain.dao;

import lombok.RequiredArgsConstructor;
import org.konoha.graphdooku.domain.entity.ActedInRelation;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Query;
import org.neo4j.driver.Record;
import org.neo4j.driver.Session;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Repository
public class ActedInRelationDAOImpl implements ActedInRelationDAO {

    private final Neo4jTemplate neo4jTemplate;
    private final Neo4jClient neo4client;
    private final Driver driver;

    // Does not work since SDN 6+ https://stackoverflow.com/questions/65669613/how-do-i-return-relationship-properties-neo4j-spring-data
    @Override
    public Optional<ActedInRelation> findRelationBetween(String movieTitle, String personName) {
        return neo4jTemplate.findOne("MATCH (m:Movie {title: $movieTitle })-[r]-(p:Person {name: $actorName })" +
                        " RETURN properties(r)",
                Map.of("movieTitle", movieTitle, "actorName", personName), ActedInRelation.class);
    }

    @Override
    public void findUsingClientRelationPropertiesBetween(String movie, String personName) {
        Optional<Map<String, Object>> optionalMap = neo4client.query("MATCH (m:Movie {title: $movieTitle })-[r]-(p:Person {name: $actorName })" +
                " RETURN properties(r)").bindAll(Map.of("movieTitle", movie, "actorName", personName)).fetch().one();
        if (optionalMap.isPresent()) {
            Set<Map.Entry<String, Object>> entries = optionalMap.get().entrySet();
            entries.forEach(e -> {
                if (e.getKey().equals("properties(r)")) {
                    Map<String, Object> properties = (Map<String, Object>) e.getValue();
                    List<String> roles = (List<String>) properties.get("roles");
                    roles.forEach(System.out::println);
                }
            });
        }
    }

    @Override
    public void findUsingDriverRelationPropertiesBetween(String movie, String personName) {
        try (Session session = driver.session()) {
//            List<Record> records = session.run(new Query(...).withParameters(Map.of("param1", "value1"))).list();
            List<Record> records = session.run("MATCH (m:Movie) RETURN m.title as title").list();
            records.forEach(r -> System.out.println(r.get("title")));
        }
    }

}
