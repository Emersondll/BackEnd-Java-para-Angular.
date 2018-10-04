package com.meuprincipe.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.meuprincipe.controller.MarcaController;
import com.meuprincipe.model.Marca;

@RestController
@Path("/marca")
public class MarcaResource {

	@GET
	@Path("/listartodos")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Marca> listarTodos() {
		return new MarcaController().listarTodos();
	}

	@GET
	@Path("/listarEspecifico")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Marca> listarEspecifico(@HeaderParam(value = "nomeMarca") String nomeMarca) {
		String temp = "{\"marcaNome\": \"" + nomeMarca + "\"}";
		Gson jason = new Gson();
		Marca m = (Marca) jason.fromJson(temp, Marca.class);

		return new MarcaController().listarEspecifico(m);

	}

	@POST
	@Path("/inserir")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirMarca(@HeaderParam(value = "nomeMarca") String nomeMarca) {
		String temp = "{\"marcaNome\": \"" + nomeMarca + "\"}";
		Gson jason = new Gson();
		Marca m = (Marca) jason.fromJson(temp, Marca.class);

		if (new MarcaController().inserirMarca(m)) {
			return Response.status(200).entity("200").build();
		} else
			return Response.status(500).entity("500").build();

	}

	@POST
	@Path("/remover")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removerMarca(@HeaderParam(value = "nomeMarca") String nomeMarca) {
		String temp = "{\"marcaNome\": \"" + nomeMarca + "\"}";
		Gson jason = new Gson();
		Marca m = (Marca) jason.fromJson(temp, Marca.class);

		if (new MarcaController().removerMarca(m)) {
			return Response.status(200).entity("200").build();
		} else
			return Response.status(500).entity("500").build();

	}

	@PUT
	@Path("/atualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarMarca(@HeaderParam(value = "nomeMarcaOr") String nomeMarcaO,
			@HeaderParam(value = "nomeMarcaNv") String nomeMarcaN) {
		String temp = "{\"marcaNome\": \"" + nomeMarcaO + "\"}";
		String temp2 = "{\"marcaNome\": \"" + nomeMarcaN + "\"}";

		Gson jason = new Gson();
		Marca mo = (Marca) jason.fromJson(temp, Marca.class);
		Marca mn = (Marca) jason.fromJson(temp2, Marca.class);

		if (new MarcaController().atualizarMarca(mo, mn)) {
			return Response.status(200).entity("200").build();
		} else
			return Response.status(500).entity("500").build();

	}

}
