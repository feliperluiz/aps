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
	     		JOptionPane.showMessageDialog(null, "Opção inválida");
		     }
		} while (opcao >0 && opcao<4);
		
	}
	
	private void dadosProfessor() {
	
		do {
			imprime ("Digite o código (matrícula) do Professor:");
			int matriculaProfessor = teclado.nextInt();
			imprime ("Digite o nome do Professor:");
			String nome = teclado.next();
			imprime ("Digite a idade");
			int idade = teclado.nextInt();
			imprime ("Digite o endereço");
			String endereco = teclado.next();
			imprime ("Digite a filiação");
			String filiacao = teclado.next();
			imprime ("Digite o código da turma responsável");
			int codTurma = teclado.nextInt();
			imprime ("Digite o nome da disciplina responsável:");
			String nomeDisciplina = teclado.next();
			imprime ("Digite o código de disciplina responsável:");
			int codDisciplina = teclado.nextInt();
			
			controladorPessoa.cadastroProfessor(matriculaProfessor, nome, idade, endereco, filiacao, nomeDisciplina, codDisciplina, codTurma); 
		
			imprime ("Deseja cadastra outro professor? 1 para SIM 2 para NÃO");
			int opcao = teclado.nextInt();
			
			if (opcao != 1) {
				controladorPessoa.menuPrincipal();
			}
		} while (opcao == 1);
		
	}

	private void dadosAluno() {
	
	do {
		imprime ("Digite o código (matrícula) do Aluno:");
		int matriculaAluno = teclado.nextInt();
		imprime ("Digite o nome do Aluno:");
		String nome = teclado.next();
		imprime ("Digite a idade");
		int idade = teclado.nextInt();
		imprime ("Digite o endereço");
		String endereco = teclado.next();
		imprime ("Digite a filiação");
		String filiacao = teclado.next();
		imprime ("Digite o código da turma do aluno");
		int codigoTurma = teclado.nextInt();
		imprime ("Digite o período que o aluno estuda");
		String periodo = teclado.next();
		
		controladorPessoa.cadastroAluno(matriculaAluno, nome, idade, endereco, filiacao, codigoTurma, periodo); 

		imprime ("Deseja cadastra outro aluno? 1 para SIM e 2 para NÃO");
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
