package Interface;

import java.util.Scanner;
import javax.swing.JOptionPane;
import Controller.ControladorEmprestimo;

public class TelaEmprestimo {
	
	private ControladorEmprestimo controladorEmprestimo;
	private Scanner teclado;
	private int opcao;

	public TelaEmprestimo(ControladorEmprestimo controladorEmprestimo) {
		this.controladorEmprestimo = controladorEmprestimo;
	    teclado = new Scanner(System.in);

	}
	
	public void menuEmprestimo() {
		do {
			 imprime("1 - Realiza Empréstimo");
	         imprime("2 - Realiza Devolução");
	         imprime("3 - Sair"); 
		         
		     opcao = teclado.nextInt();
		     
		     switch (opcao) {
		     case 1 : dadosEmprestimo(); break;
		     case 2 : dadosDevolucao(); break;
		     case 3 : menuPrincipal(); break;
		     }
		     
		     if (opcao<1 && opcao>3) {
	     		JOptionPane.showMessageDialog(null, "Opção inválida");

		     }

			} while (opcao >0 && opcao<4);
	}
	
	

	private void dadosEmprestimo() {
		
		do {
			imprime ("Digite 1 para Aluno ou 2 para Professor");
			int opcao = teclado.nextInt();
			
			if (opcao==1) {
				imprime ("Digite o código do aluno:");
				int matriculaAluno  = teclado.nextInt();
				imprime ("Digite a data do empréstimo:");
				String dataEmprestimo = teclado.next();
				imprime ("Digite o código do exemplar desejado para empréstimo:");
				int codExemplar = teclado.nextInt();
				
				controladorEmprestimo.realizaEmprestimoAluno(matriculaAluno, dataEmprestimo, codExemplar); 
	
			} else {
				imprime ("Digite o código do professor:");
				int matriculaProfessor  = teclado.nextInt();
				imprime ("Digite a data do empréstimo:");
				String dataEmprestimo = teclado.next();
				imprime ("Digite o código do exemplar desejado para empréstimo:");
				int codExemplar = teclado.nextInt();
				
				controladorEmprestimo.realizaEmprestimoProfessor(matriculaProfessor, dataEmprestimo, codExemplar);
			}
			
		imprime ("Deseja cadastrar novo empréstimo? 1 para SIM, 2 para NÃO");
		opcao = teclado.nextInt();
		
		if (opcao==2){
			controladorEmprestimo.menuPrincipal();
		}
		
		} while (opcao==1);
	}
	
	private void dadosDevolucao() {
		
		imprime ("Digite 1 para Aluno ou 2 para Professor");
		int opcao = teclado.nextInt();
		
		if (opcao==1) {
			imprime ("Digite o código do aluno ou do professor:");
			int codPessoa  = teclado.nextInt();
			imprime ("Digite a data de devolução");
			String dataEntrega = teclado.next();
			imprime ("Digite o o código do exemplar desejado para devolução:");
			int codExemplar = teclado.nextInt();
		
			controladorEmprestimo.realizaDevolucaoAluno(codPessoa, dataEntrega, codExemplar); 
		
		} else {
			imprime ("Digite o código do professor:");
			int codPessoa  = teclado.nextInt();
			imprime ("Digite a data de devolução");
			String dataEntrega = teclado.next();
			imprime ("Digite o o código do exemplar desejado para devolução:");
			int codExemplar = teclado.nextInt();
		
			controladorEmprestimo.realizaDevolucaoProfessor(codPessoa, dataEntrega, codExemplar); 
		
		}
		
	}

	private void imprime(String mensagem) {
        System.out.println(mensagem);
    }
	
	public void menuPrincipal() {
		controladorEmprestimo.menuPrincipal();
	}
}
