package com.api.tripcalltwo.controller.nav;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {
	
	@GetMapping("/login")
	protected String login() {
		return "login.html";
	}
	
	

}
