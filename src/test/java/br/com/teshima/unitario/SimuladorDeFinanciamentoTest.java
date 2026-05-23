package br.com.teshima.unitario;

import br.com.teshima.exceptions.ServiceException;
import br.com.teshima.model.Financiamento;
import br.com.teshima.model.SimuladorDeFinanciamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class SimuladorDeFinanciamentoTest {

    SimuladorDeFinanciamento simuladorDeFinanciamento = new SimuladorDeFinanciamento();

    @Test
    void deveVerificarDadosDeEntradaValidos(){
        Financiamento f = new Financiamento(BigDecimal.valueOf(1000), 1, 1.0);
        boolean validado = simuladorDeFinanciamento.dadosValidos(f);
        Assertions.assertTrue(validado);
    }

    @Test
    void deveFalharComValorInicialZerado(){
        Financiamento f = new Financiamento(BigDecimal.valueOf(0), 1, 1.0);
        boolean validado = simuladorDeFinanciamento.dadosValidos(f);
        Assertions.assertFalse(validado);
    }

    @Test
    void deveFalharComValorDePrazoZerado(){
        Financiamento f = new Financiamento(BigDecimal.valueOf(1000), 0, 1.0);
        boolean validado = simuladorDeFinanciamento.dadosValidos(f);
        Assertions.assertFalse(validado);
    }

    @Test
    void deveFalharComValorDaTaxaDeJurosZerado(){
        Financiamento f = new Financiamento(BigDecimal.valueOf(1000), 1, 0.0);
        boolean validado = simuladorDeFinanciamento.dadosValidos(f);
        Assertions.assertFalse(validado);
    }

    @Test
    void deveCalcularValorDosJurosCorretamente() {
        Financiamento f = new Financiamento(BigDecimal.valueOf(1000), 1, 1.0);
        Financiamento resultado = simuladorDeFinanciamento.processarJuros(f);
        Assertions.assertEquals(BigDecimal.valueOf(10).setScale(2), resultado.getValorTotalJuros());
    }

    @Test
    void deveCalcularValorTotalCorretamente(){
        Financiamento f = new Financiamento(BigDecimal.valueOf(1000), 1, 1.0);
        Financiamento resultado = simuladorDeFinanciamento.processarTotal(f);
        Assertions.assertEquals(BigDecimal.valueOf(1010).setScale(2), resultado.getValorTotalFinal());
    }

    @Test
    void deveSimularFinanciamentoComDadosValidos(){
        Financiamento f = new Financiamento(BigDecimal.valueOf(1000), 1, 1.0);
        Financiamento resultado = simuladorDeFinanciamento.simularFinanciamento(f);
        Assertions.assertEquals(BigDecimal.valueOf(1010).setScale(2), resultado.getValorTotalFinal());
    }

    @Test
    void deveFalharFinanciamentoComDadosInválidos() {
        Financiamento f = new Financiamento(BigDecimal.valueOf(1000), 1, 0.0);
        ServiceException exception = Assertions.assertThrows(ServiceException.class,
                () -> simuladorDeFinanciamento.simularFinanciamento(f));
        Assertions.assertEquals("Dados inválidos. Valores devem ser maior do que O", exception.getMessage());
    }
}

