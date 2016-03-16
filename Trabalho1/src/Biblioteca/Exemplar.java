package Biblioteca;

public class Exemplar {
	
	private int codigoPublicacao;
	private int codigoExemplar;
	private boolean estaDisponivel;
	private boolean estaAtrasado;

	public Exemplar (int codigoPublicacao, int codigoExemplar, boolean estaDisponivel) {
		this.codigoPublicacao = codigoPublicacao;
		this.codigoExemplar = codigoExemplar;
		this.estaDisponivel = estaDisponivel;
	}

	public int getCodigoPublicacao() {
		return codigoPublicacao;
	}

	public void setCodigoPublicacao(int codigo) {
		this.codigoPublicacao = codigo;
	}

	public int getCodigoExemplar() {
		return codigoExemplar;
	}

	public void setCodigoExemplar(int codigoExemplar) {
		this.codigoExemplar = codigoExemplar;
	}

	public boolean estaDisponivel() {
		return estaDisponivel;
	}

	public void setEstaDisponivel(boolean estaDisponivel) {
		this.estaDisponivel = estaDisponivel;
	}

	public boolean estaAtrasado() {
		return estaAtrasado;
	}

	public void estaAtrasado(boolean estaAtrasado) {
		this.estaAtrasado = estaAtrasado;
	}
	
	
	
	
}
