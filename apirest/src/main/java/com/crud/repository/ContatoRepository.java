package com.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.models.Contato;

public interface ContatoRepository extends CrudRepository<Contato, String> {
		Contato findById(long id);
}
