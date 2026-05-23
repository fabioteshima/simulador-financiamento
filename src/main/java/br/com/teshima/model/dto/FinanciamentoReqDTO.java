package br.com.teshima.model.dto;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

public record FinanciamentoReqDTO (

        @NotNull
        @DecimalMin(value = "0.01", message = "O valor inicial deve ser maior que 0")
        BigDecimal valorInicial,

        @NotNull
        @Min(value = 1, message = "O prazo deve ser maior que 0")
        Integer prazoMeses,

        @NotNull
        @DecimalMin(value = "0.01", message = "A taxa de juros deve ser maior que 0")
        Double taxaJurosMensal
) {
}
