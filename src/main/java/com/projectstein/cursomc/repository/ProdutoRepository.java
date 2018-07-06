package com.projectstein.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectstein.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
