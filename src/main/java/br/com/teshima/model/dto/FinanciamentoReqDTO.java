package br.com.teshima.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;


import java.math.BigDecimal;

public record FinanciamentoReqDTO (


        @NotNull(message = "O valor inicial não pode ser nulo")
        @DecimalMin(value = "0.01", message = "O valor inicial deve ser maior que 0")
        BigDecimal valorInicial,

        @NotNull(message = "O prazo não pode ser nulo")
        @Min(value = 1, message = "O prazo deve ser maior que 0")
        Integer prazoMeses,

        @NotNull(message = "A taxa de juros não pode ser nulo")
        @DecimalMin(value = "0.01", message = "A taxa de juros deve ser maior que 0")
        Double taxaJurosMensal
) {
}
