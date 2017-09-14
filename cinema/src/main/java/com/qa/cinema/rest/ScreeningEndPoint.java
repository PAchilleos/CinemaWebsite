package com.qa.cinema.rest;

	import javax.inject.Inject;
	import javax.ws.rs.DELETE;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.PUT;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;

import com.qa.cinema.service.ScreeningService;

	
	
	@Path("/screening")
	public class ScreeningEndPoint {

		@Inject
		private ScreeningService screeningService;

		@GET
		@Path("/json")
		@Produces({ "application/json" })
		public String getscreeningsAsJson() {
			return screeningService.getAllscreenings();
		}

		@POST
		@Path("/json")
		@Produces({ "application/json" })
		public String addNewscreeningToJson(String screeningJson) {
			return screeningService.addNewscreening(screeningJson);
		}

		@PUT
		@Path("/json/{id}")
		@Produces({ "application/json" })
		public String replacescreening(@PathParam("id") Integer screeningId, String updatedscreening) {
			return screeningService.replacescreening(screeningId, updatedscreening);
		}

		@DELETE
		@Path("/json/{id}")
		@Produces({ "application/json" })
		public String deletescreening(@PathParam("id") Integer screeningId) {
			return screeningService.deletescreening(screeningId);
		}

	}


