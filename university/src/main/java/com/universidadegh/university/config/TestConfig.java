package com.universidadegh.university.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.universidadegh.university.entities.Aluno;
import com.universidadegh.university.entities.Disciplina;
import com.universidadegh.university.entities.Matricula;
import com.universidadegh.university.entities.Professor;
import com.universidadegh.university.entities.Prova;
import com.universidadegh.university.entities.Questao;
import com.universidadegh.university.entities.Realiza;
import com.universidadegh.university.entities.Turma;
import com.universidadegh.university.entities.enums.ProvaStatus;
import com.universidadegh.university.entities.enums.TurmaStatus;
import com.universidadegh.university.repositories.AlunoRepository;
import com.universidadegh.university.repositories.DisciplinaRepository;
import com.universidadegh.university.repositories.MatriculaRepository;
import com.universidadegh.university.repositories.ProfessorRepository;
import com.universidadegh.university.repositories.ProvaRepository;
import com.universidadegh.university.repositories.QuestaoRepository;
import com.universidadegh.university.repositories.RealizaRepository;
import com.universidadegh.university.repositories.TurmaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private ProvaRepository provaRepository;
	
	@Autowired
	private RealizaRepository realizaRepository;
	
	@Autowired
	private QuestaoRepository questaoRepository;

	@Override
	public void run(String... args) throws Exception {
		Professor p1 = new Professor(null, "111.111.111-11", "George Hamilton", "Doutor");
		Professor p2 = new Professor(null, "111.111.111-12", "Theresa Cristina", "Doutora");

		
		Disciplina d1 = new Disciplina(null, "ANALISE ORIENTADA A OBJETOS");
		Disciplina d2 = new Disciplina(null, "DESENVOLVIMENTO WEB II");
		
		professorRepository.saveAll(Arrays.asList(p1, p2));
		disciplinaRepository.saveAll(Arrays.asList(d1,d2));
		
		Turma t1 = new Turma(null, "Noite", "TERÇA-FEIRA", TurmaStatus.ABERTA, d1, p1);
		Turma t2 = new Turma(null, "Noite", "QUARTA-FEIRA", TurmaStatus.ABERTA, d2, p2);
		
		Aluno a1 = new Aluno(null, "111.111.111-13", "João Dorea", Instant.parse("1999-01-22T00:00:00Z"));
		Aluno a2 = new Aluno(null, "111.111.111-14", "João Sorrentino", Instant.parse("2003-12-26T00:00:00Z"));
		Aluno a3 = new Aluno(null, "111.111.111-15", "Matthew Araujo", Instant.parse("2002-03-20T00:00:00Z"));
		
		
		turmaRepository.saveAll(Arrays.asList(t1,t2));
		alunoRepository.saveAll(Arrays.asList(a1,a2,a3));
		
		Matricula m1 = new Matricula(a1, t1, "Quinto", Instant.parse("2023-07-31T00:00:00Z"), Instant.parse("2023-12-15T00:00:00Z"));
		Matricula m2 = new Matricula(a2, t1, "Quinto", Instant.parse("2023-07-31T00:00:00Z"), Instant.parse("2023-12-15T00:00:00Z"));

		
		matriculaRepository.saveAll(Arrays.asList(m1,m2));
		
		Prova prov1 = new Prova(null,Instant.parse("2023-10-20T00:00:00Z"), 8, ProvaStatus.EM_ANALISE, t1);
		Prova prov2 = new Prova(null,Instant.parse("2023-10-21T00:00:00Z"), 8, ProvaStatus.CORRIGIDA, t1);
		
		provaRepository.saveAll(Arrays.asList(prov1, prov2));
		
		Realiza realiza1 = new Realiza(prov1, m1, 10.0);
		Realiza realiza2 = new Realiza(prov2, m1, 9.8);
		
		Questao questao1 = new Questao(null, prov1, "CITE AS 4 FASES DO PROCESSO DE ENGENHARIA DE REQUISITOS");
		Questao questao2 = new Questao(null, prov1, "CITE AS 4 ETAPAS DO RUP");
		
		realizaRepository.saveAll(Arrays.asList(realiza1, realiza2));
		
		questaoRepository.saveAll(Arrays.asList(questao1, questao2));
		
		
		
		
	
	}
}
