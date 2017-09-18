package business.movie;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import persistence.Movie;

import util.JSONUtil;

@Default
@Stateless
public class MovieDBImpl implements MovieService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;
	
	public String addMovie(String jsonMovie) {
		Movie newMovie = util.getObjectForJSON(jsonMovie, Movie.class);
		em.persist(newMovie);
		return jsonMovie;
	}
	

	public String getMovies() {
		Query query = em.createQuery("SELECT m FROM Movie m");
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		return util.getJSONForObject(movies);
	}

}
