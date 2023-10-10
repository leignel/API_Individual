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
	
	public List<Editora> listarEditoras(){
		return EditoraRepo.findAll();
	}
	
	public Editora buscarEditoraPorId(Integer id) {
		return EditoraRepo.findById(id).orElse(null);
	}
	
	public Editora salvarEditora(Editora editora) {
		return EditoraRepo.save(editora);
	}
	
	public Editora atualizarEditora(Editora editora) {
		return EditoraRepo.save(editora);
	}
	
	public void deletarEditora(Editora editora) {
		 EditoraRepo.delete(editora);
	}
}
