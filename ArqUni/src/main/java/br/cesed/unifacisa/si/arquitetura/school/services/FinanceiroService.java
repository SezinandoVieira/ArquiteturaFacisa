package br.cesed.unifacisa.si.arquitetura.school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.cesed.unifacisa.si.arquitetura.school.models.Financeiro;
import br.cesed.unifacisa.si.arquitetura.school.repositories.FinanceiroRepository;

@Service
@Validated
public class FinanceiroService {

	@Autowired
	private FinanceiroRepository financeiroRepository;

	public Financeiro getById(Integer id) {
		return financeiroRepository.getOne(id);
	}

	public List<Financeiro> getAllFinanceiro() {
		return financeiroRepository.findAll();
	}

	public Financeiro postFinanceiro(Financeiro financeiro) {
		return financeiroRepository.save(financeiro);
	}

	public boolean verificarStatus(Integer id) {
		AlunoService alunoService = new AlunoService();
		boolean status = false;
		if (alunoService.getById(id).isStatus() == true) {
			status = true;
		}
		return status;
	}
	
	public void deletFinanceiro (Integer id) {
		financeiroRepository.delete(id);
	}
}
