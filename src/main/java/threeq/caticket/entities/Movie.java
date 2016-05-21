package threeq.caticket.entities;

import java.util.Date;

public class Movie {
	private int id;
	private String name;
	private Date releaseTime;
	private int timeLength;
	private String[] doctors;
	private String[] actors;
	private String[] movieTypes;
	private int[] cinemaList;
	private String detail;
	private float lowCost;
	private float score;
	
	public Movie() {
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
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public int getTimeLength() {
		return timeLength;
	}
	public void setTimeLength(int timeLength) {
		this.timeLength = timeLength;
	}
	public String[] getDoctors() {
		return doctors;
	}
	public String printDoctors() {
		String temp = "";
		if (doctors != null) {
			int i, l = doctors.length;
			if (l != 0) temp += doctors[0];
			for (i = 1; i < l; i++) {
				temp += "/" + doctors[i];
			}
		}
		return temp;
	}
	public void setDoctors(String[] doctors) {
		this.doctors = doctors;
	}
	public String[] getActors() {
		return actors;
	}
	public String printActors() {
		String temp = "";
		if (actors != null) {
			int i, l = actors.length;
			if (l != 0) temp += actors[0];
			for (i = 1; i < l; i++) {
				temp += "/" + actors[i];
			}
		}
		return temp;
	}
	public void setActors(String[] actors) {
		this.actors = actors;
	}
	public String[] getMovieTypes() {
		return movieTypes;
	}
	public String printMovieTypes() {
		String temp = "";
		if (movieTypes != null) {
			int i, l = movieTypes.length;
			if (l != 0) temp += movieTypes[0];
			for (i = 1; i < l; i++) {
				temp += "/" + movieTypes[i];
			}
		}
		return temp;
	}
	public void setMovieTypes(String[] movieTypes) {
		this.movieTypes = movieTypes;
	}
	public int[] getCinemaList() {
		return cinemaList;
	}
	public void setCinemaList(int[] cinemalist) {
		this.cinemaList = cinemalist;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public float getLowCost() {
		return lowCost;
	}
	public void setLowCost(float lowCost) {
		this.lowCost = lowCost;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}

}
