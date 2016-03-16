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
	         imprime("4 - Consulta Revista por título");
	         imprime("5 - Consulta Livro por título");
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
	     		JOptionPane.showMessageDialog(null, "Opção inválida");

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
			imprime ("Digite o código do Livro de sua autoria");
			int codLivro = teclado.nextInt();
			
			controladorPublicacao.cadastraAutor(codLivro, nomeAutor);
			
			imprime ("Deseja cadastrar novo autor? 1 para SIM, 2 para NÃO");
			opcao = teclado.nextInt();
			
			if (opcao != 1) {
				controladorPublicacao.menuPrincipal();
			}
		} while (opcao == 1);
	}
	
	public void dadosRevista() {
		
		int opcao; 
		
		do {
			imprime ("Digite o código da revista:");
			int codRevista  = teclado.nextInt();
			imprime ("Digite o título da revista:");
			String titulo = teclado.next();
			imprime ("Digite o gênero da revista");
			String genero = teclado.next();
			imprime ("Digite a faixa etária da revista");
			String faixaEtaria = teclado.next();
			
			controladorPublicacao.cadastraRevista(codRevista, titulo, genero, faixaEtaria); 
		
			imprime ("Deseja cadastrar nova revista? 1 para SIM, 2 para NÃO");
			
			opcao = teclado.nextInt();
			
			if (opcao != 1) {
				controladorPublicacao.menuPrincipal();
			}
			
		} while (opcao == 1);
		
	}
	
	public void dadosLivro() {
	
		int opcao;
		
		do {
			imprime ("Digite o código do livro:");
			int codLivro  = teclado.nextInt();
			imprime ("Digite o título do livro:");
			String titulo = teclado.next();
			imprime ("Digite o gênero do livro");
			String genero = teclado.next();
			imprime ("Digite a faixa etária do livro");
			String faixaEtaria = teclado.next();
			imprime ("Digite o nome de um autor");
			String nomeAutor = teclado.next();
		
			controladorPublicacao.cadastraLivro(codLivro, titulo, genero, faixaEtaria, nomeAutor); 	
			
			imprime ("Deseja cadastrar novo livro? 1 para SIM, 2 para NÃO");
			
			opcao = teclado.nextInt();
			
			if (opcao != 1) {
				controladorPublicacao.menuPrincipal();
			}
		
		} while (opcao == 1);

	}

	public void consultaLivroPorTitulo() {
		imprime ("Digite o título do livro:");
		String titulo = teclado.next();
				
		Livro livro = controladorPublicacao.findLivroByTitulo(titulo);
		
		if (livro != null) {
			imprime ("Informações do Livro:");
			imprime ("Título: " + livro.getTitulo());
			imprime ("Gênero: " + livro.getGenero());
			imprime ("Faixa etária recomendada: " + livro.getFaixaEtaria());
			imprime ("Quantidade de exemplares disponíveis: " + livro.getQuantidadeExemplares() + " exemplares livres para empréstimo");
			
			for (Autor autor : livro.getAutores()) {
				imprime ("Autores: "+ autor.getNome());	
			}
		} else {
			imprime ("Livro não encontrado!");
		}
	}

	public void consultaRevistaPorTitulo() {
		imprime ("Digite o título da Revista:");
		String titulo = teclado.next();
		
		Revista revista = controladorPublicacao.findRevistaByTitulo(titulo);
	
		if (revista != null ) {
			imprime ("Informações da Revista:");
			imprime ("Título: " + revista.getTitulo());
			imprime ("Gênero: " + revista.getGenero());
			imprime ("Faixa etária recomendada: " + revista.getFaixaEtaria());
			imprime ("Quantidade de exemplares disponíveis: " + revista.getQuantidadeExemplares() + " exemplares livres para empréstimo");
		} else {
			imprime ("Revista não encontrada!");
		}
		
	}

	public void imprime(String mensagem) {
        System.out.println(mensagem);
    }
}
