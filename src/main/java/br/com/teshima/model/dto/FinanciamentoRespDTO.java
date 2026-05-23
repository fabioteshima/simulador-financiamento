package br.com.teshima.model.dto;

import br.com.teshima.model.Financiamento;
import br.com.teshima.model.MemoriaDeCalculo;

import java.math.BigDecimal;
import java.util.List;

public record FinanciamentoRespDTO (
        Long id,
        BigDecimal valorTotalFinal,
        BigDecimal valorTotalJuros,
        List<MemoriaDeCalculo> memoriaDeCalculo){

    public static FinanciamentoRespDTO converteDTO(Financiamento financiamento){
        return new FinanciamentoRespDTO(
                financiamento.getId(),
                financiamento.getValorTotalFinal(),
                financiamento.getValorTotalJuros(),
                financiamento.getMemoriasDeCalculo()
        );
    }

    public static List<FinanciamentoRespDTO> converteListaDTO(List<Financiamento> lista) {
        return lista.stream()
                .map(FinanciamentoRespDTO::converteDTO)
                .toList();
    }
}
