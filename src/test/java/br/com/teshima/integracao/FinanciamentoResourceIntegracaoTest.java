package br.com.teshima.integracao;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class FinanciamentoResourceIntegracaoTest {

    @Test
    void deveCriarNovaSimulacaoDeFinanciamento() {
        given()
                .contentType(ContentType.JSON)
                .body("""
                {
                  "valorInicial": 1000,
                  "prazoMeses": 1,
                  "taxaJurosMensal": 1.0
                }
                """)
                .when().post("/financiamentos")
                .then()
                .statusCode(201)
                .body("valorTotalFinal", equalTo(new BigDecimal("1010.00").setScale(2).floatValue()));
    }

    @Test
    void deveBuscarTodosOsFinanciamentos() {
        // Primeiro cria um para garantir que a lista não esteja vazia
        given()
                .contentType(ContentType.JSON)
                .body("""
                { "valorInicial": 500, "prazoMeses": 6, "taxaJurosMensal": 1.0 }
                """)
                .post("/financiamentos");

        given()
                .when().get("/financiamentos")
                .then()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(1));
    }

    @Test
    void deveBuscarFinanciamentoPorIdExistente() {
        // Cria um financiamento e pega o ID retornado
        Integer id = given()
                .contentType(ContentType.JSON)
                .body("""
                { "valorInicial": 1000, "prazoMeses": 1, "taxaJurosMensal": 1.0 }
                """)
                .post("/financiamentos")
                .then()
                .extract().path("id");

        given()
                .when().get("/financiamentos/" + id)
                .then()
                .statusCode(200)
                .body("id", is(id));
    }

    @Test
    void deveRetornar404ParaIdInexistente() {
        given()
                .when().get("/financiamentos/99999")
                .then()
                .statusCode(404);
    }
}