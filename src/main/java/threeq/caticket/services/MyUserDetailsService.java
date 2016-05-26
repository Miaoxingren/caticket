package threeq.caticket.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import threeq.caticket.entities.User;
import threeq.caticket.entities.repositories.UserRepository;

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		User user = new User();
		try {
			user = userDao.findByName(username);
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority("miao");
			auths.add(authority);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new org.springframework.security.core.userdetails.User(
				user.getName(), user.getPassword(), true, true, true, true,
				auths);
	}

}
