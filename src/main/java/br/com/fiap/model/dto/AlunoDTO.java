package br.com.fiap.model.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

//Victoria Moura - RM555474

public record AlunoDTO(
        @NotBlank
        @NotNull
        String nome,

        @NotNull
        @Positive
        Integer idade,

        @PastOrPresent
        LocalDate dataDeNascimento
) {
}