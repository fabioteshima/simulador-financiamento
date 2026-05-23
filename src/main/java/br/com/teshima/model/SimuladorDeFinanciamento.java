package br.com.teshima.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class SimuladorDeFinanciamento {

    public Financiamento processarJuros(Financiamento financiamento){
        LocalDate dataSimulacao = LocalDate.now().plusMonths(1);
        BigDecimal valorInicial = financiamento.getValorInicial();
        BigDecimal valorTotalJuros = BigDecimal.ZERO;

        for (int i = 0; i < financiamento.getPrazoMeses(); i++) {
            BigDecimal valorJurosMes = valorInicial.
                    multiply(BigDecimal.valueOf(financiamento.getTaxaJurosMensal() / 100))
                    .setScale(2, RoundingMode.HALF_UP);
            BigDecimal valorFinalMes = valorInicial
                    .add(valorJurosMes)
                    .setScale(2, RoundingMode.HALF_UP);

            valorTotalJuros = valorTotalJuros
                    .add(valorJurosMes)
                    .setScale(2, RoundingMode.HALF_UP)
            ;

            MemoriaDeCalculo memoriaDeCalculo = gerarMemoriaDeCalculo(
                    valorInicial, dataSimulacao, valorJurosMes, valorFinalMes);

            financiamento.getMemoriaDeCalculos().add(memoriaDeCalculo);

            valorInicial = valorFinalMes;
            dataSimulacao = dataSimulacao.plusMonths(1);
            financiamento.setValorTotalJuros(valorTotalJuros);
        }
        return financiamento;
    }

    public Financiamento simularFinanciamento(Financiamento financiamento){
        if(dadosValidos(financiamento)){
            financiamento = processarJuros(financiamento);
            BigDecimal valorFinal = financiamento.getValorInicial()
                    .add(financiamento.getValorTotalJuros())
                    .setScale(2, RoundingMode.HALF_UP);
            financiamento.setValorTotalFinal(valorFinal);
            return financiamento;
        }
        else {
            throw new IllegalArgumentException("Dados inválidos. Valores devem ser maior do que O");
        }
    }

    private MemoriaDeCalculo gerarMemoriaDeCalculo(BigDecimal valorInicial, LocalDate data, BigDecimal valorJurosMes, BigDecimal valorFinalMes) {
        MemoriaDeCalculo memoria = new MemoriaDeCalculo();
        memoria.setValorInicial(valorInicial);
        memoria.setData(data);
        memoria.setValorJurosMes(valorJurosMes);
        memoria.setValorSaldoFinalMes(valorFinalMes);
        return memoria;
    }

    private boolean dadosValidos(Financiamento financiamento){
        if(financiamento.getValorInicial().compareTo(BigDecimal.ZERO) <= 0 ||
            financiamento.getPrazoMeses() <= 0 || financiamento.getTaxaJurosMensal() <= 0){
            return false;
        }
        return true;
    }
}
