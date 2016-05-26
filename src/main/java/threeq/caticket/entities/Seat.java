package threeq.caticket.entities;

public class Seat {
	private int id;
	private int lineCnt;
	private int chairCnt;
	private boolean[] chairs;
	private String chairstr;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLineCnt() {
		return lineCnt;
	}
	public void setLineCnt(int lineCnt) {
		this.lineCnt = lineCnt;
	}
	public int getChairCnt() {
		return chairCnt;
	}
	public void setChairCnt(int chairCnt) {
		this.chairCnt = chairCnt;
	}
	public boolean[] getChairs() {
		return chairs;
	}
	public void setChairs(boolean[] chairs) {
		this.chairs = chairs;
	}
	public void setChairsByStr(String chairstr) {
		setChairstr(chairstr);
		String[] chairArray = chairstr.split(",");
		int length = chairArray.length;
		boolean[] temp = new boolean[length];
		for (int i = 0; i < length; ++i) {
			temp[i] = (chairArray[i].equals("1") ? true : false);
		}
		setChairs(temp);
	}
	public String getChairstr() {
		return chairstr;
	}
	public void setChairstr(String chairstr) {
		this.chairstr = chairstr;
	}

}
