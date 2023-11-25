package com.universidadegh.university.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidadegh.university.entities.Turma;
import com.universidadegh.university.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	public List<Turma> findAll(){
		return repository.findAll();
	}
	
	public Turma findById(Long id) {
		Optional<Turma> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
