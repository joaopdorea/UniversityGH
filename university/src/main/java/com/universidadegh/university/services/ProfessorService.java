package com.universidadegh.university.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidadegh.university.entities.Professor;
import com.universidadegh.university.repositories.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;
	
	public List<Professor> findAll(){
		return repository.findAll();
	}
	
	public Professor findById(Long id) {
		Optional<Professor> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
