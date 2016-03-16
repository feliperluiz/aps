package Biblioteca;

public class Aluno extends Pessoa {
	private Turma turma; 
	private int quantidadeExemplares;
	
	public Aluno(int matriculaAluno, String nome, int idade, String endereco, String filiacao, Turma turma) {
		super(matriculaAluno, nome, idade, endereco, filiacao);
		this.turma = turma;
	}
	
	public Turma getTurma() { //pegar turma!
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public int getQuantidadeExemplares() {
		return quantidadeExemplares;
	}

	public void setQuantidadeExemplares(int quantidadeExemplares) {
		this.quantidadeExemplares = quantidadeExemplares;
	}
	
	


	
}
