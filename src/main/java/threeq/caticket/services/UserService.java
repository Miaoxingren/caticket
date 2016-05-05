package threeq.caticket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import threeq.caticket.entities.User;
import threeq.caticket.entities.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService() {
        super();
    }
	
	public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findByName(final String name) {
        return this.userRepository.findByName(name);
    }
    
    public int insert(String name, String password) {
    	return this.userRepository.insert(name, password);
    }
}
