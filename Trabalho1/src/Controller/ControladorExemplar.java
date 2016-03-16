package Controller;

import java.util.ArrayList;
import Biblioteca.Exemplar;
import Biblioteca.Livro;
import Biblioteca.Revista;
import Interface.TelaExemplar;

public class ControladorExemplar {
	private ControladorBiblioteca controladorBiblioteca;
	private TelaExemplar telaExemplar;
	private ArrayList<Exemplar> exemplaresRevista;
	private ArrayList<Exemplar> exemplaresLivro;

	
	public ControladorExemplar(ControladorBiblioteca controladorBiblioteca) {
		this.controladorBiblioteca = controladorBiblioteca;
		exemplaresLivro = new ArrayList<Exemplar>();
		exemplaresRevista = new ArrayList<Exemplar>();
	}
	
	public void menuExemplar() {
		telaExemplar = new TelaExemplar(this);
		telaExemplar.menuExemplar();
	}
	
	public void cadastraExemplarRevista(int codRevista, int codExemplar, boolean estaDisponivel) {
		Revista revista = controladorBiblioteca.getControladorPublicacao().findRevistaByCodRevista(codRevista);
		
		//verifica se o exemplar não existe e se a revista já existe
		if(findExemplarByCodExemplar(codExemplar) == null && revista != null) {
			Exemplar exemplar = new Exemplar(codRevista, codExemplar, estaDisponivel);
			int quantidadeExemplares = revista.getQuantidadeExemplares();
			revista.setQuantidadeExemplares(quantidadeExemplares++);
			exemplaresRevista.add(exemplar);
		} else {
			System.out.println("Exemplar de revista já cadastrado ou revista não encontrada.");
		}
		
	}

	public void cadastraExemplarLivro(int codLivro, int codExemplar, boolean estaDisponivel) {
		Livro livro = controladorBiblioteca.getControladorPublicacao().findLivroByCodLivro(codLivro);

		//verifica se o exemplar não existe e se o livro já existe
		if(findExemplarByCodExemplar(codExemplar) == null && livro != null) {
			Exemplar exemplar = new Exemplar(codLivro, codExemplar, estaDisponivel);
			int quantidadeExemplares = livro.getQuantidadeExemplares();
			livro.setQuantidadeExemplares(quantidadeExemplares++);
			exemplaresLivro.add(exemplar);
		} else {
			System.out.println("Exemplar de livro já cadastrado ou livro não encontrado.");
		}
	}

	public Exemplar findExemplarByCodExemplar(Integer codExemplar) {
		
		//busca objeto exemplar pelo codigo do exemplar
		Exemplar exemplarEncontrado = null;
		for (Exemplar umExemplar : exemplaresRevista) {
			if (umExemplar.getCodigoExemplar()==codExemplar) {
				exemplarEncontrado = umExemplar;
			}
		}
		
		for (Exemplar umExemplar : exemplaresLivro) {
			if (umExemplar.getCodigoExemplar()==codExemplar) {
				exemplarEncontrado = umExemplar;
			}
		}
		
		return exemplarEncontrado;
	}
	
	public boolean verificaDisponibilidade(Integer codExemplar, Integer codPessoa) {
		
		//verificando se o exemplar da revista existe e se está disponivel para emprestimo
		boolean disponivel = false;
		for (Exemplar umExemplar : exemplaresRevista) {
			if (umExemplar.getCodigoExemplar() == codExemplar && umExemplar.estaDisponivel()) {
				disponivel = true;
			} else {
				disponivel = false;
				return disponivel;
			}
		}
		
		//verificando se o exemplar do livro existe e se está disponivel para emprestimo
		for (Exemplar umExemplar : exemplaresLivro) {
			if (umExemplar.getCodigoExemplar() == codExemplar && umExemplar.estaDisponivel()) { 
					disponivel = true;
			} else {
					disponivel = false;
					return disponivel;
			}
		}
		
		//verifica se o aluno ou o professor tem no máximo 2 ou 4 exemplares ja adquiridos para emprestimo
		if ((controladorBiblioteca.getControladorPessoa().findAlunoByCodAluno(codPessoa).getQuantidadeExemplares() < 3) || 
				(controladorBiblioteca.getControladorPessoa().findProfessorByCodProfessor(codPessoa).getQuantidadeExemplares() < 5)) {
			disponivel = true;
		} else {
			disponivel = false;
			System.out.println("Você deve devolver um exemplar para poder efetuar um empréstimo!");
			return disponivel;
		}

		//verifica se a Pessoa do codPessoa já tem um Empréstimo de um Exemplar da mesma Publicacao!
		if (!controladorBiblioteca.getControladorEmprestimo().verificaEmprestados(codExemplar, codPessoa)) {
			disponivel = true;
		} else {
			disponivel = false;
			System.out.println("Já existe um exemplar desta publicação emprestado para a mesma pessoa!");
			return disponivel;
		}
		
		return disponivel;
		
   }

	
	public void menuPrincipal() {
		controladorBiblioteca.iniciar();
	}
	
}