package com.jd.relationships.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jd.relationships.models.License;
import com.jd.relationships.models.Person;
import com.jd.relationships.services.RelationshipService;

@Controller
public class RelationshipController {
	@Autowired
	private RelationshipService relSer;
	
	protected Integer num = 15;

	@RequestMapping("/person/new")
	public String index(@ModelAttribute("person") Person person) {
		return "new-person.jsp";
	}

	@RequestMapping("/license/new")
	public String license(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("persons", relSer.allPersons());
		return "new-license.jsp";
	}
	
	@RequestMapping("/testing")
	public String test(@RequestParam("person") Long id, @RequestParam("state") String state, @RequestParam("date") Date expire) {
		License new_license = new License();
		// if statements to determine length of license plate so far to address leading zeroes
		String padded = String.format("%06d" , num);
		new_license.setNumber(padded);
		new_license.setExpirationDate(expire);
		new_license.setState(state);
		new_license.setPerson(relSer.findPerson(id));
		relSer.create(new_license);
		num++;
		return "redirect:/license/new";
	}

// create a new person if it passes validation
	@RequestMapping(value = "/create-person", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "new-person.jsp";
		} else {
			relSer.create(person);
			return "redirect:/person/new";
		}
	}




	// display the information pertaining to the license
	@RequestMapping("persons/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Person person = relSer.findPerson(id);
		License license = relSer.findLicense(id);
		model.addAttribute("person", person);
		model.addAttribute("license", license);
		return "show.jsp";
	}
}