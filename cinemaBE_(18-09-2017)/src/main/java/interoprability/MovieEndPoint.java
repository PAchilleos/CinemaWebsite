package interoprability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import business.movie.MovieService;


@Path("/cinema")
public class MovieEndPoint {

	@Inject
	private MovieService movieService;

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getMoviesAsJson() {
		return movieService.getMovies();
	}

	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addNewMovieToCinema(String movieJSONObject) {
		return movieService.addMovie(movieJSONObject);
	}

	
}
