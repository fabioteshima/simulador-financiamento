//package br.com.teshima.services;
//
//import br.com.teshima.model.Financiamento;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.math.BigDecimal;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(MockitoExtension.class)
//public class FinanciamentoServiceTest {
//
//    Financiamento financiamento;
//
//    FinanciamentoService financiamentoService;
//
//    @BeforeEach
//    void setUp(){
//        financiamento = new Financiamento();
//        financiamentoService = new FinanciamentoService();
//    }
//
//    @Test
//    void deveCalcularJurosTotalFinal(){
//        financiamento.setValorInicial(BigDecimal.valueOf(1000.00));
//        financiamento.setPrazoMeses(10);
//        financiamento.setTaxaJurosMensal(1.0);
//
//        BigDecimal total = financiamentoService.calcularJurosTotal(financiamento);
//        assertEquals(0, BigDecimal.valueOf(100).compareTo(total));
//    }
//
//    @Test
//    void deveCalcularValorTotalFinal() {
//        financiamento.setValorInicial(BigDecimal.valueOf(1000.00));
//        financiamento.setPrazoMeses(10);
//        financiamento.setTaxaJurosMensal(1.0);
//
//        BigDecimal total = financiamentoService.calcularValorTotal(financiamento);
//        assertEquals(0, BigDecimal.valueOf(1100).compareTo(total));
//    }
//
//}
