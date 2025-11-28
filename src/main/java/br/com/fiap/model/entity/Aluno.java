package br.com.fiap.model.entity;

import br.com.fiap.model.dto.AlunoDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

//Renato Luiz - RM556403

@Entity(name = "Aluno")
@Table(name = "dddj_sub_alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private Integer idade;
    private LocalDate dataDeNascimento;

    public Aluno() {
    }

    public Aluno(AlunoDTO alunoDTO) {
        this.nome = alunoDTO.nome();
        this.idade = alunoDTO.idade();
        this.dataDeNascimento = alunoDTO.dataDeNascimento();
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}