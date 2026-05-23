package br.com.teshima.services;

import br.com.teshima.model.Financiamento;
import br.com.teshima.model.SimuladorDeFinanciamento;
import br.com.teshima.services.repositories.FinanciamentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class FinanciamentoService {

    @Inject
    FinanciamentoRepository financiamentoRepository;

    @Transactional
    public Financiamento criar(Financiamento financiamento){
        SimuladorDeFinanciamento simulador = new SimuladorDeFinanciamento();
        financiamento = simulador.simularFinanciamento(financiamento);
        financiamentoRepository.persist(financiamento);
        return financiamento;
    }

    public List<Financiamento> buscarTodos(){
        List<Financiamento> listaFinanciamentos = financiamentoRepository.findAll().stream().toList();
        return listaFinanciamentos;
    }

    public Financiamento buscarPorId(Long id){
        Financiamento financiamento = financiamentoRepository.findById(id);
        return financiamento;
    }
}
