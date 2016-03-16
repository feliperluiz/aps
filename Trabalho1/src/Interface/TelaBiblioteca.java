package Interface;

import java.util.Scanner;

import javax.swing.JOptionPane;

import Controller.ControladorBiblioteca;

public class TelaBiblioteca {
	
	private ControladorBiblioteca controladorBiblioteca;
	private Scanner teclado;
    private int opcao;
	
	
	public TelaBiblioteca(ControladorBiblioteca controladorBiblioteca) {
		  this.controladorBiblioteca = controladorBiblioteca; 
	      teclado = new Scanner(System.in);
	}


	public void menuPrincipal() {
		 do {
	            imprime("--------------- SISTEMA BIBLIOTECA ------------- ");
	            imprime("Selecione uma opcao"); 
	            imprime("1 - Opera��es com Livros/Revistas"); //vai chamar o Controlador Publicacao
	            imprime("2 - Opera��es com Exemplares de Livros/Revistas"); //vai chamar o Controlador Exemplar
	            imprime("3 - Opera��es com Alunos/Professores"); //vai chamar o Controlador Pessoa
	            imprime("4 - Realiza��es de Empr�stimos/Devolu��es"); //vai chamar o Controlador Emprestimo
	            imprime("5 - Relat�rio de Alunos Atrasados");
	            imprime("6 - Sair");
	            
	            opcao = teclado.nextInt();

	            switch (opcao) {
	                case 1 : controladorBiblioteca.operacoesPublicacao(); break;
	                case 2 : controladorBiblioteca.operacoesExemplar(); break;
	                case 3 : controladorBiblioteca.operacoesPessoa(); break;
	                case 4 : controladorBiblioteca.operacoesEmprestimo(); break;
	                case 5 : controladorBiblioteca.getControladorEmprestimo().relatorioAlunosAtrasados(); break;
	                case 6 : finalizar(); break;
	            }

	            if (opcao<1 && opcao>6)
	        		JOptionPane.showMessageDialog(null, "Op��o inv�lida");
	        	
		 } 	while (opcao>0 && opcao<7);
	        
	    }
	
	private void finalizar() {
		System.exit(0);
	}


	private void imprime(String mensagem) {
        System.out.println(mensagem);
    }
	
	}

