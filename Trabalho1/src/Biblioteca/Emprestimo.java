package Biblioteca;

import java.util.Date;



public class Emprestimo {
	private Date dataEmprestimo; 
	private Pessoa responsavelEmprestimo; 
	private Exemplar exemplarEmprestado;
	private Devolucao devolucao;

	
	public Emprestimo(Date dataEmprestimo, Pessoa responsavelEmprestimo, Exemplar exemplarEmprestado, Devolucao devolucao) {
		this.dataEmprestimo = dataEmprestimo;
		this.responsavelEmprestimo = responsavelEmprestimo;
		this.exemplarEmprestado = exemplarEmprestado;
		this.devolucao = devolucao;
	}

	
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}


	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}


	public Pessoa getResponsavelEmprestimo() {
		return responsavelEmprestimo;
	}


	public void setResponsavelEmprestimo(Pessoa responsavelEmprestimo) {
		this.responsavelEmprestimo = responsavelEmprestimo;
	}

	public Exemplar getExemplarEmprestado() {
		return exemplarEmprestado;
	}


	public void setExemplarEmprestado(Exemplar exemplarEmprestado) {
		this.exemplarEmprestado = exemplarEmprestado;
	}


	public Devolucao getDevolucao() {
		return devolucao;
	}


	public void setDevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
	}


	public Date getDataDevolucao() {
		return devolucao.getDataDevolucao();
	}
//	public void setDevolucao(String dataDevolucao) {
//		this.devolucao = new Devolucao(dataDevolucao);
//	}
	
}


