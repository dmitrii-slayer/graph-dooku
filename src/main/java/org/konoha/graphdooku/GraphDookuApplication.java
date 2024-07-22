package org.konoha.graphdooku;

import lombok.RequiredArgsConstructor;
import org.konoha.graphdooku.domain.dao.ActedInRelationDAO;
import org.konoha.graphdooku.domain.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class GraphDookuApplication implements CommandLineRunner {

	private final MovieRepository movieRepository;
	private final ActedInRelationDAO actedInRelationDAO;

	public static void main(String[] args) {
		SpringApplication.run(GraphDookuApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String movie = "Apollo 13";
		String actor = "Tom Hanks";

//		Optional<ActedInRelation> actedInRelation = actedInRelationDAO.findRelationBetween(movie, actor);
//		Optional<ActedInRelation> actedInRelation = movieRepository.findRelationBetween(movie, actor);
//		Optional<Movie> optionalMovie = movieRepository.findRelationBetweenReturnMovie(movie, actor);
		actedInRelationDAO.findUsingClientRelationPropertiesBetween(movie, actor);
////		if (optionalMovie.isPresent()) {
//		if (actedInRelation.isPresent()) {
//			ActedInRelation acted = actedInRelation.get();
////			Movie movie = optionalMovie.get();
//			System.out.println("###################################");
////			System.out.println(movie.getTagline());
////			System.out.println(movie.getTagline());
//			System.out.println(acted.getId());
//			System.out.println(acted.getRoles());
//			System.out.println(acted.getActor());
////			System.out.println(movie.getReleased());
////			System.out.println(movie.getReleased());
//			System.out.println("###################################");
//		}
	}
}
