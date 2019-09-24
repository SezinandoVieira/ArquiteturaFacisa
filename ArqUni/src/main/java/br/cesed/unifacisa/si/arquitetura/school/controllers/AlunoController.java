package br.cesed.unifacisa.si.arquitetura.school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.unifacisa.si.arquitetura.school.models.Aluno;
import br.cesed.unifacisa.si.arquitetura.school.services.AlunoService;

@RestController
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@RequestMapping(value = "/aluno", method = RequestMethod.GET)
	public ResponseEntity<List<Aluno>> listarAlunos() {


		return new ResponseEntity<List<Aluno>>(alunoService.getAllAlunos(), HttpStatus.OK);
	}

	@RequestMapping(value = "aluno/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> obterAluno(@PathVariable Integer id) {

		Aluno aluno = alunoService.getById(id);

		if (aluno == null) {
			return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Aluno>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/aluno", method = RequestMethod.POST)
	public ResponseEntity<Aluno> criaAluno(@RequestBody Aluno aluno) {

		try {
			Aluno alunoCriado = alunoService.postAluno(aluno);
			return new ResponseEntity<Aluno>(alunoCriado, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Aluno>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping (value = "/aluno/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Aluno> deletaAluno(Integer id) {
		alunoService.deletAluno(id);
		return new ResponseEntity<Aluno>(HttpStatus.OK);
	}

}
