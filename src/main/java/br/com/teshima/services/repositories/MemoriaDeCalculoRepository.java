package br.com.teshima.services.repositories;

import br.com.teshima.model.MemoriaDeCalculo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MemoriaDeCalculoRepository implements PanacheRepository<MemoriaDeCalculo> {

}
