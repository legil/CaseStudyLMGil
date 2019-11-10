package com.casestudy.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casestudy.model.AppUser;
import com.casestudy.model.Credential;
import com.casestudy.repository.UserRepository;

@Service("userDetailsService")
public class UserService implements UserDetailsService{

//	@Autowired
//	UserDetailsDAO userDetailsDAO;
	
	@Autowired
	UserRepository userRepository;
	
	public void saveUser(Credential user) {
		userRepository.save(user);
//		return userRepository.findByUsername(user.getUsername());
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Credential user = userRepository.findByUsername(username);
		UserBuilder builder = null;
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(user.getPassword());
			builder.disabled(!user.isEnabled());
			String[] authorities = user.getAuthorities().stream().map(a-> a.getAuthority()).toArray(String[]::new);
			builder.authorities(authorities);
		}
		else
			throw new UsernameNotFoundException("User Not Found!");
		return builder.build();
	}

}
