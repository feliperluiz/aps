package Biblioteca;

import java.util.ArrayList;

public class Turma {
	private int codTurma;
	private String periodo; 
	private Professor professorResponsavel;
	private ArrayList<Aluno> alunos;

	public Turma(int codTurma, String periodo) {
		this.codTurma = codTurma;
		this.periodo = periodo;
		
		alunos = new ArrayList<Aluno>();
	}
	
	public Turma(String periodo) {
		this.periodo = periodo;
	}

	public int getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(int codTurma) {
		this.codTurma = codTurma;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Professor getProfessorResponsavel() {
		return professorResponsavel;
	}

	public void setProfessorResponsavel(Professor professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
	}

	
	
}
