package com.teamone.finalproject;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView; 

@Controller
public class DemoController {
	
	HashMap<String,String> db = new HashMap<String,String>();
	
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String loginSubmission(@RequestParam("username") String userName,@RequestParam("password") String password) {
		if(db.containsKey(userName)) {
			if(db.get(userName).equals(password)) {
				return "home";
			}else {
				return "failed_page";
			}
		}else {
			return "failed_page";
		}
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String RegisterSubmission(@RequestParam("username") String userName,@RequestParam("password") String password) {
			db.put(userName,password);
	return "/login";
	}
}
	
	
	
	
	
	
	

