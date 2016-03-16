package Biblioteca;

public class Revista extends Publicacao {
	private String editora; 
	private int quantidadeExemplares; 
	
	public Revista(int codigoRevista, String titulo, String genero, String faixaEtaria) {
		super(titulo, genero, faixaEtaria, false, codigoRevista);
	
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getQuantidadeExemplares() {
		return quantidadeExemplares;
	}

	public void setQuantidadeExemplares(int quantidadeExemplares) {
		this.quantidadeExemplares = quantidadeExemplares;
	}
	
	

}

