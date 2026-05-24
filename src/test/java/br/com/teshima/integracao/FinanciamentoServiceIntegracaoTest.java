package br.com.teshima.integracao;

import br.com.teshima.model.Financiamento;
import br.com.teshima.services.FinanciamentoService;
import br.com.teshima.services.repositories.FinanciamentoRepository;
import br.com.teshima.services.repositories.MemoriaDeCalculoRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

@QuarkusTest
public class FinanciamentoServiceIntegracaoTest {

    @Inject
    FinanciamentoService service;

    @Inject
    FinanciamentoRepository finRepository;

    @Inject
    MemoriaDeCalculoRepository menRepositoy;

    @BeforeEach
    @Transactional
    void limparBanco(){
        menRepositoy.deleteAll();
        finRepository.deleteAll();
    }

    @Test
    @TestTransaction
    void deveBuscarListaDeFinanciamentosSimulados(){
        Financiamento f1 = new Financiamento(BigDecimal.valueOf(1000), 1, 1.0);
        Financiamento f2 = new Financiamento(BigDecimal.valueOf(2000), 2, 2.0);
        service.criar(f1);
        service.criar(f2);

        List<Financiamento>listaRetornada = service.buscarTodos();

        Assertions.assertNotNull(listaRetornada);
        Assertions.assertEquals(2, listaRetornada.size());
    }

    @Test
    @TestTransaction
    void deveBuscarSimulacaoDeFinanciamentoPorId(){
        Financiamento f1 = new Financiamento(BigDecimal.valueOf(1000), 1, 1.0);

        Financiamento financiamentoSalvo =  service.criar(f1);

        Financiamento resultado = service.buscarPorId(financiamentoSalvo.getId());

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(financiamentoSalvo.getId(), resultado.getId());
    }

    @Test
    @TestTransaction
    void deveCriarNovaSimulacaoDeFinanciamento(){
        Financiamento f1 = new Financiamento(BigDecimal.valueOf(1000), 1, 1.0);

        Financiamento resultado = service.criar(f1);

        Assertions.assertNotNull(f1);
        Assertions.assertEquals(BigDecimal.valueOf(1010).setScale(2), resultado.getValorTotalFinal());
    }
}
