package br.com.teshima.model;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Financiamento {

    private Long id;
    private BigDecimal valorInicial;
    private Integer prazoMeses;
    private Double taxaJurosMensal;
    private BigDecimal valorTotalJuros;
    private BigDecimal valorTotalFinal;

    private List<MemoriaDeCalculo> memoriasDeCalculo = new ArrayList<>();

    public Financiamento(){
    }

    public Financiamento(BigDecimal valorInicial, Integer prazoMeses, Double taxaJurosMensal) {
        this.valorInicial = valorInicial;
        this.prazoMeses = prazoMeses;
        this.taxaJurosMensal = taxaJurosMensal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Integer getPrazoMeses() {
        return prazoMeses;
    }

    public void setPrazoMeses(Integer prazoMeses) {
        this.prazoMeses = prazoMeses;
    }

    public Double getTaxaJurosMensal() {
        return taxaJurosMensal;
    }

    public void setTaxaJurosMensal(Double taxaJurosMensal) {
        this.taxaJurosMensal = taxaJurosMensal;
    }

    public BigDecimal getValorTotalFinal() {
        return valorTotalFinal;
    }

    public void setValorTotalFinal(BigDecimal valorTotalFinal) {
        this.valorTotalFinal = valorTotalFinal;
    }

    public BigDecimal getValorTotalJuros() {
        return valorTotalJuros;
    }

    public void setValorTotalJuros(BigDecimal valorTotalJuros) {
        this.valorTotalJuros = valorTotalJuros;
    }

    public List<MemoriaDeCalculo> getMemoriaDeCalculos() {
        return memoriasDeCalculo;
    }

    @Override
    public String toString() {
        return "Financiamento{" +
                "\n id=" + id +
                "\n valorInicial=" + valorInicial +
                "\n prazoMeses=" + prazoMeses +
                "\n taxaJurosMensal=" + taxaJurosMensal +
                "\n valorTotalFinal=" + valorTotalFinal +
                "\n valorTotalJuros=" + valorTotalJuros +
                "\n memoriaDeCalculos=" + memoriasDeCalculo +
                '}';
    }
}
