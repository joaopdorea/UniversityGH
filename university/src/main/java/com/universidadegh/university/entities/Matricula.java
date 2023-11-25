package com.universidadegh.university.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.universidadegh.university.entities.pk.MatriculaPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="tb_matricula")
public class Matricula implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MatriculaPK id = new MatriculaPK();
	
	private String periodo;
	private Instant data_inicio;
	private Instant data_fim;
	
	
	
	
	@OneToMany(mappedBy = "id.matricula")
	private Set<Realiza> realizacoes = new HashSet<>();
	
	

	public Matricula(Aluno aluno, Turma turma, String periodo, Instant data_inicio, Instant data_fim) {
		id.setAluno(aluno);
		id.setTurma(turma);
		
		this.periodo = periodo;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
	}


	public Matricula() {
		
	}
	
	
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public Turma getTurma() {
		return id.getTurma();
	}
	
	
	public Set<Prova> getProvas() {
		Set<Prova> set = new HashSet<>();
		for (Realiza x : realizacoes) {
			set.add(x.getProva());
		}
		return set;
	}
	
	
	public void setAluno(Aluno aluno) {
		id.setAluno(aluno);
	}
	
	public void setTurma(Turma turma) {
		id.setTurma(turma);
	}


	public MatriculaPK getId() {
		return id;
	}


	public void setId(MatriculaPK id) {
		this.id = id;
	}


	public String getPeriodo() {
		return periodo;
	}


	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}


	public Instant getData_inicio() {
		return data_inicio;
	}


	public void setData_inicio(Instant data_inicio) {
		this.data_inicio = data_inicio;
	}


	public Instant getData_fim() {
		return data_fim;
	}


	public void setData_fim(Instant data_fim) {
		this.data_fim = data_fim;
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
		Matricula other = (Matricula) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
}
