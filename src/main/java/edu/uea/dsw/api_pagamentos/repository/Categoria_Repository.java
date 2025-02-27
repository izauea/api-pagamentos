package edu.uea.dsw.api_pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uea.model.Categoria;

@Repository
public interface Categoria_Repository extends JpaRepository<Categoria, Long>{

}

