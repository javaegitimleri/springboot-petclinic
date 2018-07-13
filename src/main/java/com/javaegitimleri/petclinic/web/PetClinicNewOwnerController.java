package com.javaegitimleri.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaegitimleri.petclinic.model.Owner;
import com.javaegitimleri.petclinic.service.PetClinicService;

@Controller
public class PetClinicNewOwnerController {
	
	@Autowired
	private PetClinicService petClinicService;
	
	@RequestMapping(value="/owners/new",method=RequestMethod.GET)
	public String newOwner() {
		return "newOwner";
	}
	
	@ModelAttribute
	public Owner initModel() {
		return new Owner();
	}
	
	@RequestMapping(value="/owners/new",method=RequestMethod.POST)
	public String handleFormSubmit(@ModelAttribute Owner owner) {
		petClinicService.createOwner(owner);
		return "redirect:/owners";
	}
}
