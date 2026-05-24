package br.com.teshima.services;

import br.com.teshima.exceptions.ServiceException;
import br.com.teshima.model.Financiamento;
import br.com.teshima.model.MemoriaDeCalculo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class SimuladorDeFinanciamento {

    public Financiamento simularFinanciamento(Financiamento financiamento) {
        if (dadosValidos(financiamento)) {
            processarTotal(financiamento);
            return financiamento;
        } else {
            throw new ServiceException("Dados inválidos. Valores devem ser maior do que 0");
        }
    }

    public Financiamento processarJuros(Financiamento financiamento){
        LocalDate dataBase = LocalDate.now().plusMonths(1);
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
                    dataBase, valorInicial, valorJurosMes, valorFinalMes);

            memoriaDeCalculo.setFinanciamento(financiamento);
            financiamento.getMemoriasDeCalculo().add(memoriaDeCalculo);

            valorInicial = valorFinalMes;
            dataBase = dataBase.plusMonths(1);
            financiamento.setValorTotalJuros(valorTotalJuros);
        }
        return financiamento;
    }

    public Financiamento processarTotal(Financiamento financiamento){
            financiamento = processarJuros(financiamento);
            BigDecimal valorFinal = financiamento.getValorInicial()
                    .add(financiamento.getValorTotalJuros())
                    .setScale(2, RoundingMode.HALF_UP);
            financiamento.setValorTotalFinal(valorFinal);
            return financiamento;
    }

    public MemoriaDeCalculo gerarMemoriaDeCalculo(LocalDate data, BigDecimal valorInicial, BigDecimal valorJurosMes, BigDecimal valorFinalMes) {
        return new MemoriaDeCalculo(
                data, valorInicial, valorJurosMes, valorFinalMes);
    }

    public boolean dadosValidos(Financiamento financiamento){
        return financiamento.getValorInicial().compareTo(BigDecimal.ZERO) > 0 &&
                financiamento.getPrazoMeses() > 0 &&
                financiamento.getTaxaJurosMensal() > 0;
    }
}
