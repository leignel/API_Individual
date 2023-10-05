package com.residencia.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.biblioteca.entities.Aluno;

//No Parâmetro, é preciso colocar o nome da entidade ao qual o repositório se refere e depois o tipo de dado ao qual declaramos a chave primária
public interface AlunoRepository extends JpaRepository <Aluno, Integer> {

}
