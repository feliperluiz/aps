package Biblioteca;

import java.util.Date;


public class Devolucao {
	
	private Date dataDevolucao; 
	private Pessoa responsavelDevolucao; 
	private Exemplar exemplarDevolvido; 
	
	public Devolucao(Date dataDevolucao, Pessoa responsavelDevolucao, Exemplar exemplarDevolvido) {
		this.dataDevolucao = dataDevolucao;
		this.responsavelDevolucao = responsavelDevolucao;
		this.exemplarDevolvido = exemplarDevolvido;
	}
	
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Pessoa getResponsavelDevolucao() {
		return responsavelDevolucao;
	}

	public void setResponsavelDevolucao(Pessoa responsavelDevolucao) {
		this.responsavelDevolucao = responsavelDevolucao;
	}

	public Exemplar getExemplarDevolvido() {
		return exemplarDevolvido;
	}

	public void setExemplarDevolvido(Exemplar exemplarDevolvido) {
		this.exemplarDevolvido = exemplarDevolvido;
	}
	
	
}

