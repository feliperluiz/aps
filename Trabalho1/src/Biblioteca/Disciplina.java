package Biblioteca;

public class Disciplina {
	private String nomeDisciplina;
	private int codDisciplina;
	
	public Disciplina(String nomeDisciplina, int codDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.codDisciplina = codDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	
	
}
