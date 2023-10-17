package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.dto.AlunoResumidoDTO;
import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {
//CRUD
//recuperar todos os alunos
//recuperar um aluno pela sua chave primária
//salvar um novo aluno
//atualizar um determinado aluno
//deletar um determinado aluno

	@Autowired // essa anotação é para injeção de dependencia, recursos de outro lugar! é
				// parecido com instanciar!
	AlunoRepository alunoRepo;

	public List<Aluno> listarAlunos() {
		return alunoRepo.findAll();
	}

	public Aluno buscarAlunoPorId(Integer id) {
		// return alunoRepo.findById(id).get();
		/*
		 * Optional<Aluno> alunoBanco = alunoRepo.findById(id); Usar esse ou o próximo
		 * return if(alunoBanco.isPresent()) return alunoBanco.get(); else return null;
		 */
		return alunoRepo.findById(id).orElse(null);
	}

	public AlunoResumidoDTO getAlunoResumidoPorId(Integer id) {

		Aluno aluno = alunoRepo.findById(id).orElse(null);

		if (aluno != null) {
			AlunoResumidoDTO alunoResDTO = new AlunoResumidoDTO(aluno.getNumeroMatriculaAluno(), aluno.getNome(),
					aluno.getCpf());
			
//			alunoResDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
//			alunoResDTO.setNome(aluno.getNome());
//			alunoResDTO.setCpf(aluno.getCpf());
			return alunoResDTO;
		}
		return null;
	}

	public List<AlunoResumidoDTO> listarAlunosResumidos() {
		List<Aluno> alunos = alunoRepo.findAll();
		List<AlunoResumidoDTO> alunosDTO = new ArrayList<>();

		for (Aluno aluno : alunos) {
			AlunoResumidoDTO alunoResDTO = new AlunoResumidoDTO();
			alunoResDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
			alunoResDTO.setNome(aluno.getNome());
			alunoResDTO.setCpf(aluno.getCpf());
			alunosDTO.add(alunoResDTO);
		}

		return alunosDTO;
	}

	public Aluno salvarAluno(Aluno aluno) {
		return alunoRepo.save(aluno);
	}

	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRepo.save(aluno);
	}

	public Boolean deletarAluno(Aluno aluno) {
		if (aluno == null) {
			return false;
		}
		Aluno alunoExistente = buscarAlunoPorId(aluno.getNumeroMatriculaAluno());

		if (alunoExistente == null) {
			return false;
		}

		alunoRepo.delete(aluno);

		Aluno alunoContinuaExistindo = buscarAlunoPorId(aluno.getNumeroMatriculaAluno());

		if (alunoContinuaExistindo == null) {
			return true;
		}

		return false;

	}
}
