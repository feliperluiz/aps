package Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import Biblioteca.Aluno;
import Biblioteca.Devolucao;
import Biblioteca.Emprestimo;
import Biblioteca.Exemplar;
import Biblioteca.Pessoa;
import Biblioteca.Professor;
import Interface.TelaEmprestimo;

public class ControladorEmprestimo {
	
	private ControladorBiblioteca controladorBiblioteca;
	private TelaEmprestimo telaEmprestimo;
	private ArrayList<Emprestimo> listaEmprestimos;
	private ArrayList<Devolucao> listaDevolucoes;
	private ArrayList<Devolucao> listaDevolucoesAtrasadas;

	
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	Date dtEmprestimo, dtEntrega;
	
	public ControladorEmprestimo(ControladorBiblioteca controladorBiblioteca) {
		this.controladorBiblioteca = controladorBiblioteca;
		listaEmprestimos = new ArrayList<Emprestimo>();
		listaDevolucoes = new ArrayList<Devolucao>();
		listaDevolucoesAtrasadas = new ArrayList<Devolucao>();
	}

	public void menuEmprestimo() {
		telaEmprestimo = new TelaEmprestimo(this);
		telaEmprestimo.menuEmprestimo();
	}

	public void realizaEmprestimoAluno(int codPessoa, String dataEmprestimoStr, int codExemplar) {

		Aluno responsavelEmprestimo = controladorBiblioteca.getControladorPessoa().findAlunoByCodAluno(codPessoa);
		Exemplar exemplarEmprestimo = controladorBiblioteca.getControladorExemplar().findExemplarByCodExemplar(codExemplar);
		
		//busca o aluno pelo codigo da pessoa, busca o exemplar pelo codigo do exemplar, verifica se o exemplar está disponivel para emprestimo e se o aluno/professor ja pegou no maximo até 2 ou 4 exemplares para poder pegar o 3º ou 5º respectivamente
		if (responsavelEmprestimo != null && exemplarEmprestimo != null &&
				controladorBiblioteca.getControladorExemplar().verificaDisponibilidade(codExemplar, codPessoa)) {
			
			try {
				dtEmprestimo = df.parse(dataEmprestimoStr);
				Calendar c = Calendar.getInstance();
				Calendar d = Calendar.getInstance();

				c.setTime(dtEmprestimo);
				d.setTime(dtEmprestimo);

				c.add(Calendar.DATE, +7);
				Date dataDevolucao = c.getTime();
				Date dataEmprestimo = d.getTime();

				Devolucao devolucao = new Devolucao(dataDevolucao, responsavelEmprestimo, exemplarEmprestimo);
				Emprestimo emprestimo = new Emprestimo(dataEmprestimo, responsavelEmprestimo, exemplarEmprestimo, devolucao);
			
				int qtExemplares = responsavelEmprestimo.getQuantidadeExemplares();
				responsavelEmprestimo.setQuantidadeExemplares(qtExemplares++);
				
				listaEmprestimos.add(emprestimo);
				exemplarEmprestimo.setEstaDisponivel(false);				

			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}

	}
	
	public void realizaEmprestimoProfessor(int codPessoa, String dataEmprestimoStr, int codExemplar) { //realiza empréstimo professor

		Professor responsavelEmprestimo = controladorBiblioteca.getControladorPessoa().findProfessorByCodProfessor(codPessoa);
		Exemplar exemplarEmprestimo = controladorBiblioteca.getControladorExemplar().findExemplarByCodExemplar(codExemplar);
		
		if (responsavelEmprestimo != null && exemplarEmprestimo != null &&
				controladorBiblioteca.getControladorExemplar().verificaDisponibilidade(codExemplar, codPessoa)) {
			
			try {
				dtEmprestimo = df.parse(dataEmprestimoStr);
				Calendar c = Calendar.getInstance();
				Calendar d = Calendar.getInstance();

				c.setTime(dtEmprestimo);
				d.setTime(dtEmprestimo);
				c.add(Calendar.DATE, +10);
				Date dataDevolucao = c.getTime();
				Date dataEmprestimo = d.getTime();
				
				Devolucao devolucao = new Devolucao(dataDevolucao, responsavelEmprestimo, exemplarEmprestimo);
				Emprestimo emprestimo = new Emprestimo(dataEmprestimo, responsavelEmprestimo, exemplarEmprestimo, devolucao);
			
				int qtExemplares = responsavelEmprestimo.getQuantidadeExemplares();
				responsavelEmprestimo.setQuantidadeExemplares(qtExemplares++);
				
				
				
				listaEmprestimos.add(emprestimo);
				exemplarEmprestimo.setEstaDisponivel(false);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
	}

	public void realizaDevolucaoAluno(int codPessoa, String dataEntregaStr, int codExemplar) { //realiza devolução de um aluno
		Aluno alunoDevolucao = controladorBiblioteca.getControladorPessoa().findAlunoByCodAluno(codPessoa);
		boolean disp = controladorBiblioteca.getControladorExemplar().verificaDisponibilidade(codExemplar, codPessoa);
		Exemplar exemplar = controladorBiblioteca.getControladorExemplar().findExemplarByCodExemplar(codExemplar);		
		Emprestimo emprestimo = findEmprestimoByCodExemplar(codExemplar);
		
		try {
			dtEntrega = df.parse(dataEntregaStr);
			Calendar c = Calendar.getInstance();
			c.setTime(dtEntrega);
			Date dataEntrega = c.getTime();

			Calendar d = Calendar.getInstance();
			d.setTime(emprestimo.getDataDevolucao());
			
			if (alunoDevolucao != null && !disp) {
				exemplar.setEstaDisponivel(true);
				Devolucao devolucao = new Devolucao(dataEntrega, alunoDevolucao, exemplar);

				if (dataEntrega.after(emprestimo.getDataDevolucao())) {
									
					exemplar.estaAtrasado(true);
					listaDevolucoesAtrasadas.add(devolucao);
					
					c.add(Calendar.DATE, - d.get(Calendar.DAY_OF_MONTH));
					
					int diasAtraso = (int) (c.get(Calendar.DAY_OF_MONTH));
					int multa = 0;
					if (diasAtraso>0) {
						multa = diasAtraso*10;
					}
					System.out.println("Este aluno está com o livro atrasado em "+diasAtraso+" dias e com uma multa em "+multa+" reais");
				}
				
				
				int qtExemplares = alunoDevolucao.getQuantidadeExemplares();
				alunoDevolucao.setQuantidadeExemplares(qtExemplares--);
				
				listaEmprestimos.remove(emprestimo);
				listaDevolucoes.add(devolucao);
				
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}	
	}
	
	
	
	public void realizaDevolucaoProfessor(int codPessoa, String dataEntregaStr, int codExemplar) { //realiza devolução do professor
		Professor professorDevolucao = controladorBiblioteca.getControladorPessoa().findProfessorByCodProfessor(codPessoa);
		boolean disp = controladorBiblioteca.getControladorExemplar().verificaDisponibilidade(codExemplar, codPessoa);
		Exemplar exemplar = controladorBiblioteca.getControladorExemplar().findExemplarByCodExemplar(codExemplar);		
		Emprestimo emprestimo = findEmprestimoByCodExemplar(codExemplar);
	
		try {
			dtEntrega = df.parse(dataEntregaStr);
			Calendar c = Calendar.getInstance();
			c.setTime(dtEntrega);
			Date dataEntrega = c.getTime();

			Calendar d = Calendar.getInstance();
			d.setTime(emprestimo.getDataDevolucao());
			
			if (professorDevolucao != null && !disp) {
				exemplar.setEstaDisponivel(true);
				Devolucao devolucao = new Devolucao(dataEntrega, professorDevolucao, exemplar);

				if (dataEntrega.after(emprestimo.getDataDevolucao())) {
					c.add(Calendar.DATE, - d.get(Calendar.DAY_OF_MONTH));
					
					int diasAtraso = (int) (c.get(Calendar.DAY_OF_MONTH));
					
					int multa = 0;
					if (diasAtraso>0) {
						multa = diasAtraso*10;
					}
					System.out.println("Este professor está com o livro atrasado em "+diasAtraso+" dias e com uma multa em "+multa+" reais");
				}
				
				
				int qtExemplares = professorDevolucao.getQuantidadeExemplares();
				professorDevolucao.setQuantidadeExemplares(qtExemplares--);
				
				listaEmprestimos.remove(emprestimo);
				listaDevolucoes.add(devolucao);

			
			}
			
		
			
		} catch (ParseException e) {
			e.printStackTrace();
		}	
	}
	
	public Emprestimo findEmprestimoByCodExemplar(int codExemplar) { //busca empréstimo pelo código do exemplar
		Exemplar exemplar = controladorBiblioteca.getControladorExemplar().findExemplarByCodExemplar(codExemplar);
		for (Emprestimo umEmprestimo : listaEmprestimos) {
			if (exemplar != null && umEmprestimo.getExemplarEmprestado().equals(exemplar)) {
				return umEmprestimo;
			}
		}
		return null;
	}
	
	//verifica se a Pessoa do codPessoa já tem um Empréstimo de um Exemplar da mesma Publicacao!
	
	public boolean verificaEmprestados(int codExemplar, int codPessoa) {
		Pessoa umaPessoa = controladorBiblioteca.getControladorPessoa().findPessoaByCodPessoa(codPessoa);
		
		Exemplar exemplar = controladorBiblioteca.getControladorExemplar().findExemplarByCodExemplar(codExemplar);			
		int codigoPublicacao = exemplar.getCodigoPublicacao();
		
		for (Emprestimo umEmprestimo : listaEmprestimos) {
			
			//primeira verificação: se na lista de empréstimos já tem um empréstimo da mesma publicação do codExemplar
			//segunda verificação: se o responsável por esse empréstimo é a própria pessoa
				if ( umEmprestimo.getExemplarEmprestado().getCodigoPublicacao() == codigoPublicacao && 
						umEmprestimo.getResponsavelEmprestimo().equals(umaPessoa)) {
					return true;
				}	
		}
	
	return false;
	}

	public void menuPrincipal() {
		controladorBiblioteca.iniciar();
	}

	public void relatorioAlunosAtrasados() {

		for (Devolucao devolucoes : listaDevolucoesAtrasadas) {
			if (devolucoes.getExemplarDevolvido().estaAtrasado()){
				System.out.println("Relatório de alunos atrasados");
				System.out.println("Nome"+"          "+"Código do Exemplar");
				System.out.println(devolucoes.getResponsavelDevolucao().getNome() + "         " + 
									devolucoes.getExemplarDevolvido().getCodigoExemplar());
			}
		}
	}
	

}
