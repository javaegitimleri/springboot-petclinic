package com.javaegitimleri.petclinic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PetClinicController {
	
	@RequestMapping("/pcs")
	@ResponseBody
	public String welcome() {
		return "Welcome to PetClinic World!";
	}
}
