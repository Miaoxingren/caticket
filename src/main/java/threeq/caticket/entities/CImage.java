package threeq.caticket.entities;

import java.sql.Blob;

public class CImage {
	private int id;
	private String name;
	private Blob source;
	public Blob getSource() {
		return source;
	}
	public void setSource(Blob source) {
		this.source = source;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
