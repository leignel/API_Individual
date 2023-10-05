package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.repositories.EditoraRepository;


@Service
public class EditoraService {
	@Autowired  
	EditoraRepository EditoraRepo;
	
	public List<Editora> listarEditora(){
		return EditoraRepo.findAll();
	}
	
	public Editora buscarAlunoPorId(Integer id) {
		return EditoraRepo.findById(id).get();
	}
	
	public Editora salvarAluno(Editora editora) {
		return EditoraRepo.save(editora);
	}
	
	public Editora atualizarAluno(Editora editora) {
		return EditoraRepo.save(editora);
	}
	
	public void deletarAluno(Editora editora) {
		 EditoraRepo.delete(editora);
	}
}
