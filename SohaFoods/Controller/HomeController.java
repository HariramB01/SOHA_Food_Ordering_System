package com.foodOrder.SohaFoods.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping
	public String getting() {
		return "Welcome to zoya foods";
	}

}
