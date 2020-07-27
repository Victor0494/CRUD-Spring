package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.models.Contato;
import com.crud.repository.ContatoRepository;

@Controller
public class ContatoController {
 
	
	@Autowired
	private ContatoRepository er;
	
	@RequestMapping(value="/cadastrarContato", method=RequestMethod.GET)
	public String form() {
		return "contato/formContato";
		
	}
	
	@RequestMapping(value="/cadastrarContato", method=RequestMethod.POST)
	public String form(Contato contato) {
		
		er.save(contato);
		
		return "redirect:/cadastrarContato";
		
	}
}
