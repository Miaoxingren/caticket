package threeq.caticket.entities;

import java.sql.Date;
import java.sql.Time;

public class Session {
	private int id;
	private String movieName;
	private String cinemaName;
	private String language;
	private int movieId;
	private int cinemaId;
	private int room;
	private boolean isThreeD;
	private Date playDate;
	private Time beginTime;
	private Time endTime;
	private float price;
	private int seatId;
	
	public Session() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public Date getPlayDate() {
		return playDate;
	}
	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}
	public Time getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Time beginTime) {
		this.beginTime = beginTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public boolean getIsThreeD() {
		return isThreeD;
	}

	public void setIsThreeD(boolean isThreeD) {
		this.isThreeD = isThreeD;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}
	
}
