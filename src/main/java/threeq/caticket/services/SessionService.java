package threeq.caticket.services;

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
	
	public List<Session> findAll() {
        return this.sessionRepository.findAll();
    }

    public Session findByName(final String movieName, final String cinemaName) {
        return this.sessionRepository.findByName(movieName, cinemaName);
    }
    
    public Session findById(final int id) {
        return this.sessionRepository.findById(id);
    }
}
