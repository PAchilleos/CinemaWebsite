package com.qa.cinema.rest;

	import javax.inject.Inject;
	import javax.ws.rs.DELETE;
	import javax.ws.rs.GET;
	import javax.ws.rs.POST;
	import javax.ws.rs.PUT;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;

import com.qa.cinema.service.UserService;

	
	
	@Path("/user")
	public class UserEndPoint {

		@Inject
		private UserService userService;

		@GET
		@Path("/json")
		@Produces({ "application/json" })
		public String getusersAsJson() {
			return userService.getAllusers();
		}

		@POST
		@Path("/json")
		@Produces({ "application/json" })
		public String addNewuserToJson(String userJson) {
			return userService.addNewuser(userJson);
		}

		@PUT
		@Path("/json/{id}")
		@Produces({ "application/json" })
		public String replaceuser(@PathParam("id") Integer userId, String updateduser) {
			return userService.replaceuser(userId, updateduser);
		}

		@DELETE
		@Path("/json/{id}")
		@Produces({ "application/json" })
		public String deleteuser(@PathParam("id") Integer userId) {
			return userService.deleteuser(userId);
		}

	}

