package com.api.tripcallv.controller.nav;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Destino {
	
	@GetMapping("home/destino")
	protected String destino () {
		return "destino.html";
	}

}
