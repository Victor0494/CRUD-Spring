package com.crud.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
public class Contato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@NotNull
	private long id;
	
	@NotEmpty
	private String nome;
	
	@NotNull
	private int idade;
	
	@NotEmpty
	private String dataCadastro;
	
	@OneToMany
	private List<Produto> produtos;

	

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


}
