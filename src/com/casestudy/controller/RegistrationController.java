package com.casestudy.controller;

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
import com.casestudy.model.AppUser;
import com.casestudy.repository.CredentialRepository;
import com.casestudy.service.UserService;

@Controller
public class RegistrationController {

	// Needed to save user to database
	@Autowired
	CredentialRepository credentialRepo;
	
	UserService userService;

	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	    public ModelAndView getUserCredentialForm() {
	        ModelAndView mav = new ModelAndView("register");
	        mav.addObject("userCredentialFormObj", new Credential()); //add form to view?
	        return mav;
	}
	
	@RequestMapping(value = "processUserCredential", method = RequestMethod.POST) //on submit
	public void getRegistrationForm(@ModelAttribute("userCredentialFormObj") Credential credential, BindingResult br, 
											@RequestParam("confPassword") String confirmPassword, @RequestParam("name") String firstName,  RedirectAttributes redirect) {
		ModelAndView mav = null;
		Credential registerCredential = credential;

		if (br.hasErrors() || credential == null) { //If form has validation errors or credential field is null
			mav = new ModelAndView("register");
			mav.addObject("message", "There was an error registering your account");
		} else { //if form is valid 
			if (credential.getPassword().equals(confirmPassword)) { //pw = pw/ valid form
				// Grab user from credential object
				AppUser user = credential.getAppUser(); 

				// Authority
				Authorities authority = new Authorities();
				// Everyone besides me will automatically be a user
				authority.setAuthority("user");

				String securePassword = new BCryptPasswordEncoder().encode(credential.getPassword());
				user.setName(firstName);
				registerCredential.getAppUser().setName(firstName);
				registerCredential.setPassword(securePassword);
				registerCredential.setAppUser(user);
				registerCredential.getAuthorities().add(authority);
				
				authority.setUser(registerCredential);

				//credentialRepo.save(registerCredential);
				userService.saveUser(registerCredential);
//				mav = new ModelAndView("redirect:/login");
//				redirect.addFlashAttribute("message", "Successfully registered account.\nYou can login using the account.");

			} 
			/*else {
				
				//mav = new ModelAndView("redirect:/register");
			}*/
		}

		//return mav;
	}
}
