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
    
    public User findById(final int id) {
    	return this.userRepository.findById(id);
    }
    
    public User findOne(String name, String password) {
    	User temp = null;
    	temp = this.userRepository.findByName(name);
    	if (temp != null) {
    		if (!password.equals(temp.getPassword())) {
    			temp = null;
    		}
    	}
    	return temp;
    }
    
    public int insert(String name, String password) {
    	return this.userRepository.insert(name, password);
    }
    
    public boolean updateName(int id, String name) {
    	return this.userRepository.updateName(id, name);
    }
    
    public boolean updatePassword(int id, String password) {
    	return this.userRepository.updatePassword(id, password);
    }
}
