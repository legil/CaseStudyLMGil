package com.casestudy.controller;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.casestudy.model.Board;
import com.casestudy.model.Credential;
import com.casestudy.repository.BoardRepository;
import com.casestudy.repository.CredentialRepository;
import com.casestudy.service.CredentialService;

@Controller
public class BoardController {

    @Autowired
    CredentialService credentialService;

    @Autowired
    CredentialRepository credentialRepository;
    
    @Autowired
    BoardRepository boardRepository;

   /* @RequestMapping(value = "/createBoard") /*, method = RequestMethod.POST)
    public ModelAndView createBoard(/*@Valid @ModelAttribute("newBoardForm") Credential credential,
                                       BindingResult br, @RequestParam("boardName") String boardName,
                                       @RequestParam("description") String description,
                                       RedirectAttributes redirect) {
      
    		ModelAndView mav = new ModelAndView("newBoardForm");
    		return mav;
    	}
  */
   
    
    //set register add update delete view/display
    
    
    
    @RequestMapping(value = "/createBoard", method = RequestMethod.GET)
    public ModelAndView createBoard(@ModelAttribute("newBoardForm") Board board) {
      
    		ModelAndView mav = new ModelAndView("newBoardForm");
    		return mav;
    }
    
    
    @RequestMapping(value = "/createBoard", method = RequestMethod.POST)
    public ModelAndView saveNewBoard(@ModelAttribute("newBoardForm") Board board) {
      
    		
    	
    	ModelAndView mav = new ModelAndView("boardCollection");
    		return mav;
    }
}
