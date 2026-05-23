package br.com.teshima.services;

import br.com.teshima.model.Financiamento;
import br.com.teshima.model.SimuladorDeFinanciamento;
import jakarta.enterprise.context.ApplicationScoped;

public class FinanciamentoService {

    public Financiamento criar(Financiamento financiamento){
        SimuladorDeFinanciamento simulador = new SimuladorDeFinanciamento();
        financiamento = simulador.simularFinanciamento(financiamento);

    }

}
