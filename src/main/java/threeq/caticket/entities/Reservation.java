package threeq.caticket.entities;

public class Reservation {
	private int id;
	private String movieName;
	private String cinemaName;
	private int ticketCnt;
	private String[] position;
	
	public Reservation() {
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
	public int getTicketCnt() {
		return ticketCnt;
	}
	public void setTicketCnt(int ticketCnt) {
		this.ticketCnt = ticketCnt;
	}
	public String[] getPosition() {
		return position;
	}
	public void setPosition(String[] position) {
		this.position = position;
	}

}
