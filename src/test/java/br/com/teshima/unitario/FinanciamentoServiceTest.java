package br.com.teshima.unitario;

import br.com.teshima.model.Financiamento;
import br.com.teshima.services.FinanciamentoService;
import br.com.teshima.services.repositories.FinanciamentoRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FinanciamentoServiceTest {

    @Mock
    FinanciamentoRepository repositoryMock;

    @InjectMocks
    FinanciamentoService service;

    @Test
    void deveBuscarTodosFinanciamentosSimulados() {
        Financiamento f1 = new Financiamento(BigDecimal.valueOf(1000), 1, 1.0);
        Financiamento f2 = new Financiamento(BigDecimal.valueOf(2000), 2, 2.0);

        PanacheQuery<Financiamento> queryMock = Mockito.mock(PanacheQuery.class);
        when(repositoryMock.findAll()).thenReturn(queryMock);
        when(queryMock.stream()).thenReturn(List.of(f1, f2).stream());

        List<Financiamento> resultado = service.buscarTodos();

        Assertions.assertEquals(2, resultado.size());
        Assertions.assertTrue(resultado.contains(f1));
        Assertions.assertTrue(resultado.contains(f2));
    }

    @Test
    void deveBuscarFinanciamentosSimuladosPorId(){
        Financiamento f = new Financiamento(BigDecimal.valueOf(1000), 1, 1.0);
        f.setId(1l);

        when(repositoryMock.findById(1l)).thenReturn(f);

        Financiamento resultado = service.buscarPorId(1l);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(1L, resultado.getId());
        Assertions.assertEquals(BigDecimal.valueOf(1000), resultado.getValorInicial());
        Assertions.assertEquals(1, resultado.getPrazoMeses());
        Assertions.assertEquals(1.0, resultado.getTaxaJurosMensal());
    }

    @Test
    void deveCriarNovaSimulacaoDeFinanciamento(){
        Financiamento f = new Financiamento(BigDecimal.valueOf(1000), 1, 1.0);

        Mockito.doNothing().when(repositoryMock).persist(f);

        Financiamento resultado = service.criar(f);

        Assertions.assertNotNull(resultado.getValorTotalFinal());
        Mockito.verify(repositoryMock).persist(f);
    }
}
