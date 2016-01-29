package com.gmail.ivanytskyy.vitaliy.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 * AcademyController class
 * @author Vitaliy Ivanytskyy
 */
@Controller
public class AcademyController {	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String getAbout(){
		return "about";
	}
}