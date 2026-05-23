package br.com.teshima.resources;

import br.com.teshima.model.Financiamento;
import br.com.teshima.model.dto.FinanciamentoReqDTO;
import br.com.teshima.services.FinanciamentoService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/financiamentos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FinanciamentoResource {

    @Inject
    FinanciamentoService financiamentoService;

    @POST
    public Response criar(@Valid FinanciamentoReqDTO dto){
        Financiamento novo = new Financiamento();
        novo.setValorInicial(dto.valorInicial());
        novo.setPrazoMeses(dto.prazoMeses());
        novo.setTaxaJurosMensal(dto.taxaJurosMensal());
        financiamentoService.criar(novo);
        return Response.status(Response.Status.CREATED).entity(novo).build();
    }

    @GET
    public Response buscarTodos(){
            List<Financiamento> lista = financiamentoService.buscarTodos();
            if(!lista.isEmpty()) {
                return Response.ok(lista).build();
            }
            else{
                return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id){
        Financiamento localizado = financiamentoService.buscarPorId(id);
        if(localizado != null){
            return Response.ok(localizado).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
