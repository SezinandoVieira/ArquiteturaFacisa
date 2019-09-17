package br.cesed.unifacisa.si.arquitetura.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cesed.unifacisa.si.arquitetura.school.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
