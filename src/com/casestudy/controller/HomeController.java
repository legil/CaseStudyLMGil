package com.casestudy.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.model.Credential;
import com.casestudy.repository.UserRepository;

@Controller
public class HomeController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/")
	public ModelAndView getHome(Model model, Principal principal) {
		ModelAndView mav = new ModelAndView("home");
		if (principal.getName() == null)
			return new ModelAndView("redirect:/login");
		
		Credential credential = userRepository.findByUsername(principal.getName());
		mav.addObject("credential", credential);
		return mav;
	}
	
	@RequestMapping("/register")
	public ModelAndView getSubscriber() {
		System.out.println("In the subs!");
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}
	
	@RequestMapping("/contactus")
	public ModelAndView getContact() {
		System.out.println("In contact!");
		ModelAndView mav = new ModelAndView("contact");
		return mav;
	}
	
	@RequestMapping("/admin")
	public ModelAndView getAdmin() {
		System.out.println("You are an Admin!");
		ModelAndView mav = new ModelAndView("admin");
		return mav;
	}
	
	@RequestMapping("/all")
	public ModelAndView getSudo() {
		System.out.println("You are a SUDO!");
		ModelAndView mav = new ModelAndView("all");
		return mav;
	}
	
	@RequestMapping("/403")
	public ModelAndView get403Page(Principal principal) {
		ModelAndView mav = new ModelAndView("403page");
		if (principal != null)
			mav.addObject("message", "Hi " + principal.getName() + " you don't have access to this page!");
		else {
			mav.addObject("message",  "You don't have to this page!");
		}
		return mav;
	}
}
