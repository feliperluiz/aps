package Interface;

import java.util.Scanner;

import javax.swing.JOptionPane;

import Controller.ControladorExemplar;

public class TelaExemplar {
	
	private ControladorExemplar controladorExemplar;
	private Scanner teclado;
	private int opcao;

	public TelaExemplar(ControladorExemplar controladorExemplar) {
		this.controladorExemplar = controladorExemplar;
		teclado = new Scanner(System.in);
	}
	
	public void menuExemplar() {
		do {
			 imprime("1 - Cadastro Exemplar Revista");
	         imprime("2 - Cadastro Exemplar Livro");
	         imprime("3 - Sair"); 
		         
		     opcao = teclado.nextInt();
		     
		     switch (opcao) {
		     case 1 : dadosExemplarRevista(); break;
		     case 2 : dadosExemplarLivro(); break;
		     case 3 : menuPrincipal(); break;
		     }
		     
		     if (opcao<1 && opcao>3) {
	     		JOptionPane.showMessageDialog(null, "Opção inválida");

		    }

		} while (opcao >0 && opcao<4);
			
	}	
	
	private void dadosExemplarRevista() {
		
		int opcao;
		
		do {
			imprime ("Digite o código da Revista para cadastro de seu Exemplar:");
			int codRevista  = teclado.nextInt();
			
			imprime ("Digite um código para o Exemplar:");
			int codExemplar = teclado.nextInt();
		
			imprime ("Você deseja tornar este exemplar disponível? 1 para SIM, 2 para NÃO");
			opcao = teclado.nextInt();
			
			boolean estaDisponivel = true;
			if (opcao == 1){
				estaDisponivel = true;
			} else {
				estaDisponivel = false;
			}
			
			controladorExemplar.cadastraExemplarRevista(codRevista, codExemplar, estaDisponivel); 	

			imprime ("Você deseja cadastrar novo exemplar de revista? 1 para SIM, 2 para NÃO");
			opcao = teclado.nextInt();
			
			if (opcao != 1) {
				controladorExemplar.menuPrincipal();
			}
			
		} while (opcao == 1);	
}

	private void dadosExemplarLivro() {
		
		int opcao;

		do {
			imprime ("Digite o código do Livro para cadastro de seu Exemplar:");
			int codLivro  = teclado.nextInt();
			
			imprime ("Digite um código para o Exemplar:");
			int codExemplar = teclado.nextInt();
			
			imprime ("Você deseja tornar este exemplar disponível? 1 para SIM, 2 para NÃO");
			opcao = teclado.nextInt();
			
			boolean estaDisponivel = true;
			if (opcao == 1){
				estaDisponivel = true;
			} else {
				estaDisponivel = false;
			}
			
			controladorExemplar.cadastraExemplarLivro(codLivro, codExemplar, estaDisponivel); 	

			
			imprime ("Você deseja cadastrar novo exemplar de livro? 1 para SIM, 2 para NÃO");
			opcao = teclado.nextInt();
			
			if (opcao != 1) {
				controladorExemplar.menuPrincipal();
			}
			
		} while (opcao == 1);
	}

	private void imprime(String mensagem) {
		System.out.println(mensagem);
	}
	
	public void menuPrincipal() {
		controladorExemplar.menuPrincipal();
	}

}
