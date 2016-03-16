package Controller;

import java.util.ArrayList;
import Biblioteca.Aluno;
import Biblioteca.Disciplina;
import Biblioteca.Pessoa;
import Biblioteca.Professor;
import Biblioteca.Turma;
import Interface.TelaPessoa;

public class ControladorPessoa {

	private TelaPessoa telaPessoa;
	private ControladorBiblioteca controladorBiblioteca;
    private ArrayList<Aluno> listaAlunos;
    private ArrayList<Professor> listaProfessores;


	
	public ControladorPessoa(ControladorBiblioteca controladorBiblioteca) {
		this.controladorBiblioteca = controladorBiblioteca;
		
		listaAlunos = new ArrayList<Aluno>();
		listaProfessores = new ArrayList<Professor>();

		
	}

	public void menuPessoa() {
		telaPessoa = new TelaPessoa(this);
		telaPessoa.menuPessoa();
	}

	public void cadastroAluno(int codAluno, String nome, int idade, String endereco, String filiacao, int codigoTurma, String periodo) {
		
		boolean alunoExistente = hasAlunoByCodAluno(codAluno);
		
		if (!alunoExistente) {
			
			Turma turma = controladorBiblioteca.getControladorTurma().findTurmaByCodTurma(codigoTurma);

			if (turma != null) {
				Aluno aluno = new Aluno(codAluno, nome, idade, endereco, filiacao, turma);
		        listaAlunos.add(aluno);
			} else {
				Turma novaTurma = new Turma(codigoTurma, periodo);
				Aluno aluno = new Aluno(codAluno, nome, idade, endereco, filiacao, novaTurma);
		        listaAlunos.add(aluno);
			}
		} else {
			System.out.println("Aluno já existente");
		}
		
	}

	public void cadastroProfessor(int codProfessor, String nome, int idade, String endereco, String filiacao, String nomeDisciplina, int codDisciplina, int codTurma) {
		
		boolean professorExistente = hasProfessorByCodProfessor(codProfessor);
		
		if (!professorExistente) {
			
			Disciplina disciplina = new Disciplina (nomeDisciplina, codDisciplina);
			
			Turma turma = controladorBiblioteca.getControladorTurma().findTurmaByCodTurma(codTurma);
			
			Professor professor = new Professor(codProfessor, nome, idade, endereco, filiacao, disciplina);
			
			if (turma != null) {
				turma.setProfessorResponsavel(professor);
			} else {
				System.out.println("Código de turma inválido!");
			}
			
			listaProfessores.add(professor);
		
		} else {
			System.out.println("Professor já existente!");
		}
	}

	public Aluno findAlunoByCodAluno(Integer codAluno) {
		for (Aluno umAluno : listaAlunos) {
			if (codAluno != null && umAluno.getCodPessoa() == codAluno) {
				return umAluno;
			}
		}
		return null;
	}
	public Professor findProfessorByCodProfessor(Integer codProfessor) {
		for (Professor umProfessor : listaProfessores) {
				if (codProfessor != null && umProfessor.getCodPessoa() == codProfessor) {
					return umProfessor;
				}
		}
		return null;
	}
	
	public Pessoa findPessoaByCodPessoa(Integer codPessoa) {
		for (Aluno umAluno : listaAlunos) {
			if (codPessoa != null && umAluno.getCodPessoa() == codPessoa) {
				return umAluno;
			}
		}
		
		for (Professor umProfessor : listaProfessores) {
			if (codPessoa != null && umProfessor.getCodPessoa() == codPessoa) {
				return umProfessor;
			}
		}
			
	return null;
	}
	
	public boolean hasAlunoByCodAluno(int codAluno) {
		Aluno umAluno = findAlunoByCodAluno(codAluno);
		if (umAluno != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasProfessorByCodProfessor(int codProfessor) {
		Professor umProfessor = findProfessorByCodProfessor(codProfessor);
		if (umProfessor != null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public void menuPrincipal() {
		controladorBiblioteca.iniciar();
	}

	
	
}
