package com.meuprincipe.resource;

import java.sql.SQLException;
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

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.meuprincipe.controller.LoginController;
import com.meuprincipe.model.Login;

/**
 * 
 * @author limemers Metodos rest de acesso ao webservice
 */
@RestController
@Path("/login")

public class LoginResource {

	/**
	 * 
	 * @return ArrayList<Login>
	 * 
	 * 
	 */

	@GET
	@Path("/listartodos")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Login> listarTodos() {
		return new LoginController().listarTodos();
	}

	@GET
	@Path("/listarEspecifico")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Login> listarEspecifico(@HeaderParam(value = "login_nome") String nome,
			@HeaderParam(value = "login_senha") String senha) {

		String temp = "{\"nome\": \"" + nome + "\", \"senha\": \"" + senha + "\"}";

		Gson jason = new Gson();
		Login l = (Login) jason.fromJson(temp, Login.class);
		return new LoginController().listarEspecifico(l);
	}

	@POST
	@Path("/inserir")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserirLogin(@RequestBody String content) throws SQLException {

		Gson jason = new Gson();

		Login l = (Login) jason.fromJson(content, Login.class);

		
		if (new LoginController().inserirLogin(l)) {
			return Response.status(200).entity("200").build();

		} else {
			return Response.status(500).entity("500").build();
		}
		
	}

	@POST
	@Path("/remover")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removerLogin(@RequestBody String content) throws SQLException {

		Gson jason = new Gson();

		Login l = (Login) jason.fromJson(content, Login.class);

		if (new LoginController().removerLogin(l)) {
			return Response.status(200).entity("200").build();

		} else {
			return Response.status(500).entity("500").build();
		}

	}

	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarLogin(@RequestBody String content, @HeaderParam(value = "login_nome") String nome,
			@HeaderParam(value = "login_senha") String senha) throws SQLException {

		String temp = "{\"nome\": \"" + nome + "\", \"senha\": \"" + senha + "\"}";

		Gson jason = new Gson();

		Login lo = (Login) jason.fromJson(content, Login.class);
		Login ln = (Login) jason.fromJson(temp, Login.class);
		if (new LoginController().atualizarLogin(lo, ln)) {
			return Response.status(200).entity("200").build();

		} else {
			return Response.status(500).entity("500").build();
		}

	}

}
