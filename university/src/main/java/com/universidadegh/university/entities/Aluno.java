package com.universidadegh.university.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String CPF;
	
	private String nome_aluno;
	
	private Instant data_nasc;
	
	@OneToMany(mappedBy = "id.aluno")
	private Set<Matricula> matriculas = new HashSet<>();

	public Aluno(Long id, String CPF, String nome_aluno, Instant data_nasc) {
		this.id = id;
		this.CPF = CPF;
		this.nome_aluno = nome_aluno;
		this.data_nasc = data_nasc;
	}

	public Aluno() {
	}

	public String getCPF() {
		return this.CPF;
	}

	public void setCPF(String cpf) {
		this.CPF = cpf;
	}

	public String getNome_aluno() {
		return nome_aluno;
	}

	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}

	public Instant getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Instant data_nasc) {
		this.data_nasc = data_nasc;
	}

	public Set<Turma> getTurmas() {
		Set<Turma> set = new HashSet<>();
		for (Matricula x : matriculas) {
			set.add(x.getTurma());
		}
		return set;
	}


	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Aluno [cod_aluno=" + id + ", CPF=" + CPF + ", nome_aluno=" + nome_aluno + ", data_nasc="
				+ data_nasc + ", turmas=" + matriculas + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
