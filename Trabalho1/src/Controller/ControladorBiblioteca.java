package Controller;

import Interface.TelaBiblioteca;

public class ControladorBiblioteca {
	
	private TelaBiblioteca telaBiblioteca;
	private ControladorPessoa controladorPessoa;
	private ControladorEmprestimo controladorEmprestimo;
	private ControladorPublicacao controladorPublicacao;
	private ControladorExemplar controladorExemplar;
	private ControladorTurma controladorTurma;
	
	public ControladorBiblioteca() {
		telaBiblioteca = new TelaBiblioteca(this);
		controladorPessoa = new ControladorPessoa(this);
		controladorEmprestimo = new ControladorEmprestimo(this);
		controladorPublicacao = new ControladorPublicacao(this);
		controladorExemplar = new ControladorExemplar(this);
		controladorTurma = new ControladorTurma(this);
	}

	public void iniciar() {
        telaBiblioteca.menuPrincipal();
    }

	public void operacoesPessoa() {
		controladorPessoa.menuPessoa(); 
	}
	
	public void operacoesEmprestimo() {
		controladorEmprestimo.menuEmprestimo();
	}
	
	public void operacoesPublicacao() {
		controladorPublicacao.menuPublicacao();
	}
	
	public void operacoesExemplar() {
		controladorExemplar.menuExemplar();
	}
	
	public ControladorPessoa getControladorPessoa() {
		return controladorPessoa;
	}

	public ControladorEmprestimo getControladorEmprestimo() {
		return controladorEmprestimo;
	}

	public ControladorPublicacao getControladorPublicacao() {
		return controladorPublicacao;
	}

	public ControladorExemplar getControladorExemplar() {
		return controladorExemplar;
	}

	public ControladorTurma getControladorTurma() {
		return controladorTurma;
	}
}
