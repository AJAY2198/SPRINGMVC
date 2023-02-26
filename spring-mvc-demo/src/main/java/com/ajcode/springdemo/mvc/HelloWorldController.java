package com.ajcode.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	//new to read form data and add data to model
	@RequestMapping("/processFormVersionTwo")
	public String letsShouteDude(HttpServletRequest request, Model model) {
		//read request param from html form
		String theName = request.getParameter("studentName");
		
		theName = theName.toUpperCase();		
		String result = "Yo! " + theName;
		
		
		
		
		//add msg to model
		model.addAttribute("message", result);
		
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
	
		theName = theName.toUpperCase();		
		String result = "Hey ! " + theName;
		
		//add msg to model
		model.addAttribute("message", result);
		
		
		return "helloworld";
	}

}
