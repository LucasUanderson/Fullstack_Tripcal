package com.api.tripcalltwo.controller.nav;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Destino {
	
	@GetMapping("/destino")
	protected String destino() {
		return "destino.html";
	}

}
