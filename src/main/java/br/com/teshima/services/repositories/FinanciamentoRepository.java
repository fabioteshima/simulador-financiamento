package br.com.teshima.services.repositories;

import br.com.teshima.model.Financiamento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FinanciamentoRepository implements PanacheRepository<Financiamento> {

}
