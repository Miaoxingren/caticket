package threeq.caticket.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import threeq.caticket.entities.Chair;
import threeq.caticket.entities.Line;
import threeq.caticket.entities.Seat;
import threeq.caticket.entities.SeatInfo;
import threeq.caticket.entities.repositories.SeatRepository;

@Service
public class SeatService {
	@Autowired
	private SeatRepository seatRepository;
	
	public SeatService() {
        super();
    }
	
	private Seat findSeatById(final int id) {
        return this.seatRepository.findById(id);
    }
	
	public List<Line> createFromSeat(Seat seat) {
		List<Line> temp = new ArrayList<Line>();
		int lineCnt = seat.getLineCnt();
		int chairCnt = seat.getChairCnt();
		boolean[] seats = seat.getChairs();
		for (int i = 1, k = 0; i <= lineCnt; ++i) {
			Line line = new Line();
			line.setNumber(i);
			List<Chair> chairs = new  ArrayList<Chair>();
			for (int j = 1; j <= chairCnt; ++j, ++k) {
				Chair chair = new Chair();
				chair.setLineNo(i);
				chair.setNumber(j);
				chair.setAvailable(seats[k]);
				chairs.add(chair);
			}
			line.setChairs(chairs);
			temp.add(line);
		}
		return temp;
	}
	
	public List<Line> findById(final int id) {
		Seat seat = this.findSeatById(id);
		return createFromSeat(seat);
	}
	
	public boolean updateSeat(final int seatId, final SeatInfo seatInfo) {
		Seat seat = this.findSeatById(seatId);
		int chairCnt = seat.getChairCnt();
		String[] seats = seat.getChairstr().split(",");
		String[] selected = seatInfo.getSeats().split(",");
		for (int i = 0, cnt = seatInfo.getSeatCnt(); i < cnt; ++i) {
			String[] temp = selected[i].split("-");
			int line = Integer.parseInt(temp[0]);
			int chair = Integer.parseInt(temp[1]);
			int index = (line - 1) * chairCnt + chair - 1;
			seats[index] = "0";
		}
		String chairs = String.join(",", seats);
		return this.seatRepository.updateSeat(seatId, chairs);
	}
	
}
