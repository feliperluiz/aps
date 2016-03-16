package Controller;

import java.util.ArrayList;

import Biblioteca.Turma;
import Interface.TelaTurma;

public class ControladorTurma {
	
	private TelaTurma telaTurma;
	private ControladorBiblioteca controladorBiblioteca;
	private ArrayList<Turma> turmas;
	
	public ControladorTurma(ControladorBiblioteca controladorBiblioteca) {
		this.controladorBiblioteca = controladorBiblioteca;
		turmas = new ArrayList<Turma>();

	}
	
	public void menuTurma() {
		telaTurma = new TelaTurma(this);
		telaTurma.menuTurma();
		
		
	}
	
	public void cadastraTurma(Integer codTurma, String periodo) {
		
		if (codTurma != null && findTurmaByCodTurma(codTurma) == null) {
			Turma turma = new Turma(codTurma, periodo);
			turmas.add(turma);
		} else {
			System.out.println("Código inválido ou turma já existente");
		}
		
	}

	public Turma findTurmaByCodTurma(int codTurma) {
		Turma turmaEncontrada = null;
		
		for (Turma umaTurma : turmas) {
			if (umaTurma.getCodTurma() == codTurma) {
				turmaEncontrada = umaTurma;
			}
		}
		
		return turmaEncontrada;
	}

	public void menuPrincipal() {
		controladorBiblioteca.iniciar();
	}
}
