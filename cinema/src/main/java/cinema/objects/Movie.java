package cinema.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
	
	@JsonProperty
	private String title;
	@JsonProperty
	private String genre;
	@JsonProperty
	private String img;
	@JsonProperty
	private String description;
	@JsonProperty
	private String rating;
	@JsonProperty
	private String age;
	@JsonProperty
	private String vid;
	
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}	



}
