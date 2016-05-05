package threeq.caticket.entities;

import java.util.List;

public class Line {
	private int number;
	private List<Chair> chairs;
	
	public Line() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Chair> getChairs() {
		return chairs;
	}

	public void setChairs(List<Chair> chairs) {
		this.chairs = chairs;
	}
}
