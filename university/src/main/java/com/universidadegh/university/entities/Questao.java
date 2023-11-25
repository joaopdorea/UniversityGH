package com.universidadegh.university.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_questao")
public class Questao implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="prova_id")
	private Prova prova;
	
	private String enunciado;

	public Questao(Long id, Prova prova, String enunciado) {
		this.id = id;
		this.prova = prova;
		this.enunciado = enunciado;
	}

	public Questao() {
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
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
		Questao other = (Questao) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Questao [id=" + id + ", prova=" + prova + ", enunciado=" + enunciado + "]";
	}
	
	
	
	
	
	
	
}
