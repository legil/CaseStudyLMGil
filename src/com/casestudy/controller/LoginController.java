package com.casestudy.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casestudy.model.Authorities;
import com.casestudy.model.Credential;
import com.casestudy.model.User;
import com.casestudy.repository.CredentialRepository;
import com.casestudy.service.CredentialService;

@Controller
public class LoginController {

    @Autowired
    CredentialService credentialService;

    @Autowired
    CredentialRepository credentialRepository;
/*
    @RequestMapping("/register")
    public ModelAndView getSignUpPage() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("registrationFormObject", new Credential());
        return mav;
    }
    */

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView registerAction(@Valid @ModelAttribute("userCredentialFormObj") Credential credential,
                                       BindingResult br, @RequestParam("name") String name,
                                       @RequestParam("confirmPassword") String confPassword,
                                       RedirectAttributes redirect) {
        ModelAndView mav = null;
        System.out.println(credential.getUsername());
       // Credential cred = credentialService.getCredentialByUsername(credential.getUsername());
       

        if (br.hasErrors() || credential == null) {
            br.getAllErrors().forEach(System.out::println);
            mav = new ModelAndView("register");
            mav.addObject("message", "There was an error registering your account - please try again.");
        } else {
        	
            if (credential.getPassword().equals(confPassword)) {
            	Credential cred = new Credential();

               // newUser.setUserPosts(new ArrayList<>());
               // newUser.setUserComments(new ArrayList<>());
                //System.out.println(credential.getUsername());
                //System.out.println(credential.getPassword());
                //System.out.println(name);
                //System.out.println(confPassword);
                
                cred.setUsername(credential.getUsername());
                cred.setPassword(new BCryptPasswordEncoder().encode(credential.getPassword()));
                cred.setEnabled(true);

                Authorities authority = new Authorities();
                authority.setAuthority("user");
                cred.getAuthorities().add(authority);
                authority.setCredential(cred);
                User newUser = new User();
                newUser.setName(name);
                cred.setUser(newUser);

               
    			//newUser.setName(name);

                
                //cred has username, password, enabled, authorities and user(id and name);
                
                System.out.println(credentialService.addCredential(cred));
                mav = new ModelAndView("registrationConfirmation");
                mav.addObject("message", String.format("Credential successfully created for %s", cred.getUsername()));
            } else {
                redirect.addFlashAttribute("message", "Something went wrong! Please try registering again.");
                mav = new ModelAndView("redirect:/register");
            }
        }
        return mav;
    }

    @RequestMapping("/boards")
    public ModelAndView showBoards() {
        ModelAndView mav = new ModelAndView("boardCollection");
       // mav.addObject("registrationFormObject", new Credential());
        return mav;
    }
}