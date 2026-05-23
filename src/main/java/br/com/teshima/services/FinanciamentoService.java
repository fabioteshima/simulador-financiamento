package br.com.teshima.services;

import br.com.teshima.model.Financiamento;
import br.com.teshima.model.SimuladorDeFinanciamento;
import br.com.teshima.services.repositories.FinanciamentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FinanciamentoService {

    @Inject
    FinanciamentoRepository financiamentoRepository;

    public Financiamento criar(Financiamento financiamento){
        SimuladorDeFinanciamento simulador = new SimuladorDeFinanciamento();
        financiamento = simulador.simularFinanciamento(financiamento);
        financiamentoRepository.persist(financiamento);
        return financiamento;
    }

}
