package threeq.caticket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import threeq.caticket.entities.Cinema;
import threeq.caticket.entities.repositories.CinemaRepository;

@Service
public class CinemaService {
	@Autowired
	private CinemaRepository cinemaRepository;
	
	public CinemaService() {
        super();
    }
	
	public List<Cinema> findAll() {
        return this.cinemaRepository.findAll();
    }

    public Cinema findByName(final String name) {
        return this.cinemaRepository.findByName(name);
    }
    
    public Cinema findById(final int id) {
        return this.cinemaRepository.findById(id);
    }
}
