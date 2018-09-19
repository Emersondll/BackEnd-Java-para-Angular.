package com.meuprincipe.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.meuprincipe.dao.LoginDAO;
import com.meuprincipe.model.Login;

/**
 * 
 * @author limemers Metodo responsavel pelo controlador entre o resource e a
 *         camada Dao
 */
public class LoginController {

	public ArrayList<Login> listarTodos() {
		return LoginDAO.getInstance().listarTodos();
	}

	public ArrayList<Login> listarEspecifico(Login l) {
		return LoginDAO.getInstance().listarEspecifico(l);
	}

	public boolean inserirLogin(Login l) throws SQLException {
		return LoginDAO.getInstance().inserirLogin(l);
	}

	public boolean removerLogin(Login l) throws SQLException {
		return LoginDAO.getInstance().removerLogin(l);
	}

	public boolean atualizarLogin(Login l, Login l2) throws SQLException {
		return LoginDAO.getInstance().atualizarLogin(l, l2);
	}

}
