package Controller;

import java.util.ArrayList;

import Biblioteca.Autor;
import Biblioteca.Livro;
import Biblioteca.Publicacao;
import Biblioteca.Revista;
import Interface.TelaPublicacao;

public class ControladorPublicacao {
	
	private TelaPublicacao telaPublicacao;
	private ControladorBiblioteca controladorBiblioteca;
	private ArrayList<Revista> revistas;
	private ArrayList<Livro> livros;
	private ArrayList<Autor> autores;
	
	public ControladorPublicacao(ControladorBiblioteca controladorBiblioteca) {
		this.controladorBiblioteca = controladorBiblioteca;
		revistas = new ArrayList<Revista>();
		livros = new ArrayList<Livro>();
		autores = new ArrayList<Autor>();
	}

	public void menuPublicacao() {
		telaPublicacao = new TelaPublicacao(this);
		telaPublicacao.menuPublicacao();
		
	}

	public void cadastraRevista(int codRevista, String titulo, String genero, String faixaEtaria) {
		
		boolean revistaExistente = hasPublicacaoByCodPublicacao(codRevista);
		
		if (!revistaExistente) {
			Revista revista = new Revista(codRevista, titulo, genero, faixaEtaria);
			revistas.add(revista);
		} else {
			System.out.println("Publicação já existente!");
		}
	}

	public void cadastraLivro(int codLivro, String titulo, String genero, String faixaEtaria, String nomeAutor) {
		
		boolean livroExistente = hasPublicacaoByCodPublicacao(codLivro);
		
		if (!livroExistente) {
			Livro livro = new Livro(codLivro, titulo, genero, faixaEtaria);	

			Autor autor = new Autor(nomeAutor);
			livro.adicionaAutores(autor);
			
			autores.add(autor);
			livros.add(livro);
		} else {
			System.out.println("Publicação já existente!");
		}
	}
	
	public void cadastraAutor(int codLivro, String nomeAutor) {
		Livro livro = findLivroByCodLivro(codLivro);
		
		if (livro != null && nomeAutor != null) {
			Autor autor = new Autor(nomeAutor);
			livro.adicionaAutores(autor);
			autores.add(autor);
		} else {
			System.out.println("Livro não encontrado ou nome do autor inválido.");
		}
		

	}
	
	//métodos de buscas
	
	public Revista findRevistaByCodRevista(Integer codPublicacao) {
		Revista revistaEncontrada = null;
		for (Revista umaRevista : revistas) {
			if (umaRevista.getCodigo()==codPublicacao) {
				revistaEncontrada = umaRevista;
			}
		}
	return revistaEncontrada;	
	}
	
	public Livro findLivroByCodLivro(Integer codPublicacao) {
		Livro livroEncontrado = null;
		for (Livro umLivro : livros) {
			if (umLivro.getCodigo()==codPublicacao) {
				livroEncontrado = umLivro;
			}
		}
	return livroEncontrado;	
	}
	
	public Publicacao findPublicacaoByCodPublicacao(Integer codPublicacao) {
		for (Livro umLivro : livros) {
			if (codPublicacao != null && umLivro.getCodigo() == codPublicacao) {
				return umLivro;
			}
		}
		
		for (Revista umaRevista : revistas) {
			if (codPublicacao != null && umaRevista.getCodigo() == codPublicacao) {
				return umaRevista;
			}
		}
			
	return null;
	}
	
	public boolean hasLivroByCodLivro(int codLivro) {
		Livro umLivro = findLivroByCodLivro(codLivro);
		if (umLivro != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasRevistaByCodRevista(int codRevista) {
		Revista umaRevista = findRevistaByCodRevista(codRevista);
		if (umaRevista != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasPublicacaoByCodPublicacao(int codPublicacao) {
		Publicacao umaPublicacao = findPublicacaoByCodPublicacao(codPublicacao);
		if (umaPublicacao != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Livro findLivroByTitulo(String titulo) {
		Livro livroEncontrado = null;
		for (Livro umLivro : livros) {
			if (umLivro.getTitulo().equals(titulo)) {
				livroEncontrado = umLivro;
			}
		}
	return livroEncontrado;	
	}
	
	
		
	public Revista findRevistaByTitulo(String titulo) {
		Revista revistaEncontrada = null;
		for (Revista umaRevista : revistas) {
			if (umaRevista.getTitulo().equals(titulo)) {
				revistaEncontrada = umaRevista;
			}
		}
	return revistaEncontrada;	
	}
	
	public void menuPrincipal() {
		controladorBiblioteca.iniciar();
	}
		
}
