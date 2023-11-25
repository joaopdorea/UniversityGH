package com.universidadegh.university.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidadegh.university.entities.Disciplina;
import com.universidadegh.university.repositories.DisciplinaRepository;


@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;
	
	public List<Disciplina> findAll(){
		return repository.findAll();
	}
	
	public Disciplina findById(Long id) {
		Optional<Disciplina> obj = repository.findById(id);
		return obj.get();
	}
}
