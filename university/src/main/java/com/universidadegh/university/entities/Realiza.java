package com.universidadegh.university.entities;

import java.io.Serializable;

import com.universidadegh.university.entities.pk.RealizaPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_realiza")
public class Realiza implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private RealizaPK id = new RealizaPK();
	
	private double nota;

	public Realiza(Prova prova, Matricula matricula, double nota) {
		id.setProva(prova);
		id.setMatricula(matricula);
		
		this.nota = nota;
	}

	
	
	
	
	
	public Realiza() {
		
	}




	public Prova getProva() {
		return id.getProva();
	}
	
	public Matricula getMatricula() {
		return id.getMatricula();
	}
	
	public void setProva(Prova prova) {
		id.setProva(prova);
	}
	
	public void setMatricula(Matricula matricula) {
		id.setMatricula(matricula);
	}


	public RealizaPK getId() {
		return id;
	}

	public void setId(RealizaPK id) {
		this.id = id;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
	
	
}
