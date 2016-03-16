package Biblioteca;

import java.util.ArrayList;

public class Professor extends Pessoa {
	
	private ArrayList<Disciplina> listaDisciplinas;
	private String periodoAtuacao;
	private int quantidadeExemplares;


	public Professor(int matriculaProfessor, String nome, int idade, String endereco, String filiacao, Disciplina disciplina) {
		super(matriculaProfessor, nome, idade, endereco, filiacao);
		listaDisciplinas = new ArrayList<Disciplina>();
		listaDisciplinas.add(disciplina);
	}
		
	public String getPeriodoAtuacao() {
		return periodoAtuacao;
	}
	public void setPeriodoAtuacao(String periodoAtuacao) {
		this.periodoAtuacao = periodoAtuacao;
	}

	public int getQuantidadeExemplares() {
		return quantidadeExemplares;
	}

	public void setQuantidadeExemplares(int quantidadeExemplares) {
		this.quantidadeExemplares = quantidadeExemplares;
	} 
	
	
	
	
	
	
}
