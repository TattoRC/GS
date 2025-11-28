package br.com.fiap.model.repository;

import br.com.fiap.model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

//Renato Luiz - RM556403

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findByCodigo(Long codigo);
}