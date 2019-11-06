package com.casestudy.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.casestudy.model.AppUser;
import com.casestudy.model.Authorities;
import com.casestudy.model.Credential;
import com.casestudy.repository.UserRepository;
import com.casestudy.service.UserService;

@Controller
@Transactional
public class InitAdminIfNotExists {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	//Optional
	@RequestMapping("/login")
	public void initAdmin() {

		Credential user = userRepository.findByUsername("kun@ps.org");

		if (user == null) {
			System.out.println("Creating admin...");
			Credential adminUser = new Credential();
			adminUser.setUsername("kun@ps.org");
			String encoded = new BCryptPasswordEncoder().encode("123456");
			adminUser.setPassword(encoded);
			adminUser.setEnabled(true);

			Authorities role = new Authorities();
			role.setUser(adminUser);
			role.setAuthority("ROLE_ADMIN");
			
			
			AppUser kun = new AppUser();
			kun.setName("Kun PS");
			
			adminUser.setAppUser(kun);
			adminUser.getAuthorities().add(role);
			
			userService.saveUser(adminUser);
		}
	}

}
