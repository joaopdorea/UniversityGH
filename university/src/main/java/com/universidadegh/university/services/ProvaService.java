package com.universidadegh.university.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidadegh.university.entities.Prova;
import com.universidadegh.university.repositories.ProvaRepository;

@Service
public class ProvaService {
	
	@Autowired
	private ProvaRepository repository;
	
	public List<Prova> findAll(){
		return repository.findAll();
	}
	
	public Prova findById(Long id) {
		Optional<Prova> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
