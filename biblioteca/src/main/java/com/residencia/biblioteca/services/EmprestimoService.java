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
	
	public List<Emprestimo> listarEmprestimo(){
		return EmprestimoRepo.findAll();
	}
	
	public Emprestimo buscarAlunoPorId(Integer id) {
		return EmprestimoRepo.findById(id).get();
	}
	
	public Emprestimo salvarAluno(Emprestimo emprestimo) {
		return EmprestimoRepo.save(emprestimo);
	}
	
	public Emprestimo atualizarAluno(Emprestimo emprestimo) {
		return EmprestimoRepo.save(emprestimo);
	}
	
	public void deletarAluno(Emprestimo emprestimo) {
		 EmprestimoRepo.delete(emprestimo);
	}
}
