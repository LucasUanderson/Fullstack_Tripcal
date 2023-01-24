package com.api.tripcalltwo.controller.nav;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Contato {
	
	
	@GetMapping("/contato")
	protected String contato() {
		return "contato.html";
	}

}
