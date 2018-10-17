package com.meuprincipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.meuprincipe.factory.ConnectionFactory;
import com.meuprincipe.model.Produto;

public class ProdutoDAO extends ConnectionFactory {

	private static ProdutoDAO instance;

	public static ProdutoDAO getInstance() {
		if (instance == null) {
			instance = new ProdutoDAO();

		}
		return instance;
	}

	public ArrayList<Produto> listarTodos() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();

		ArrayList<Produto> produtos = null;
		produtos = new ArrayList<Produto>();

		try {
			pstmt = conexao.prepareStatement("SELECT * FROM tb_produto order by produto_id");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setProdutoId(rs.getInt("produto_id"));
				produto.setProdutoNome(rs.getString("produto_nome"));
				produto.setProdutoQuantidade(rs.getInt("produto_quantidade"));
				produto.setProdutoValor(rs.getFloat("produto_valor"));
				produto.setProdutoLicenciado(rs.getString("produto_licenciado"));
				produto.setProdutoMarca(rs.getString("produto_marca"));
				produto.setProdutoCodigo(rs.getString("produto_codigo"));
				produto.setProdutoGrade(rs.getString("produto_grade"));
				produtos.add(produto);

			}
		} catch (Exception e) {
			System.out.println("Erro ao retornar todos os dados de produtos");
			e.toString();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return produtos;

	}

	public ArrayList<Produto> listarEspecifico(Produto p) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conexao = criarConexao();

		ArrayList<Produto> produtos = null;
		produtos = new ArrayList<Produto>();

		try {
			String nomeProduto = p.getProdutoNome();
			pstmt = conexao.prepareStatement(
					"SELECT * FROM tb_produto where produto_nome like '%" + nomeProduto + "%' order by produto_id;");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setProdutoId(rs.getInt("produto_id"));
				produto.setProdutoNome(rs.getString("produto_nome"));
				produto.setProdutoQuantidade(rs.getInt("produto_quantidade"));
				produto.setProdutoValor(rs.getFloat("produto_valor"));
				produto.setProdutoLicenciado(rs.getString("produto_licenciado"));
				produto.setProdutoMarca(rs.getString("produto_marca"));
				produto.setProdutoCodigo(rs.getString("produto_codigo"));
				produto.setProdutoGrade(rs.getString("produto_grade"));
				produtos.add(produto);

			}
		} catch (Exception e) {
			System.out.println("Erro ao retornar todos os dados de produtos Especificos");
			e.toString();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return produtos;
	}

	public boolean inserirProduto(Produto p) {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		conexao = criarConexao();

		try {
			pstmt = conexao.prepareStatement(
					"INSERT INTO tb_produto(produto_nome, produto_quantidade, produto_valor, \r\n"
							+ " produto_licenciado, produto_marca, produto_codigo, produto_grade)\r\n"
							+ " VALUES (?, ?, ?, ?, ?, ?, ?);");
			pstmt.setString(1, p.getProdutoNome());
			pstmt.setInt(2, p.getProdutoQuantidade());
			pstmt.setFloat(3, p.getProdutoValor());
			pstmt.setString(4, p.getProdutoLicenciado());
			pstmt.setString(5, p.getProdutoMarca());
			pstmt.setString(6, p.getProdutoCodigo());			
			pstmt.setString(7, p.getProdutoGrade());
			pstmt.execute();

			return true;
		} catch (Exception e) {
			System.out.println("Erro ao inserir os dados de produtos");
			e.toString();
		} finally {
			fecharConexao(conexao, pstmt);
		}
		return false;
	}

	public boolean removerProduto(Produto p) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		conexao = criarConexao();

		try {
			pstmt = conexao.prepareStatement(
					"DELETE FROM tb_produto WHERE produto_nome = ? AND produto_id = ? and produto_codigo= ? ");
			pstmt.setString(1, p.getProdutoNome());
			pstmt.setInt(2, p.getProdutoId());
			pstmt.setString(3, p.getProdutoCodigo());
			pstmt.execute();

			return true;
		} catch (Exception e) {
			System.out.println("Erro ao Remover os dados de produtos");
			e.toString();
		} finally {
			fecharConexao(conexao, pstmt);
		}
		return false;
	}

	public boolean atualizarProduto(Produto po, Produto pn) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		conexao = criarConexao();
		System.out.println("Conexao aberta");
		try {

			pstmt = conexao.prepareStatement(
					"UPDATE tb_produto SET produto_nome=?, produto_quantidade=?, produto_valor=?, \r\n"
							+ "       produto_licenciado=? , produto_marca = ? ,produto_codigo =?  where produto_nome= ? and produto_id = ? and produto_codigo= ? and produto_grade = ? ;");
			pstmt.setString(1, pn.getProdutoNome());
			pstmt.setInt(2, pn.getProdutoQuantidade());
			pstmt.setFloat(3, pn.getProdutoValor());
			pstmt.setString(4, pn.getProdutoLicenciado());
			pstmt.setString(5, pn.getProdutoMarca());
			pstmt.setString(6, pn.getProdutoCodigo());
			pstmt.setString(7, po.getProdutoNome());
			pstmt.setInt(8, po.getProdutoId());
			pstmt.setString(9, po.getProdutoCodigo());
			pstmt.setString(10, po.getProdutoGrade());
			pstmt.execute();

		} catch (Exception e) {
			System.out.println("Erro ao Atualizar Produto - return false");
			e.printStackTrace();
			return false;
		} finally {
			fecharConexao(conexao, pstmt);
		}

		return true;

	}

}
