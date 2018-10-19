package com.meuprincipe.controller;

import java.util.ArrayList;

import com.meuprincipe.dao.ProdutoDAO;
import com.meuprincipe.model.Produto;

/**
 * 
 * @author limemers Classe produtos controller
 */

public class ProdutoController {

	public ArrayList<Produto> listarTodos() {
		return ProdutoDAO.getInstance().listarTodos();
	}

	public ArrayList<Produto> listarEspecifico(Produto p) {
		return ProdutoDAO.getInstance().listarEspecifico(p);
	}

	public boolean inserirProduto(Produto p) {
		return ProdutoDAO.getInstance().inserirProduto(p);
	}

	public boolean removerProduto(Produto p) {
		return ProdutoDAO.getInstance().removerProduto(p);
	}

	public boolean atualizarProduto(Produto po) {
		return ProdutoDAO.getInstance().atualizarProduto(po);
	}

}
