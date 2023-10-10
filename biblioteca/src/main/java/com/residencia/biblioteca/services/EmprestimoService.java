package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {
	@Autowired  
	EmprestimoRepository EmprestimoRepo;
	
	public List<Emprestimo> listarEmprestimos(){
		return EmprestimoRepo.findAll();
	}
	
	public Emprestimo buscarEmprestimoPorId(Integer id) {
		return EmprestimoRepo.findById(id).orElse(null);
	}
	
	public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {
		return EmprestimoRepo.save(emprestimo);
	}
	
	public Emprestimo atualizarEmprestimo(Emprestimo emprestimo) {
		return EmprestimoRepo.save(emprestimo);
	}
	
	public void deletarEmprestimo(Emprestimo emprestimo) {
		 EmprestimoRepo.delete(emprestimo);
	}
}
