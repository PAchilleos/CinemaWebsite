package persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Screening {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	private String movie_title;

	private String screen;

	private String date_time;	

	public Screening() {
	}

	public Screening(long id, String movie_title, String screen, String date_time) {
		super();
		this.id = id;
		this.movie_title = movie_title;
		this.screen = screen;
		this.date_time = date_time;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	
	
	
	

}
