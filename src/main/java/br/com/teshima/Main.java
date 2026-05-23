package br.com.teshima;

import br.com.teshima.model.SimuladorDeFinanciamento;
import br.com.teshima.model.Financiamento;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Financiamento financiamento = new Financiamento(BigDecimal.valueOf(1000), 1, 1.5);

        SimuladorDeFinanciamento calculadora = new SimuladorDeFinanciamento();

        Financiamento resultado = calculadora.simularFinanciamento(financiamento);

        System.out.println(resultado);
    }
}
