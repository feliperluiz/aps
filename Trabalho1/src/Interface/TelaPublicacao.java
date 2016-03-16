package Interface;

import java.util.Scanner;

import javax.swing.JOptionPane;

import Biblioteca.Autor;
import Biblioteca.Livro;
import Biblioteca.Revista;
import Controller.ControladorPublicacao;

public class TelaPublicacao {
	
	private ControladorPublicacao controladorPublicacao;
	private Scanner teclado; 
	
	public TelaPublicacao(ControladorPublicacao controladorPublicacao) {
		this.controladorPublicacao = controladorPublicacao;
	    teclado = new Scanner(System.in);
	}
	
	public void menuPublicacao() {
		int opcao; 
		
		do {
			 imprime("1 - Cadastro Revista");
	         imprime("2 - Cadastro Livro");
	         imprime("3 - Cadastro Autor");
	         imprime("4 - Consulta Revista por t�tulo");
	         imprime("5 - Consulta Livro por t�tulo");
	         imprime("6 - Voltar para menu principal"); 
		         
		     opcao = teclado.nextInt();
		     
		     switch (opcao) {
		     case 1 : dadosRevista(); break;
		     case 2 : dadosLivro(); break;
		     case 3 : dadosAutor(); break;
		     case 4 : consultaRevistaPorTitulo(); break;
		     case 5 : consultaLivroPorTitulo(); break;
		     case 6 : menuPrincipal(); break;
		     }
		     
		     if (opcao<1 && opcao>6) {
	     		JOptionPane.showMessageDialog(null, "Op��o inv�lida");

		     }

			} while (opcao >0 && opcao<7);
	}

	public void menuPrincipal() {
		controladorPublicacao.menuPrincipal();
	}

	public void dadosAutor() {

		int opcao; 
		
		do {
			imprime ("Digite o nome do Autor:");
			String nomeAutor = teclado.next();
			imprime ("Digite o c�digo do Livro de sua autoria");
			int codLivro = teclado.nextInt();
			
			controladorPublicacao.cadastraAutor(codLivro, nomeAutor);
			
			imprime ("Deseja cadastrar novo autor? 1 para SIM, 2 para N�O");
			opcao = teclado.nextInt();
			
			if (opcao != 1) {
				controladorPublicacao.menuPrincipal();
			}
		} while (opcao == 1);
	}
	
	public void dadosRevista() {
		
		int opcao; 
		
		do {
			imprime ("Digite o c�digo da revista:");
			int codRevista  = teclado.nextInt();
			imprime ("Digite o t�tulo da revista:");
			String titulo = teclado.next();
			imprime ("Digite o g�nero da revista");
			String genero = teclado.next();
			imprime ("Digite a faixa et�ria da revista");
			String faixaEtaria = teclado.next();
			
			controladorPublicacao.cadastraRevista(codRevista, titulo, genero, faixaEtaria); 
		
			imprime ("Deseja cadastrar nova revista? 1 para SIM, 2 para N�O");
			
			opcao = teclado.nextInt();
			
			if (opcao != 1) {
				controladorPublicacao.menuPrincipal();
			}
			
		} while (opcao == 1);
		
	}
	
	public void dadosLivro() {
	
		int opcao;
		
		do {
			imprime ("Digite o c�digo do livro:");
			int codLivro  = teclado.nextInt();
			imprime ("Digite o t�tulo do livro:");
			String titulo = teclado.next();
			imprime ("Digite o g�nero do livro");
			String genero = teclado.next();
			imprime ("Digite a faixa et�ria do livro");
			String faixaEtaria = teclado.next();
			imprime ("Digite o nome de um autor");
			String nomeAutor = teclado.next();
		
			controladorPublicacao.cadastraLivro(codLivro, titulo, genero, faixaEtaria, nomeAutor); 	
			
			imprime ("Deseja cadastrar novo livro? 1 para SIM, 2 para N�O");
			
			opcao = teclado.nextInt();
			
			if (opcao != 1) {
				controladorPublicacao.menuPrincipal();
			}
		
		} while (opcao == 1);

	}

	public void consultaLivroPorTitulo() {
		imprime ("Digite o t�tulo do livro:");
		String titulo = teclado.next();
				
		Livro livro = controladorPublicacao.findLivroByTitulo(titulo);
		
		if (livro != null) {
			imprime ("Informa��es do Livro:");
			imprime ("T�tulo: " + livro.getTitulo());
			imprime ("G�nero: " + livro.getGenero());
			imprime ("Faixa et�ria recomendada: " + livro.getFaixaEtaria());
			imprime ("Quantidade de exemplares dispon�veis: " + livro.getQuantidadeExemplares() + " exemplares livres para empr�stimo");
			
			for (Autor autor : livro.getAutores()) {
				imprime ("Autores: "+ autor.getNome());	
			}
		} else {
			imprime ("Livro n�o encontrado!");
		}
	}

	public void consultaRevistaPorTitulo() {
		imprime ("Digite o t�tulo da Revista:");
		String titulo = teclado.next();
		
		Revista revista = controladorPublicacao.findRevistaByTitulo(titulo);
	
		if (revista != null ) {
			imprime ("Informa��es da Revista:");
			imprime ("T�tulo: " + revista.getTitulo());
			imprime ("G�nero: " + revista.getGenero());
			imprime ("Faixa et�ria recomendada: " + revista.getFaixaEtaria());
			imprime ("Quantidade de exemplares dispon�veis: " + revista.getQuantidadeExemplares() + " exemplares livres para empr�stimo");
		} else {
			imprime ("Revista n�o encontrada!");
		}
		
	}

	public void imprime(String mensagem) {
        System.out.println(mensagem);
    }
}
