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

	public List<Livro> listarLivros() {
		return LivroRepo.findAll();
	}

	public Livro buscarLivroPorId(Integer id) {
		return LivroRepo.findById(id).orElse(null);
	}

	public Livro salvarLivro(Livro livro) {
		return LivroRepo.save(livro);
	}

	public Livro atualizarLivro(Livro livro) {
		return LivroRepo.save(livro);
	}

	public Boolean deletarLivro(Livro livro) {
		if (livro == null) {
			return false;
		}
		Livro livroExistente = buscarLivroPorId(livro.getCodigoLivro());

		if (livroExistente == null) {
			return false;
		}

		LivroRepo.delete(livro);

		Livro livroContinuaExistindo = buscarLivroPorId(livro.getCodigoLivro());

		if (livroContinuaExistindo == null) {
			return true;
		}

		return false;
	}
}
