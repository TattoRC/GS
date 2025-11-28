package br.com.fiap.model.repository;

import br.com.fiap.model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

//Victoria Moura - RM555474

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findByCodigo(Long codigo);
}