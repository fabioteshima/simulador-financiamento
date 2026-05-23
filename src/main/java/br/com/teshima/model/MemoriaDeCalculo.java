package br.com.teshima.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MemoriaDeCalculo {

    private BigDecimal valorInicial;
    private LocalDate data;
    private BigDecimal valorJurosMes;
    private BigDecimal valorSaldoFinalMes;

    public MemoriaDeCalculo(){
    }

    public MemoriaDeCalculo(BigDecimal valorInicial, LocalDate data, BigDecimal valorJurosMes, BigDecimal valorSaldoFinalMes) {
        this.valorInicial = valorInicial;
        this.data = data;
        this.valorJurosMes = valorJurosMes;
        this.valorSaldoFinalMes = valorSaldoFinalMes;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorJurosMes() {
        return valorJurosMes;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setValorJurosMes(BigDecimal valorJurosMes) {
        this.valorJurosMes = valorJurosMes;
    }

    public BigDecimal getValorSaldoFinalMes() {
        return valorSaldoFinalMes;
    }

    public void setValorSaldoFinalMes(BigDecimal valorSaldoFinalMes) {
        this.valorSaldoFinalMes = valorSaldoFinalMes;
    }

    @Override
    public String toString() {
        return  "\n valorInicial=" + valorInicial +
                "\n data=" + data +
                "\n valorJurosMes=" + valorJurosMes +
                "\n valorSaldoFinalMes=" + valorSaldoFinalMes +
                "\n";
    }
}

