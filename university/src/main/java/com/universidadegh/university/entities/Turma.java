package com.universidadegh.university.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.universidadegh.university.entities.enums.TurmaStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_turma")
public class Turma implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String turno;
	
	private String dia_semana;
	
	private TurmaStatus situacao;

	@ManyToOne
	@JoinColumn(name="disciplina_id")
	private Disciplina disciplina;
	
	
	@ManyToOne
	@JoinColumn(name="professor_id")
	private Professor professor;
	
	
	@OneToMany(mappedBy = "id.turma")
	private Set<Matricula> matriculas = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "turma")
	private List<Prova> provas = new ArrayList<>();

	public Turma(Long id, String turno, String dia_semana, TurmaStatus situacao, Disciplina disciplina,
			Professor professor) {
		this.id = id;
		this.turno = turno;
		this.dia_semana = dia_semana;
		this.situacao = situacao;
		this.disciplina = disciplina;
		this.professor = professor;
	}

	public Turma() {
		super();
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getDia_semana() {
		return dia_semana;
	}

	public void setDia_semana(String dia_semana) {
		this.dia_semana = dia_semana;
	}

	public TurmaStatus getSituacao() {
		return situacao;
	}

	public void setSituacao(TurmaStatus situacao) {
		this.situacao = situacao;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Long getId() {
		return id;
	}

	
	
	@JsonIgnore
	public Set<Aluno> getAlunos() {
		Set<Aluno> set = new HashSet<>();
		for (Matricula x : matriculas) {
			set.add(x.getAluno());
		}
		return set;
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
		Turma other = (Turma) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Turma [cod_turma=" + id + ", turno=" + turno + ", dia_semana=" + dia_semana + ", situacao="
				+ situacao + ", disciplina=" + disciplina + ", professor=" + professor + "]";
	}
	
	public void alteraStatusTurma(TurmaStatus status) {
		this.setSituacao(status);
	}
	
	
	
	
	
	
}
