package Interface;

import java.util.Scanner;

import javax.swing.JOptionPane;

import Controller.ControladorPessoa;

public class TelaPessoa {
	
	private ControladorPessoa controladorPessoa;
    private int opcao;
	private Scanner teclado;

    
	public TelaPessoa(ControladorPessoa controladorPessoa) {
		this.controladorPessoa = controladorPessoa;
	    teclado = new Scanner(System.in);

	}

	public void menuPessoa() {
		
		do {
			 imprime("1 - Cadastro Aluno");
	         imprime("2 - Cadastro Professor");
	         imprime("3 - Sair"); 
		         
		     opcao = teclado.nextInt();
		     
		     switch (opcao) {
		     case 1 : dadosAluno(); break;
		     case 2 : dadosProfessor(); break;
		     case 3 : menuPrincipal(); break;
		     }
		     
		     if (opcao<1 && opcao>3) {
	     		JOptionPane.showMessageDialog(null, "Op��o inv�lida");
		     }
		} while (opcao >0 && opcao<4);
		
	}
	
	private void dadosProfessor() {
	
		do {
			imprime ("Digite o c�digo (matr�cula) do Professor:");
			int matriculaProfessor = teclado.nextInt();
			imprime ("Digite o nome do Professor:");
			String nome = teclado.next();
			imprime ("Digite a idade");
			int idade = teclado.nextInt();
			imprime ("Digite o endere�o");
			String endereco = teclado.next();
			imprime ("Digite a filia��o");
			String filiacao = teclado.next();
			imprime ("Digite o c�digo da turma respons�vel");
			int codTurma = teclado.nextInt();
			imprime ("Digite o nome da disciplina respons�vel:");
			String nomeDisciplina = teclado.next();
			imprime ("Digite o c�digo de disciplina respons�vel:");
			int codDisciplina = teclado.nextInt();
			
			controladorPessoa.cadastroProfessor(matriculaProfessor, nome, idade, endereco, filiacao, nomeDisciplina, codDisciplina, codTurma); 
		
			imprime ("Deseja cadastra outro professor? 1 para SIM 2 para N�O");
			int opcao = teclado.nextInt();
			
			if (opcao != 1) {
				controladorPessoa.menuPrincipal();
			}
		} while (opcao == 1);
		
	}

	private void dadosAluno() {
	
	do {
		imprime ("Digite o c�digo (matr�cula) do Aluno:");
		int matriculaAluno = teclado.nextInt();
		imprime ("Digite o nome do Aluno:");
		String nome = teclado.next();
		imprime ("Digite a idade");
		int idade = teclado.nextInt();
		imprime ("Digite o endere�o");
		String endereco = teclado.next();
		imprime ("Digite a filia��o");
		String filiacao = teclado.next();
		imprime ("Digite o c�digo da turma do aluno");
		int codigoTurma = teclado.nextInt();
		imprime ("Digite o per�odo que o aluno estuda");
		String periodo = teclado.next();
		
		controladorPessoa.cadastroAluno(matriculaAluno, nome, idade, endereco, filiacao, codigoTurma, periodo); 

		imprime ("Deseja cadastra outro aluno? 1 para SIM e 2 para N�O");
		int opcao = teclado.nextInt();
		
		if (opcao != 1) {
			controladorPessoa.menuPrincipal();
		}
	} while (opcao == 1);
	
	
	}

	private void imprime(String mensagem) {
        System.out.println(mensagem);
    }

	public void menuPrincipal() {
		controladorPessoa.menuPrincipal();
	}
}
