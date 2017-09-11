package com.qa.cinema.rest;

	import javax.inject.Inject;
	import javax.ws.rs.DELETE;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.PUT;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;

import com.qa.cinema.service.MovieService;

	
	
	@Path("/movieList")
	public class MovieEndPoint {

		@Inject
		private MovieService movieService;

		@GET
		@Path("/json")
		@Produces({ "application/json" })
		public String getMoviesAsJson() {
			return movieService.getAllMovies();
		}

		@POST
		@Path("/json")
		@Produces({ "application/json" })
		public String addNewMovieToJson(String movieJson) {
			return movieService.addNewMovie(movieJson);
		}

		@PUT
		@Path("/json/{id}")
		@Produces({ "application/json" })
		public String replaceMovie(@PathParam("id") Integer movieId, String updatedMovie) {
			return movieService.replaceMovie(movieId, updatedMovie);
		}

		@DELETE
		@Path("/json/{id}")
		@Produces({ "application/json" })
		public String deleteMovie(@PathParam("id") Integer movieId) {
			return movieService.deleteMovie(movieId);
		}

	}

