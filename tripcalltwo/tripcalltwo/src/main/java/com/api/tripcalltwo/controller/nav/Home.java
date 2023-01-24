package com.api.tripcalltwo.controller.nav;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
	
	@GetMapping("/home")
	protected String home() {
		return "index.html";
	}

}
