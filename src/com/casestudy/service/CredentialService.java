package com.casestudy.service;

import com.casestudy.model.Authorities;
import com.casestudy.model.Credential;
import com.casestudy.model.User;
import com.casestudy.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CredentialService implements UserDetailsService {

    @Autowired
    CredentialRepository credentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Credential credential = credentialRepository.findByUsername(username);

        User user = credential.getUser();

        UserBuilder userBuilder = null;

        if (user != null) {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);
            userBuilder.password(credential.getPassword());
            userBuilder.disabled(false);
            userBuilder.authorities(credential.getAuthorities().stream().map(Authorities::getAuthority).toArray(String[]::new));
        } else {
            throw new UsernameNotFoundException("Credentials not found!");
        }
        return userBuilder.build();

    }

    public List<Credential> getAllCredentials() {
        List<Credential> credentials = new ArrayList<>();
        credentialRepository.findAll().forEach(credentials::add);
        return credentials;
    }

    public Credential getCredentialByUsername(String username) {
        return credentialRepository.findByUsername(username);
    }

    public boolean addCredential(Credential credential) {
        return credentialRepository.save(credential) != null;
    }

    public boolean updateCredential(Credential credential) {
        return credentialRepository.save(credential) != null;
    }

    public void deleteCredential(Credential credential) {
        credentialRepository.delete(credential);
    }


}
