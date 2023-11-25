package com.universidadegh.university.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_professor")
public class Professor implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_professor;
	
	private String CPF;
	private String nome_professor;
	private String especialidade;
	
	@JsonIgnore
	@OneToMany(mappedBy = "professor")
	private List<Turma> turmas = new ArrayList<>();
	
	
	
	public Professor(Long id_professor, String CPF, String nome_professor, String especialidade) {
		this.id_professor = id_professor;
		this.CPF = CPF;
		this.nome_professor = nome_professor;
		this.especialidade = especialidade;
	}



	public Professor() {
	}



	public Long getId_professor() {
		return id_professor;
	}



	public void setId_professor(Long id_professor) {
		this.id_professor = id_professor;
	}



	public String getNome_professor() {
		return nome_professor;
	}



	public List<Turma> getTurmas() {
		return turmas;
	}



	public void setNome_professor(String nome_professor) {
		this.nome_professor = nome_professor;
	}



	public String getEspecialidade() {
		return especialidade;
	}



	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}



	public String getCPF() {
		return CPF;
	}



	@Override
	public String toString() {
		return "Professor [id_professor=" + id_professor + ", CPF=" + CPF + ", nome_professor=" + nome_professor
				+ ", especialidade=" + especialidade + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(CPF, nome_professor);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(CPF, other.CPF) && Objects.equals(nome_professor, other.nome_professor);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
