package com.casestudy.repository;

import com.casestudy.model.Credential;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface CredentialRepository extends CrudRepository<Credential, String> {

    Credential findByUsername(String email);
  
}
