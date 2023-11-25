package com.universidadegh.university.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universidadegh.university.entities.Professor;
import com.universidadegh.university.services.ProfessorService;

@RestController
@RequestMapping(value = "/professors")
public class ProfessorResource {
	
	@Autowired
	private ProfessorService service;
	
	@GetMapping
	public ResponseEntity<List<Professor>> findAll(){
		
		List<Professor> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Professor> findById(@PathVariable Long  id){
		
		Professor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	
}
