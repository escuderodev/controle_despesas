package br.com.escuderodev.controle_despesa.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroDespesa(
        @NotBlank
        String descricao,
        @NotNull
        BigDecimal valor,
        LocalDate dataVencimento,
        LocalDate dataPagamento) {
}
