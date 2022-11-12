package com.api.tripcallv.controller.nav;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Promocao {
	
	@GetMapping("home/promocao")
	protected String promocao() {
		return "promocao.html";
	}

}
