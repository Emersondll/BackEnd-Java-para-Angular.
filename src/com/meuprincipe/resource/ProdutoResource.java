package com.meuprincipe.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
/**
 * 
 * @author limemers
 * Metodos rest de acesso ao webservice
 */
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;
import com.meuprincipe.controller.ProdutoController;
import com.meuprincipe.model.Produto;

@Path("/produto")
public class ProdutoResource {

	@GET
	@Path("/listartodos")
	@Produces("application/json")
	public ArrayList<Produto> listarTodos() {
		return new ProdutoController().listarTodos();
	}

	@GET
	@Path("/listarEspecifico")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Produto> listarEspecifico(@HeaderParam(value = "produtoNome") String nome) {

		String temp = "{\"produtoNome\": \"" + nome + "\"}";

		Gson jason = new Gson();
		Produto p = (Produto) jason.fromJson(temp, Produto.class);
		return new ProdutoController().listarEspecifico(p);
	}

	@POST
	@Path("/inserir")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserirProduto(@RequestBody String content) throws SQLException {

		Gson jason = new Gson();

		Produto p = (Produto) jason.fromJson(content, Produto.class);

		if (new ProdutoController().inserirProduto(p)) {
			return Response.status(200).entity("200").build();

		} else {
			return Response.status(500).entity("500").build();
		}

	}

	@POST
	@Path("/remover")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removerProduto(@RequestBody String content) throws SQLException {

		Gson jason = new Gson();

		Produto p = (Produto) jason.fromJson(content, Produto.class);

		if (new ProdutoController().removerProduto(p)) {
			return Response.status(200).entity("200").build();

		} else {
			return Response.status(500).entity("500").build();
		}
	}

	@POST
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarProduto(@RequestBody String content) throws SQLException {

		Gson jason = new Gson();

 		Produto po = (Produto) jason.fromJson(content, Produto.class);
		if (new ProdutoController().atualizarProduto(po)) {
			return Response.status(200).entity("200").build();

		} else {
			return Response.status(500).entity("500").build();
		}

	}
}
