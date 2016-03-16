package Interface;

import java.util.Scanner;

import Controller.ControladorTurma;

public class TelaTurma {

	private ControladorTurma controladorTurma;
	private Scanner teclado;
	private int opcao; 
	
	public TelaTurma(ControladorTurma controladorTurma) {
		this.controladorTurma = controladorTurma;
		teclado = new Scanner(System.in);
	}
	
	public void menuTurma() {
	
		do {
		
		imprime ("Digite o código da Turma:");
		int codTurma  = teclado.nextInt();
		
		
		imprime ("Digite o período da turma:");
		String periodo = teclado.next();
		
		
		controladorTurma.cadastraTurma(codTurma, periodo);
		
		
		imprime ("Deseja cadastra outra turma? 1 para SIM 2 para NÃO");
		int opcao = teclado.nextInt();
		
		if (opcao != 1) {
			controladorTurma.menuPrincipal();
		}
		
		} while (opcao == 1);
		
	}
	
	
	private void imprime(String mensagem) {
		System.out.println(mensagem);
	}
}
