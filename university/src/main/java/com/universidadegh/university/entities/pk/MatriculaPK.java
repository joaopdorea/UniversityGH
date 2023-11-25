package com.universidadegh.university.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.universidadegh.university.entities.Aluno;
import com.universidadegh.university.entities.Turma;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class MatriculaPK implements Serializable {



	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
	
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	@Override
	public int hashCode() {
		return Objects.hash(aluno, turma);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaPK other = (MatriculaPK) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(turma, other.turma);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
