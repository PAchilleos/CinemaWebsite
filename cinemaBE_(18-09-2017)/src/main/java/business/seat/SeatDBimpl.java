package business.seat;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import persistence.Seat;
import util.JSONUtil;

@Default
@Stateless
public class SeatDBimpl implements SeatService {

	private static final Logger LOGGER = Logger.getLogger(SeatDBimpl.class);

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	public String getSeats() {
		Query query = em.createQuery("SELECT s FROM Seat s");
		Collection<Seat> seats = (Collection<Seat>) query.getResultList();
		return util.getJSONForObject(seats);
	}

	public String addSeat(String jsonSeat) {
		Seat newSeat = util.getObjectForJSON(jsonSeat, Seat.class);
		newSeat.setId(newSeat.getScreenID()+newSeat.getNumber());
		em.persist(newSeat);
		return jsonSeat;
	}

	public String bookSeat(String seatId) {
		
		Seat seatToBook = null;	
		try {
			Query query = em.createQuery("SELECT s FROM Seat s WHERE s.id = :id").setParameter("id", seatId);
			seatToBook = (Seat) query.getSingleResult();
		} catch (Exception e) {			
			LOGGER.info("didn't work");
			
		}

		seatToBook.setBooked(true);
		em.merge(seatToBook);
		return util.getJSONForObject(seatToBook);
	}
}