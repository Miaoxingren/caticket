package threeq.caticket.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import threeq.caticket.entities.User;
import threeq.caticket.entities.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
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
    
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		User user = new User();
		try {
			user = userRepository.findByName(username);
			if (user != null) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
				auths.add(authority);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new org.springframework.security.core.userdetails.User(
				user.getName(), user.getPassword(), true, true, true, true,
				auths);
	}
}
