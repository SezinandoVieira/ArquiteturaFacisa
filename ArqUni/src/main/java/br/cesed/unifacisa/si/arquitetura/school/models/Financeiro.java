package br.cesed.unifacisa.si.arquitetura.school.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Financeiro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToMany
	private List<Aluno> alunos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List <Aluno> getAlunos() {
		return alunos;
	}

	public void setAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

}
