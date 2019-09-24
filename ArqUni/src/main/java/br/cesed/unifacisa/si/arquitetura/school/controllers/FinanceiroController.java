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

import br.cesed.unifacisa.si.arquitetura.school.models.Financeiro;
import br.cesed.unifacisa.si.arquitetura.school.services.FinanceiroService;

@RestController
public class FinanceiroController {

	@Autowired
	private FinanceiroService financeiroService;
	
	@RequestMapping (value = "financeiro", method = RequestMethod.GET)
	public ResponseEntity<List<Financeiro>> listarFinanceiro(){
		
		List<Financeiro> listarFinanceiro = financeiroService.getAllFinanceiro();
		
		return new ResponseEntity<List<Financeiro>> (listarFinanceiro, HttpStatus.OK);
	}
	
	@RequestMapping (value = "financeiro/{id}")
	public ResponseEntity<Financeiro> obterFinanceiro (@PathVariable Integer id){
		
		Financeiro fin = financeiroService.getById(id);
		
		if (fin == null) {
			return new ResponseEntity<Financeiro> (HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Financeiro> (HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/financeiro", method = RequestMethod.POST)
	public ResponseEntity<Financeiro> criaFinanceiro(@RequestBody Financeiro financeiro) {

		try {
			Financeiro financeiroCriado = financeiroService.postFinanceiro(financeiro);
			return new ResponseEntity<Financeiro>(financeiroCriado, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Financeiro>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping (value = "/financeiro/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Financeiro> deletaFinanceiro(Integer id) {
		financeiroService.deletFinanceiro(id);;
		return new ResponseEntity<Financeiro>(HttpStatus.OK);
	}
	
	public ResponseEntity<Financeiro> mostrarStatus (Integer id){
		return new ResponseEntity<Financeiro>(HttpStatus.OK);
	}
	
}
