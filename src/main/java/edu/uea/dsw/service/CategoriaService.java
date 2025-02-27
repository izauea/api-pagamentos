package edu.uea.dsw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.uea.dsw.api_pagamentos.repository.Categoria_Repository;
import edu.uea.model.Categoria;

@Service
public class CategoriaService {

    private final Categoria_Repository categoriaRepository;

    // Injeção via construtor
    public CategoriaService(Categoria_Repository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorCodigo(Long codigo) {
        return categoriaRepository.findById(codigo);
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Long codigo, Categoria categoria) {
        // Verifica se a categoria existe
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(codigo);
        if (categoriaExistente.isPresent()) {
            // Atualize os atributos necessários
            Categoria catAtualizada = categoriaExistente.get();
            catAtualizada.setNome(categoria.getNome());
            return categoriaRepository.save(catAtualizada);
        } else {
            // Lógica de tratamento para categoria não encontrada
            throw new RuntimeException("Categoria não encontrada!");
        }
    }

    public void deletar(Long codigo) {
        categoriaRepository.deleteById(codigo);
    }
}
