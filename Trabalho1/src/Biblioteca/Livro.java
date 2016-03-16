package Biblioteca;

import java.util.ArrayList;

public class Livro extends Publicacao {
	
	private ArrayList<Autor> autores;
	private int quantidadeExemplares; 
	
	public Livro(int codigoLivro, String titulo, String genero, String faixaEtaria) {
		super (titulo, genero, faixaEtaria, true, codigoLivro);
		autores = new ArrayList<Autor>();
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void adicionaAutores(Autor umAutor) {
		this.autores.add(umAutor);
	}

	public int getQuantidadeExemplares() {
		return quantidadeExemplares;
	}

	public void setQuantidadeExemplares(int quantidadeExemplares) {
		this.quantidadeExemplares = quantidadeExemplares;
	}

	
}
