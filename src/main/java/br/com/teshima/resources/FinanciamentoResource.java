package br.com.teshima.resources;

import br.com.teshima.model.Financiamento;
import br.com.teshima.services.FinanciamentoService;
import jakarta.inject.Inject;
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
    public Response criar(Financiamento financiamento){
        Financiamento novo = financiamentoService.criar(financiamento);
        return Response.status(Response.Status.CREATED).entity(novo).build();
    }

    @GET
    public Response buscarTodos(){
        List<Financiamento> lista = financiamentoService.buscarTodos();
        return Response.ok(lista).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id){
        Financiamento localizado = financiamentoService.buscarPorId(id);
        return Response.ok(localizado).build();
    }
}
