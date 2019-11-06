package com.casestudy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Credential;

@Repository
public interface UserRepository extends CrudRepository<Credential, String>{
	Credential findByUsername(String username);
	
}
