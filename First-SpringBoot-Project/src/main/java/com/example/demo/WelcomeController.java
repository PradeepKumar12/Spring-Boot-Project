package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
	
	/*
	 * @GetMapping("/welcome") public String welcome() { return "Welcome "; }
	 */
	
	@RequestMapping("/welcome")
	public String home() {
		return "welcome";
	}
	
	/*
	 * @RequestMapping("/home") public String home() { return "home"; }
	 */
	 
}
