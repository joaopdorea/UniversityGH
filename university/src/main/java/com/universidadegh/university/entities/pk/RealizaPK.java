package com.universidadegh.university.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.universidadegh.university.entities.Matricula;
import com.universidadegh.university.entities.Prova;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Embeddable
public class RealizaPK implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	@JoinColumn(name = "prova_id")
	private Prova prova;
	
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "matricula_id")
	private Matricula matricula;


	public Prova getProva() {
		return prova;
	}


	public void setProva(Prova prova) {
		this.prova = prova;
	}


	public Matricula getMatricula() {
		return matricula;
	}


	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}


	@Override
	public int hashCode() {
		return Objects.hash(matricula, prova);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RealizaPK other = (RealizaPK) obj;
		return Objects.equals(matricula, other.matricula) && Objects.equals(prova, other.prova);
	}
	
	
}
