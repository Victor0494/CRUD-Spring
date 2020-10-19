package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.models.Contato;
import com.crud.models.Produto;
import com.crud.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository cr;
	
	@RequestMapping("/deletarProduto")
	public String deletarProduto(int codigo) {
		Produto produto = cr.findByCodigo(codigo);
		cr.delete(produto);
		
		Contato contato = produto.getContato();
		String cpfCliente = contato.getCpf();
		
	
		return "redirect:/" + cpfCliente;
	}
}
