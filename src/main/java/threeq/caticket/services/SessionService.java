package threeq.caticket.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import threeq.caticket.entities.Session;
import threeq.caticket.entities.repositories.SessionRepository;

@Service
public class SessionService {
	@Autowired
	private SessionRepository sessionRepository;
	
	public SessionService() {
        super();
    }
	public List<Session> findByDate(Date date) {
		return this.sessionRepository.findByDate(date);
	}
    
	public List<Session> findAll() {
        return this.sessionRepository.findAll();
    }

    public Session findByMandC(final int movieId, final int cinemaId) {
        return this.sessionRepository.findByMandC(movieId, cinemaId);
    }
    
    public Session findById(final int id) {
        return this.sessionRepository.findById(id);
    }
}
