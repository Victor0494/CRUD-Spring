package com.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String> {

}
