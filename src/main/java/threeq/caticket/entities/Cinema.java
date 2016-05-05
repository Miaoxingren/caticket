package threeq.caticket.entities;

public class Cinema {
	private int id;
	private String name;
	private String area;
	private String location;
	private String phone;
	private float score;
	private int[] movieList;
	
	public Cinema() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int[] getMovieList() {
		return movieList;
	}
	public void setMovieList(int[] movieList) {
		this.movieList = movieList;
	}

}
