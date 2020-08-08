package com.crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.models.Contato;
import com.crud.models.Produto;
import com.crud.repository.ContatoRepository;
import com.crud.repository.ProdutoRepository;

@Controller
public class ContatoController {

	@Autowired
	private ContatoRepository er;
	
	@Autowired
	private ProdutoRepository cr;

	@RequestMapping(value = "/cadastrarContato", method = RequestMethod.GET)
	public String form() {
		return "contato/formContato";

	}

	@RequestMapping(value="/cadastrarContato", method = RequestMethod.POST)
	public String form(@Valid Contato contato, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Ocorreu um erro.");
			return "redirect:/cadastrarContato";
		}
		er.save(contato);
		attributes.addFlashAttribute("message", "Usuário cadastrado com sucesso.");
		return "redirect:/contatos";
	}

	@RequestMapping("/contatos")
	public ModelAndView listaContatos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Contato> contatos = er.findAll();
		mv.addObject("contatos", contatos);

		return mv;

	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView detalhesCliente(@PathVariable("id") long id) {
		Contato user = er.findById(id);
		ModelAndView mv = new ModelAndView("contato/detalhesCliente");
		mv.addObject("contatos", user);
		
		Iterable<Produto> produtos = cr.findByContato(user);
		mv.addObject("produtos", produtos);
		
		return mv;
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String detalhesClientePost(@PathVariable("id") long id, @Valid Produto produtos, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addAttribute("mensagem", "Valor Inválido");// Validar a exibição da mensagem que não esta sendo exibida em tela
			return "redirect:/{id}";
		}
		Contato contato = er.findById(id);
		produtos.setContato(contato);
		cr.save(produtos);
		attributes.addAttribute("mensagem", "Produto adicionado com sucesso");
		return "redirect:/{id}";
		
	}
}
