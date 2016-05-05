package threeq.caticket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import threeq.caticket.entities.Reservation;
import threeq.caticket.entities.repositories.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	public ReservationService() {
        super();
    }
	
	public List<Reservation> findAll() {
        return this.reservationRepository.findAll();
    }

    public Reservation findByName(final String movieName, final String cinemaName) {
        return this.reservationRepository.findByName(movieName, cinemaName);
    }
    
    public Reservation findById(final int id) {
        return this.reservationRepository.findById(id);
    }
}
