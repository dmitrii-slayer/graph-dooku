package org.konoha.graphdooku.service;

import lombok.RequiredArgsConstructor;
import org.konoha.graphdooku.domain.entity.Movie;
import org.konoha.graphdooku.domain.repository.MovieRepository;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final Neo4jTemplate neo4jTemplate;
    private final Neo4jClient neo4jClient;

    public boolean addMovie(Movie movie) {
//        movieRepository.save(movie);
//        neo4jTemplate.
        return true;
    }
}
