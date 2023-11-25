package com.universidadegh.university.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidadegh.university.entities.Aluno;
import com.universidadegh.university.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> findAll(){
		return repository.findAll();
	}
	
	public Aluno findById(Long id) {
		Optional<Aluno> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
