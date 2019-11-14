package com.casestudy.repository;


import com.casestudy.model.BoardCollection;
import com.casestudy.model.Credential;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface BoardRepository extends CrudRepository<Credential, String> {

	    BoardCollection getBoardCollectionByUsername(String username);
	  
	}
