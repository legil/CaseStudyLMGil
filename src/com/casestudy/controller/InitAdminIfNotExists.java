package com.casestudy.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.casestudy.model.User;
import com.casestudy.model.Authorities;
import com.casestudy.model.Credential;
import com.casestudy.repository.CredentialRepository;
import com.casestudy.service.CredentialService;

@Controller
@Transactional
public class InitAdminIfNotExists {

	@Autowired
	CredentialService userService;

	@Autowired
	CredentialRepository credentialRepository;

	//Optional
	@RequestMapping("/login")
	public void initAdmin() {

		Credential user = credentialRepository.findByUsername("kun@ps.org");

		if (user == null) {
			System.out.println("Creating admin...");
			Credential adminUser = new Credential();
			adminUser.setUsername("kun@ps.org");
			String encoded = new BCryptPasswordEncoder().encode("123456");
			adminUser.setPassword(encoded);
			adminUser.setEnabled(true);

			Authorities role = new Authorities();
			role.setCredential(adminUser);
			role.setAuthority("ROLE_ADMIN");
			
			
			User kun = new User();
			kun.setName("Kun PS");
			
			adminUser.setUser(kun);
			adminUser.getAuthorities().add(role);
			
			userService.addCredential(adminUser);
		}
	}

}
