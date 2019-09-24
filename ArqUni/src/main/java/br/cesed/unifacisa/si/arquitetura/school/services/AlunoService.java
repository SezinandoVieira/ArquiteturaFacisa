package br.cesed.unifacisa.si.arquitetura.school.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.unifacisa.si.arquitetura.school.models.Aluno;
import br.cesed.unifacisa.si.arquitetura.school.repositories.AlunoRepository;

@Service
@Validated
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno getById (Integer id) {
		return alunoRepository.findOne(id);
	}
	
	
	public List<Aluno> getAllAlunos(){
		return alunoRepository.findAll();
	}
	
	@Transactional
	public Aluno postAluno (Aluno aluno) throws Exception {
		FinanceiroService financeiroService = new FinanceiroService();
		if(financeiroService.verificarStatus(aluno.getId()) == true) {
			return alunoRepository.save(aluno);
		} else {
			throw new Exception();
		}
		
	}
	
	public void deletAluno (Integer id) {
		alunoRepository.delete(id);
	}
}
