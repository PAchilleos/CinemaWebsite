package business.seat;

public interface SeatService {
	
	String getSeats();
	String addSeat(String jsonUser);
	String bookSeat(Long id);
	

}
