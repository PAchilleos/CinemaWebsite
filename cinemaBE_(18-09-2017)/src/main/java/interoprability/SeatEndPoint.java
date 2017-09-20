package interoprability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import business.seat.SeatService;

@Path("/seat")
public class SeatEndPoint {

	@Inject
	private SeatService seatService;

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getSeatsAsJson() {
		return seatService.getSeats();
	}

	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addNewSeatToJson(String seatJson) {
		return seatService.addSeat(seatJson);
	}

	@PUT
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String bookSeat(@PathParam("id") String seatId) {
		return seatService.bookSeat(seatId);
	}

	// @DELETE
	// @Path("/json/{id}")
	// @Produces({ "application/json" })
	// public String deleteuser(@PathParam("id") Integer userId) {
	// return userService.deleteuser(userId);
	// }

}
