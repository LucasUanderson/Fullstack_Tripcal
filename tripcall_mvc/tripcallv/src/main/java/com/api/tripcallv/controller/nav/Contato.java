package com.api.tripcallv.controller.nav;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Contato {
	

	@GetMapping("home/contato")
	protected String contato () {
		return "contato.html";
	}

}
