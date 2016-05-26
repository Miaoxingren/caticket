package threeq.caticket.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import threeq.caticket.entities.Chair;
import threeq.caticket.entities.Reservation;
import threeq.caticket.entities.repositories.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	public ReservationService() {
        super();
    }

    public List<Reservation> findByUserId(final int userId) {
        return this.reservationRepository.findByUserId(userId);
    }
    
    public Reservation findById(final int id) {
        return this.reservationRepository.findById(id);
    }
    
    public boolean addOne(final Reservation reservation) {
    	return this.reservationRepository.addOne(reservation);
    }
    
    public List<Chair> createFromSeat(int seatCnt, String seatStr) {
		List<Chair> temp = new ArrayList<Chair>();
		String[] seats = seatStr.split(",");
		for (int i = 0; i < seatCnt; ++i) {
			String[] info = seats[i].split("-");
			Chair chair = new Chair();
			chair.setLineNo(Integer.parseInt(info[0]));
			chair.setNumber(Integer.parseInt(info[1]));
			temp.add(chair);
		}
		return temp;
	}
    
    public List<Chair> getSeatsById(int id) {
    	Reservation reservation = this.reservationRepository.findById(id);
    	return createFromSeat(reservation.getSeatCnt(), reservation.getSeats());
    }
}
