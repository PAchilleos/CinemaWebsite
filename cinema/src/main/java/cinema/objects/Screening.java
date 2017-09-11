package cinema.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Screening {
	@JsonProperty
	private String movie_title;
	@JsonProperty
	private String screen;
	@JsonProperty
	private String time;
	@JsonProperty
	private boolean[] seats;
	
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public boolean[] getSeats() {
		return seats;
	}
	public void setSeats(boolean[] seats) {
		this.seats = seats;
	}
}
