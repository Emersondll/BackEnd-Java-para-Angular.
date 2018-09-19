package com.meuprincipe.controller;

import java.util.ArrayList;

import com.meuprincipe.dao.MarcaDAO;
import com.meuprincipe.model.Marca;

public class MarcaController  {
	
	public ArrayList<Marca> listarTodos(){
		return MarcaDAO.getInstance().listarTodos();
	}

	public ArrayList<Marca> listarEspecifico(Marca m) {
		return MarcaDAO.getInstance().listarEspecifico(m);
	}

	public boolean inserirMarca(Marca m) {
		return MarcaDAO.getInstance().inserirMarca(m);
	}

	public boolean removerMarca(Marca m) {
		return MarcaDAO.getInstance().removerMarca(m);
	}

	public boolean atualizarMarca(Marca mo, Marca mn) {
		return MarcaDAO.getInstance().atualizarMarca(mo, mn);
	}

}
