package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {
	@Autowired  
	LivroRepository LivroRepo;
	
	public List<Livro> listarLivro(){
		return LivroRepo.findAll();
	}
	
	public Livro buscarAlunoPorId(Integer id) {
		return LivroRepo.findById(id).get();
	}
	
	public Livro salvarAluno(Livro livro) {
		return LivroRepo.save(livro);
	}
	
	public Livro atualizarAluno(Livro livro) {
		return LivroRepo.save(livro);
	}
	
	public void deletarAluno(Livro livro) {
		 LivroRepo.delete(livro);
	}
}
